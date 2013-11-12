package br.com.webhomebeta.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.MoradorControllerBean;
import br.com.webhomebeta.entity.Comentario;

import br.com.webhomebeta.entity.Enquetes;
import br.com.webhomebeta.entity.Gostou;
import br.com.webhomebeta.entity.NaoGostou;
import br.com.webhomebeta.entity.Opcao;
import br.com.webhomebeta.entity.OpcaoVotada;
import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.ComentarioJSON;

import br.com.webhomebeta.json.JsonPublicacao;

import br.com.webhomebeta.json.EnqueteJSON;
import br.com.webhomebeta.json.GostouJSON;
import br.com.webhomebeta.json.NaoGostouJSON;
import br.com.webhomebeta.json.NovaPublicacaoJSON;
import br.com.webhomebeta.json.NovoComentarioJSON;
import br.com.webhomebeta.json.OpcaoJSON;
import br.com.webhomebeta.json.OpcaoVotadaJSON;
import br.com.webhomebeta.json.UsuarioPublicacaoJSON;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.EnquetesService;
import br.com.webhomebeta.service.NotificacaoService;
import br.com.webhomebeta.service.OpcaoService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class HomeController {

	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MoradorControllerBean moradorControllerBean;
	@Autowired
	private NotificacaoService notificacaoService;
	@Autowired
	private EnquetesService enquetesService;
	@Autowired
	private OpcaoService opcaoService;

	private int colunaInicial;

	// Inicializa a pagina com todos os parametros necessarios
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		
		Usuario usuario = getUsuario();

		moradorControllerBean.setUsuario(getUsuario());

		model.put("moradorControllerBean", moradorControllerBean);

		model.put("listaEnquetes", getEnquetes(usuario));
		model.put("listaEnquetesVotadas", getEnquetesVotadas(usuario));
		model.put("usuario", usuario);

		colunaInicial = 0;

		return new ModelAndView("home", model);
	}

	public ComentarioJSON atualizarComentario() {
		return null;
	}

	@RequestMapping(value = "home/publicacao?id={idPublicacao}", method = RequestMethod.POST)
	public @ResponseBody
	JsonPublicacao visualizaNotificacao(@PathVariable("idPublicacao") int id) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Publicacao publicacao = publicacaoService.getUnicaPublicacao(id);
		JsonPublicacao jsonPublicacao = new JsonPublicacao(
				publicacao.getPublicacao(), id,
				df.format(publicacao.getData()), publicacao.getImagem(),
				new UsuarioPublicacaoJSON(publicacao.getUsuarioPublicacao()
						.getIdUser(), publicacao.getUsuarioPublicacao()
						.getNome()));

		ArrayList<ComentarioJSON> comentariosJSON = new ArrayList<>();
		ArrayList<GostouJSON> gostouJSONs = new ArrayList<>();
		ArrayList<NaoGostouJSON> naoGostouJSONs = new ArrayList<>();

		for (Gostou gostou : publicacao.getGostous()) {
			GostouJSON gostouJSON = new GostouJSON(gostou.getId(),
					gostou.getIdUsuario(), gostou.getPublicacao()
							.getIdPublicacao());
			gostouJSONs.add(gostouJSON);
		}

		for (NaoGostou naoGostou : publicacao.getNaoGostous()) {
			NaoGostouJSON gostouJSON = new NaoGostouJSON(naoGostou.getId(),
					naoGostou.getIdUsuario(), naoGostou.getPublicacao()
							.getIdPublicacao());
			naoGostouJSONs.add(gostouJSON);
		}

		for (Comentario c : publicacao.getComentarios()) {
			// Adiciona os dados do comentario
			ComentarioJSON cJSON = new ComentarioJSON(c.getUsuarioComentario()
					.getIdUser(), c.getUsuarioComentario().getNome(),
					c.getImagem(), c.getIdComentario(), df.format(c.getData()),
					c.getComentario());
			// Adiciona a lista cada comentario
			comentariosJSON.add(cJSON);
		}

		Collections.sort(comentariosJSON, new CustomComparator());
		jsonPublicacao.setComentarios(comentariosJSON);
		jsonPublicacao.setGostous(gostouJSONs);
		jsonPublicacao.setNaoGostous(naoGostouJSONs);
		jsonPublicacao.setQuantidadeGostou(gostouJSONs.size());
		jsonPublicacao.setQuantidadeNaoGostou(naoGostouJSONs.size());
		jsonPublicacao.setQuantidadeComentarios(comentariosJSON.size());

		// Verifica se a publicacao eh do usuario que esta logado
		if (moradorControllerBean.getUsuario().getIdUser() == publicacao
				.getUsuarioPublicacao().getIdUser())
			jsonPublicacao.setProprietario(true);
		else
			jsonPublicacao.setProprietario(false);

		// Seta as publicacoes filtradas e as retorna para a VIEW
		return jsonPublicacao;
	}

	/*
	 * Cria um JSON com os dados necessarios para a publicacao ;D
	 */
	@RequestMapping(value = "getPublicacao", method = RequestMethod.POST)
	public @ResponseBody
	ArrayList<JsonPublicacao> sendJsonPublicacao() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		ArrayList<JsonPublicacao> jsonPublicacaos = new ArrayList<>();
		final int tamanhoColuna = 10;

		List<Publicacao> publicacaoes = publicacaoService.getPublicacoes(
				colunaInicial, tamanhoColuna);

		

		// Varre cada publicacao
		for (Publicacao p : publicacaoes) {
			// Cria uma lista para os comentarios desta publicacao
			ArrayList<ComentarioJSON> comentariosJSON = new ArrayList<>();
			// Adiciona os dados da publicacao, e o usuario que a fez
			JsonPublicacao jsonPublicacao = new JsonPublicacao(
					p.getPublicacao(), p.getIdPublicacao(), df.format(p
							.getData()), p.getImagem(),
					new UsuarioPublicacaoJSON(p.getUsuarioPublicacao()
							.getIdUser(), p.getUsuarioPublicacao().getNome()));

			ArrayList<GostouJSON> gostouJSONs = new ArrayList<>();
			ArrayList<NaoGostouJSON> naoGostouJSONs = new ArrayList<>();
			
			jsonPublicacao.setQuantidadeGostou(p.getGostous().size());
			jsonPublicacao.setQuantidadeNaoGostou(p.getNaoGostous().size());

			for (Gostou gostou : p.getGostous()) {
				GostouJSON gostouJSON = new GostouJSON(gostou.getId(),
						gostou.getIdUsuario(), gostou.getPublicacao()
								.getIdPublicacao());
				gostouJSONs.add(gostouJSON);
			}

			for (NaoGostou naoGostou : p.getNaoGostous()) {
				NaoGostouJSON gostouJSON = new NaoGostouJSON(naoGostou.getId(),
						naoGostou.getIdUsuario(), naoGostou.getPublicacao()
								.getIdPublicacao());
				naoGostouJSONs.add(gostouJSON);
			}

			// Varre os comentarios dentro da publicacao
			for (Comentario c : p.getComentarios()) {
				// Adiciona os dados do comentario
				ComentarioJSON cJSON = new ComentarioJSON(c
						.getUsuarioComentario().getIdUser(), c
						.getUsuarioComentario().getNome(), c.getImagem(),
						c.getIdComentario(), df.format(c.getData()),
						c.getComentario());
				// Adiciona a lista cada comentario
				comentariosJSON.add(cJSON);

			}
			// Seta os comentarios
			// ordena pela data
			Collections.sort(comentariosJSON, new CustomComparator());
			jsonPublicacao.setComentarios(comentariosJSON);
			jsonPublicacao.setGostous(gostouJSONs);
			jsonPublicacao.setNaoGostous(naoGostouJSONs);
			jsonPublicacao.setQuantidadeGostou(gostouJSONs.size());
			jsonPublicacao.setQuantidadeNaoGostou(naoGostouJSONs.size());
			jsonPublicacao.setQuantidadeComentarios(comentariosJSON.size());

			// Verifica se a publicacao eh do usuario que esta logado
			if (moradorControllerBean.getUsuario().getIdUser() == p
					.getUsuarioPublicacao().getIdUser())
				jsonPublicacao.setProprietario(true);
			else
				jsonPublicacao.setProprietario(false);

			// Seta as publicacoes filtradas e as retorna para a VIEW
			jsonPublicacaos.add(jsonPublicacao);
		}

		colunaInicial += publicacaoes.size();
		System.out.println("Coluna inicial: "+ colunaInicial);
		return jsonPublicacaos;
	}

	@RequestMapping(value = "home/comentar", method = RequestMethod.POST)
	public @ResponseBody
	NovoComentarioJSON comentar(
			@ModelAttribute("moradorControllerBean") MoradorControllerBean moradorControllerBean,
			BindingResult bindingResult) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Publicacao p = publicacaoService
				.getUnicaPublicacao(moradorControllerBean.getIdPublicacao());
		moradorControllerBean.getComentarioTO().setPublicacao(p);
		moradorControllerBean.getComentarioTO().setUsuarioComentario(
				this.moradorControllerBean.getUsuario());
		moradorControllerBean.getComentarioTO().setData(new Date());
		moradorControllerBean.getComentarioTO().setImagem(
				this.moradorControllerBean.getUsuario().getImagemView());

		Comentario comentario = new Comentario();
		BeanUtils.copyProperties(moradorControllerBean.getComentarioTO(),
				comentario);

		Comentario c = comentarioService.save(comentario);

		comentarioService.evictCache();
		usuarioService.evitcCache();

		NovoComentarioJSON comentarioJSON = new NovoComentarioJSON(
				moradorControllerBean.getComentarioTO().getComentario(),
				c.getIdComentario(), this.moradorControllerBean.getUsuario()
						.getIdUser(), this.moradorControllerBean.getUsuario()
						.getImagemView(), df.format(moradorControllerBean
						.getComentarioTO().getData()),
				this.moradorControllerBean.getUsuario().getNome());
		return comentarioJSON;
	}

	@RequestMapping(value = "home/publicar", method = RequestMethod.POST)
	public @ResponseBody
	NovaPublicacaoJSON publicar(
			// Pega toda a publicacao
			@ModelAttribute("moradorControllerBean") MoradorControllerBean bean,
			BindingResult bindingResult) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(bean.getPublicacaoTO().getPublicacao());
		// Filtra javascript
		String publicacaoEscape = StringEscapeUtils.escapeHtml(bean
				.getPublicacaoTO().getPublicacao());

		bean.getPublicacaoTO().setPublicacao(publicacaoEscape);
		// Seta o usuario que publicou
		bean.getPublicacaoTO().setUsuarioPublicacao(
				moradorControllerBean.getUsuario());
		// Seta a data de postagem
		bean.getPublicacaoTO().setData(new Date());
		// Seta a imagem de quem publicou
		bean.getPublicacaoTO().setImagem(
				moradorControllerBean.getUsuario().getImagemView());
		Publicacao publicacao = new Publicacao();
		// salva no banco
		BeanUtils.copyProperties(bean.getPublicacaoTO(), publicacao);
		Publicacao p = publicacaoService.salvar(publicacao);

		comentarioService.evictCache();
		usuarioService.evitcCache();
		// monta o JSON de Publicacao.
		NovaPublicacaoJSON novaPublicacaoJSON = new NovaPublicacaoJSON(
				p.getIdPublicacao(), publicacaoEscape, df.format(bean
						.getPublicacaoTO().getData()), moradorControllerBean
						.getUsuario().getIdUser(), moradorControllerBean
						.getUsuario().getNome(), moradorControllerBean
						.getUsuario().getImagemView());
		return novaPublicacaoJSON;

	}

	// deleta uma publica��o
	@RequestMapping(value = "home/delete", method = RequestMethod.GET)
	public @ResponseBody
	String deletePost(@RequestParam("idPost") int id) {

		Publicacao p = publicacaoService.getUnicaPublicacao(id);
		if (p.getUsuarioPublicacao().getIdUser() == moradorControllerBean
				.getUsuario().getIdUser()) {
			publicacaoService.delete(p);
		}

		return "true";

	}

	public Usuario getUsuario() {

		Usuario usuario = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				usuario = usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername());

			}
		}

		return usuario;
	}
	public ArrayList<EnqueteJSON> getEnquetesVotadas(Usuario usuario){
		List<Enquetes> enquetes = enquetesService.getListAtiva(true);
		ArrayList<EnqueteJSON> enqueteJSONs = new ArrayList<>();
		ArrayList<EnqueteJSON> enqueteJSONsVOTADA = new ArrayList<>();
		for (Enquetes e : enquetes) {
			int totalVotos = e.getTotalVotos();
			ArrayList<OpcaoJSON> opcaoJSONs = new ArrayList<>();
			EnqueteJSON enqueteJSON = new EnqueteJSON(e.getTitulo(),
					e.getIdEquete(), e.getUsuarioEnquete().getIdUser(),e.getTotalVotos(), e.getEnquete());
			for (Opcao o : e.getOpcao()) {
				DecimalFormat f = new DecimalFormat("##.##");
				OpcaoJSON opcaoJSON = new OpcaoJSON(o.getIdOpcao(),
						o.getOpcao(), f.format(((o.getQuatVots() * 100d) / totalVotos)));
				for(OpcaoVotada ov : o.getOpcaoVotadas()){
					enqueteJSON.getIdVoto().add(ov.getIdUser());
				}
				opcaoJSONs.add(opcaoJSON);
			}
			enqueteJSON.setOpcoes(opcaoJSONs);
			
			enqueteJSONs.add(enqueteJSON);
		}
		
		for(EnqueteJSON enqueteJson : enqueteJSONs){
			if(enqueteJson.getIdVoto().contains(usuario.getIdUser())){
				enqueteJSONsVOTADA.add(enqueteJson);
			}
		}
		
		return enqueteJSONsVOTADA;
	}
	public ArrayList<EnqueteJSON> getEnquetes(Usuario usuario){
		List<Enquetes> enquetes = enquetesService.getListAtiva(true);
		ArrayList<EnqueteJSON> enqueteJSONs = new ArrayList<>();
		ArrayList<EnqueteJSON> enqueteJSONsVIEW = new ArrayList<>();
		for (Enquetes e : enquetes) {
			int totalVotos = e.getTotalVotos();
			ArrayList<OpcaoJSON> opcaoJSONs = new ArrayList<>();
			EnqueteJSON enqueteJSON = new EnqueteJSON(e.getTitulo(),
					e.getIdEquete(), e.getUsuarioEnquete().getIdUser(),e.getTotalVotos(), e.getEnquete());
			for (Opcao o : e.getOpcao()) {
				DecimalFormat f = new DecimalFormat("##.##");
				OpcaoJSON opcaoJSON = new OpcaoJSON(o.getIdOpcao(),
						o.getOpcao(), f.format(((o.getQuatVots() * 100d) / totalVotos)));
				for(OpcaoVotada ov : o.getOpcaoVotadas()){
					enqueteJSON.getIdVoto().add(ov.getIdUser());
				}
				opcaoJSONs.add(opcaoJSON);
			}
			enqueteJSON.setOpcoes(opcaoJSONs);
			
			enqueteJSONs.add(enqueteJSON);
		}
		
		for(EnqueteJSON enqueteJson : enqueteJSONs){
			if(!enqueteJson.getIdVoto().contains(usuario.getIdUser())){
				enqueteJSONsVIEW.add(enqueteJson);
			}
		}
		
		return enqueteJSONsVIEW;
	}

	private class CustomComparator implements Comparator<ComentarioJSON> {

		@Override
		public int compare(ComentarioJSON o1, ComentarioJSON o2) {
			return o1.getDataComentario().compareTo(o2.getDataComentario());
		}

	}
}