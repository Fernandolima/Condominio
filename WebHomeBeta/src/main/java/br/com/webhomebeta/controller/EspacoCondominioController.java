package br.com.webhomebeta.controller;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.EspacoCondominio;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.ComentarioJSON;
import br.com.webhomebeta.json.EspacoCondominioJSON;
import br.com.webhomebeta.service.CalendarEventService;
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
	@Autowired
	private CalendarEventService calendarEventService;

	private HashMap<String, String> espacos = new LinkedHashMap<>();

	@RequestMapping(value = "admin/espaco", method = RequestMethod.GET)
	private ModelAndView ExibirEspaco(EspacoCondominioTo espacoCondominioTo,
			ModelMap map) {
		
		espacos.put("Academina", "Local para realizar exercicios fisicos");
		espacos.put("Área exclusiva para cachorros", "Área reservada para animais no Condonínimo");
		espacos.put("Campo de golf", "Espaço para se divertir");
		espacos.put("Churrasqueira", "Local para reserva churrasqueira");
		espacos.put("Cinema", "Espaço reservado para assistir filmes. Capacidade : 20 pessoas");
		espacos.put("Hidromassagem", " Local para relaxar");
		espacos.put("Hipicas", "Espaço para se cuidar dos cavalos");
		espacos.put("Piscina", "Área de lazer");
		espacos.put("Pista de cooper", "Espaço destinado para exercicios fisicos");
		espacos.put("Salão de festa", "Local reservado para festa entre familiares e amigos");
		espacos.put("Quadra de basquete", "Espaço reservado para basquete. Capacidade : 20 pessoas ");
		espacos.put("Quadra de futebol", " Espaço reservado para compeonatos de futebol. Capacidade : 20 pessoas");
		espacos.put("Quadra de vôlei de areia", " Espaço reservado para vôlei. Capacidade : 20 pessoas");
		espacos.put("Quadra poliesportiva", "Quadra reservada para varios esportes");
		espacos.put("Salão de jogos", "Area com espaco interativos de jogos, capacidade : 20 pessoas");
		espacos.put("Vagas para visitantes", "Local para reservar vagas para visitantes ");
		espacos.put("Outro", "Espaço ainda não existente");
				
		List<EspacoCondominio> espacosCadastrados = condominioServe.getLisEspacoCondominios();
		map.put("espacosCadastrados", espacosCadastrados);
		map.put("listaEspaco", espacos);
		map.put("usuario", getUsuario());
		return new ModelAndView("espaco", map);
	}

	@RequestMapping(value = "admin/inserirEspaco", method = RequestMethod.POST)
	public @ResponseBody EspacoCondominioJSON inserirEspaco(@RequestBody final EspacoCondominioJSON condominioJSON) {
			
			for(EspacoCondominio condominio : condominioServe.getLisEspacoCondominios()){
				if(condominioJSON.getNovoEspaco().equals(condominio.getEspaco())){
					return new EspacoCondominioJSON(1);
				}else if(condominioJSON.getNovoEspaco().equals("selecione")){
					return new EspacoCondominioJSON(2);
				}
			}
		
		
			EspacoCondominio espacoCondominio = new EspacoCondominio();
			espacoCondominio.setDescricao(condominioJSON.getDescricao());
			espacoCondominio.setEspaco(condominioJSON.getNovoEspaco());
			espacoCondominio.setIdUser(condominioJSON.getIdUser());
			
			espacoCondominio = condominioServe.save(espacoCondominio);
			condominioJSON.setIdEspaco(espacoCondominio.getIdEspaco());
			return condominioJSON;	
		}
	
	@RequestMapping(value = "admin/deletarEvento", method = RequestMethod.POST)
	public @ResponseBody String deletarEvento(@RequestParam("id") int id){
		//calendarEventService.delete(calendarEventService.get(id));
		return "true";
	}
	
	@RequestMapping(value = "admin/ativarEvento", method = RequestMethod.POST)
	public @ResponseBody String ativarEvento(@RequestParam("id") int id){
		calendarEventService.update(id);
		return "true";
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
	
	private class CustomComparator implements Comparator<ComentarioJSON> {

		@Override
		public int compare(ComentarioJSON o1, ComentarioJSON o2) {
			return o1.getDataComentario().compareTo(o2.getDataComentario());
		}

	}

}
