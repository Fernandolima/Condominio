package br.com.webhomebeta.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.imgscalr.Scalr.Method;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.MoradorControllerBean;
import br.com.webhomebeta.entity.Comentario;
import br.com.webhomebeta.entity.Notificacao;
import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.json.ComentarioJSON;
import br.com.webhomebeta.json.Json;
import br.com.webhomebeta.json.JsonPublicacao;
import br.com.webhomebeta.json.NotificacoesJSON;
import br.com.webhomebeta.json.NovaPublicacaoJSON;
import br.com.webhomebeta.json.NovoComentarioJSON;
import br.com.webhomebeta.json.UsuarioPublicacaoJSON;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.NotificacaoService;
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

	private Queue<DeferredResult<NotificacoesJSON>> queueNotificacaoJSON = new ConcurrentLinkedQueue<DeferredResult<NotificacoesJSON>>();
	private Queue<Notificacao> queueNotificacao = new ConcurrentLinkedQueue<>();

	// Inicializa a pagina com todos os parametros necessarios
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				moradorControllerBean.setUsuario(usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername()));

			}
		}
		model.put("moradorControllerBean", moradorControllerBean);

		return new ModelAndView("home", model);
	}

	/*
	 * Cria um JSON com os dados necessarios para a publicacao
	 */
	@RequestMapping(value = "home/getPublicacao", method = RequestMethod.POST)
	public @ResponseBody
	ArrayList<JsonPublicacao> sendJsonPublicacao() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		ArrayList<JsonPublicacao> jsonPublicacaos = new ArrayList<>();
		List<Publicacao> publicacaoes = publicacaoService.getPublicacoes();
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
			jsonPublicacao.setComentarios(comentariosJSON);

			// Verifica se a publicacao eh do usuario que esta logado
			if (moradorControllerBean.getUsuario().getIdUser() == p
					.getUsuarioPublicacao().getIdUser())
				jsonPublicacao.setProprietario(true);
			else
				jsonPublicacao.setProprietario(false);

			// Seta as publicacoes filtradas e as retorna para a VIEW
			jsonPublicacaos.add(jsonPublicacao);
		}

		return jsonPublicacaos;
	}

	@RequestMapping(value = "home/comentar", method = RequestMethod.POST)
	public @ResponseBody
	NovoComentarioJSON comentar(
			@ModelAttribute("moradorControllerBean") MoradorControllerBean moradorControllerBean,
			BindingResult bindingResult) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		moradorControllerBean.getComentarioTO().setPublicacao(
				new Publicacao(moradorControllerBean.getIdPublicacao()));
		moradorControllerBean.getComentarioTO().setUsuarioComentario(
				this.moradorControllerBean.getUsuario());
		moradorControllerBean.getComentarioTO().setData(new Date());
		moradorControllerBean.getComentarioTO().setImagem(
				this.moradorControllerBean.getUsuario().getImagemView());

		Comentario comentario = new Comentario();
		BeanUtils.copyProperties(moradorControllerBean.getComentarioTO(),
				comentario);

		Comentario c = comentarioService.save(comentario);

		NovoComentarioJSON comentarioJSON = new NovoComentarioJSON(
				moradorControllerBean.getComentarioTO().getComentario(),
				c.getIdComentario(), this.moradorControllerBean.getUsuario()
						.getIdUser(), this.moradorControllerBean.getUsuario()
						.getImagemView(), df.format(moradorControllerBean
						.getComentarioTO().getData())
						, this.moradorControllerBean.getUsuario().getNome());
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
		// monta o JSON de Publicacao.
		NovaPublicacaoJSON novaPublicacaoJSON = new NovaPublicacaoJSON(
				p.getIdPublicacao(), bean.getPublicacaoTO().getPublicacao(),
				df.format(bean.getPublicacaoTO().getData()),
				moradorControllerBean.getUsuario().getIdUser(),
				moradorControllerBean.getUsuario().getNome(),
				moradorControllerBean.getUsuario().getImagemView());
		return novaPublicacaoJSON;

	}

	//deleta uma publicação
	@RequestMapping(value = "home/delete", method = RequestMethod.GET)
	public @ResponseBody
	String deletePost(@RequestParam("idPost") int id) {
		
			publicacaoService.deletarPublicacao(id,moradorControllerBean.getUsuario().getIdUser());
		
		
		
		return "true";
	}
	
	// Salva no banco uma notificacao que usuario fez < Recebendo como parametro
	// o ID da publicacao
	// e o tipo de notificacao

	// Testando
	@RequestMapping(value = "home/notificacao", method = RequestMethod.GET)
	public @ResponseBody
	DeferredResult<NotificacoesJSON> receberNotificacao(
			@RequestParam("id") int idPublicacao,
			@RequestParam("tipo") String tipo) {

		// adiociona a notificacaoJSON para a DeferredResult
		DeferredResult<NotificacoesJSON> deferredResult = new DeferredResult<>();
		this.queueNotificacaoJSON.add(deferredResult);

		Notificacao notificacao = new Notificacao(tipo, idPublicacao,
				moradorControllerBean.getUsuario().getIdUser());

		// Adiociona a notificao salva na queue
		this.queueNotificacao.add(notificacaoService.salvar(notificacao));

		return deferredResult;
	}

	@Scheduled(fixedRate = 3000)
	public void externalThread() throws InterruptedException {
		Thread.sleep(6000);
		for (DeferredResult<NotificacoesJSON> result : this.queueNotificacaoJSON) {

			Notificacao n = queueNotificacao.poll();

			NotificacoesJSON json = new NotificacoesJSON();
			json.setIdPublicacao(n.getIdNotificacado());
			json.SetTipo(n.getTipoNotificacao(), moradorControllerBean
					.getUsuario().getNome());

			result.setResult(json);

			this.queueNotificacaoJSON.remove(result);
		}
	}

}
