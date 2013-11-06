package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.EspacoCondominio;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.EspacoCondominioJSON;
import br.com.webhomebeta.service.EspacoCondominioServe;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.EspacoCondominioTo;

@Controller
public class EspacoCondominioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EspacoCondominioServe condominioServe;

	private HashMap<String, String> espacos = new HashMap<>();

	@RequestMapping(value = "admin/espaco", method = RequestMethod.GET)
	private ModelAndView ExibirEspaco(EspacoCondominioTo espacoCondominioTo,
			ModelMap map) {
		
		espacos.put("Piscina", "�rea de lazer");
		espacos.put("Sal�o de festa", "Local reservado para festa entre familiares e amigos");
		espacos.put("Quadra poliesportiva", "Quadra reservada para varios esportes");
		espacos.put("Hipicas", "Espa�o para se cuidar dos cavalos");
		espacos.put("Campo de golf", "Espa�o para se divertir");
		espacos.put("Sal�o de jogos", "Area com espaco interativos de jogos, capacidade : 20 pessoas");
		espacos.put("Hidromassagem", " Local para relaxar");
		espacos.put("Quadra de futebol", " Espa�o reservado para compeonatos de futebol. Capacidade : 20 pessoas");
		espacos.put("Quadra de v�lei de areia", " Espa�o reservado para v�lei. Capacidade : 20 pessoas");
		espacos.put("Quadra de basquete", "Espa�o reservado para basquete. Capacidade : 20 pessoas ");
		espacos.put("Pista de cooper", "Espa�o destinado para exercicios fisicos");
		espacos.put("Cinema", "Espa�o reservado para assistir filmes. Capacidade : 20 pessoas");
		espacos.put("Academina", "Local para realizar exercicios fisicos");
		espacos.put("�rea exclusiva para cachorros", "�rea reservada para animais no Condon�nimo");
		espacos.put("Vagas para visitantes", "Local para reservar vagas para visitantes ");
		espacos.put("Churrasqueira", "Local para reserva churrasqueira");
		espacos.put("Outro", "Espa�o ainda n�o existente");
			
		List<EspacoCondominio> espacosCadastrados = condominioServe.getLisEspacoCondominios();
		map.put("espacosCadastrados", espacosCadastrados);
		map.put("listaEspaco", espacos);
		map.put("usuario", getUsuario());
		return new ModelAndView("espaco", map);
	}

	@RequestMapping(value = "admin/inserirEspaco", method = RequestMethod.POST)
	public @ResponseBody EspacoCondominioJSON inserirEspaco(@RequestBody final EspacoCondominioJSON condominioJSON) {
		
			EspacoCondominio espacoCondominio = new EspacoCondominio();
			espacoCondominio.setDescricao(condominioJSON.getDescricao());
			espacoCondominio.setEspaco(condominioJSON.getNovoEspaco());
			espacoCondominio.setIdUser(condominioJSON.getIdUser());
			
			espacoCondominio = condominioServe.save(espacoCondominio);
			condominioJSON.setIdEspaco(espacoCondominio.getIdEspaco());
			return condominioJSON;	
		}

	@RequestMapping(value = "home/listarEspaco", method = RequestMethod.GET)
	public ModelAndView listarEspacosHome(ModelMap model){
		
		List<EspacoCondominio> espacos = condominioServe.getLisEspacoCondominios();
		model.put("listaEspacos", espacos);
		model.put("usuario", getUsuario());
		return new ModelAndView("espacoUsuario", model);
	}
	
	
	@RequestMapping(value = "admin/listarEspaco", method = RequestMethod.GET)
	public ModelAndView listarEspacos(ModelMap model){
		
		List<EspacoCondominio> espacos = condominioServe.getLisEspacoCondominios();
		model.put("listaEspacos", espacos);
		model.put("usuario", getUsuario());
		return new ModelAndView("listaEspacos", model);
	}
	
	@RequestMapping(value = "admin/deleteEspaco", method = RequestMethod.POST)
	public @ResponseBody String deleteEspaco(@RequestParam("idEspaco") int idEspaco) {
		
		condominioServe.delete(new EspacoCondominio(idEspaco));
		
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

}
