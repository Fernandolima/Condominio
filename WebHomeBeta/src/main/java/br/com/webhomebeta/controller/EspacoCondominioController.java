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
		
		espacos.put("Piscina", "Área de lazer");
		espacos.put("Salão de festa", "Local reservado para festa entre familiares e amigos");
		espacos.put("Quadra poliesportiva", "Quadra reservada para varios esportes");
		espacos.put("Hipicas", "Espaço para se cuidar dos cavalos");
		espacos.put("Campo de golf", "Espaço para se divertir");
		espacos.put("Salão de jogos", "Area com espaco interativos de jogos, capacidade : 20 pessoas");
		espacos.put("Hidromassagem", " Local para relaxar");
		espacos.put("Quadra de futebol", " Espaço reservado para compeonatos de futebol. Capacidade : 20 pessoas");
		espacos.put("Quadra de vôlei de areia", " Espaço reservado para vôlei. Capacidade : 20 pessoas");
		espacos.put("Quadra de basquete", "Espaço reservado para basquete. Capacidade : 20 pessoas ");
		espacos.put("Pista de cooper", "Espaço destinado para exercicios fisicos");
		espacos.put("Cinema", "Espaço reservado para assistir filmes. Capacidade : 20 pessoas");
		espacos.put("Academina", "Local para realizar exercicios fisicos");
		espacos.put("Área exclusiva para cachorros", "Área reservada para animais no Condonínimo");
		espacos.put("Vagas para visitantes", "Local para reservar vagas para visitantes ");
		espacos.put("Churrasqueira", "Local para reserva churrasqueira");
		
		
		map.put("listaEspaco", espacos);
		map.put("usuario", getUsuario());
		return new ModelAndView("espaco", map);
	}

	@RequestMapping(value = "admin/inserirEspaco", method = RequestMethod.POST)
	public @ResponseBody List<EspacoCondominioJSON> InserirEspaco(@RequestBody final List<EspacoCondominioJSON> condominioJSON) {

		for (EspacoCondominioJSON espacoJSON : condominioJSON) {
			
			EspacoCondominio espacoCondominio = new EspacoCondominio();
			espacoCondominio.setDescricao(espacoJSON.getDescricao());
			espacoCondominio.setEspaco(espacoJSON.getNovoEspaco());
			espacoCondominio.setIdUser(espacoJSON.getIdUser());
			
			condominioServe.save(espacoCondominio);
			
			
		}
			return condominioJSON;
	}

	@RequestMapping(value = "admin/listarEspacos", method = RequestMethod.POST)
	public @ResponseBody List<EspacoCondominioTo> listarEspacos(){
		
		List<EspacoCondominio> espacos = condominioServe.getLisEspacoCondominios();
		List<EspacoCondominioTo> espacosTO = new ArrayList<>();
		BeanUtils.copyProperties(espacos, espacosTO);
		
		return espacosTO;
	}
	
	@RequestMapping(value = "admin/deleteEspaco", method = RequestMethod.POST)
	public void deleteEspaco(
			@ModelAttribute("bean") EspacoCondominio espacoCondominio) {
		condominioServe.delete(espacoCondominio);
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
