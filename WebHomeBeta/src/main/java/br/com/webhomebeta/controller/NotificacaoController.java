package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ws.rs.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import br.com.webhomebeta.bean.DadosUsuarioBean;
import br.com.webhomebeta.entity.Notificacao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.NotificacoesJSON;
import br.com.webhomebeta.service.NotificacaoService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class NotificacaoController {

	@Autowired
	private DadosUsuarioBean dadosUsuarioBean;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private NotificacaoService notificacaoService;

	private Queue<NotificacoesJSON> queueNotificacaoJSON = new ConcurrentLinkedQueue<NotificacoesJSON>();
	private Queue<Notificacao> queueNotificacao = new ConcurrentLinkedQueue<>();
	private Queue<String> queueNovoMorador = new ConcurrentLinkedQueue<>();

	// ve
	@RequestMapping(value = "notificacaoInicial", method = RequestMethod.GET)
	public @ResponseBody
	ArrayList<NotificacoesJSON> inicia() {

		dadosUsuarioBean.setUsuario(getUsuario());

		ArrayList<NotificacoesJSON> list = new ArrayList<>();
		List<Notificacao> listNotificacao = notificacaoService.getNotificacoes(
				dadosUsuarioBean.getUsuario().getIdUser(), false);
		for (Notificacao n : listNotificacao) {
			Usuario usuario = usuarioService.getById(n.getIdNotificacador());
			NotificacoesJSON json = new NotificacoesJSON();
			json.setIdPublicacao(n.getIdPost());
			json.SetTipo(n.getTipoNotificacao(), usuario.getNome());
			json.setImagem(usuario.getImagemView());
			json.setIdUser(n.getIdNotificacado());
			json.setIdUserComentou(n.getIdNotificacador());
			list.add(json);
		}

		return list;
	}

	@RequestMapping(value = "notificacaoVista")
	public String notificacaoVista() {

		notificacaoService.update(dadosUsuarioBean.getUsuario().getIdUser(),
				true);
		return "oi";
	}

	// Salva no banco uma notificacao que usuario fez < Recebendo como parametro
	// o ID da publicacao
	// e o tipo de notificacao

	// Testando, ver com a tati
	@RequestMapping(value = "notificacao", method = RequestMethod.POST)
	public @ResponseBody
	String receberNotificacao(@RequestParam("id") int idNotificado,
			@RequestParam("tipo") String tipo,
			@RequestParam("idPost") int idPost) {

		// adiociona a notificacaoJSON no queue
		NotificacoesJSON notificacoesJSON = new NotificacoesJSON();
		this.queueNotificacaoJSON.add(notificacoesJSON);

		if (idNotificado == dadosUsuarioBean.getUsuario().getIdUser()) {

		} else {
			Notificacao notificacao = new Notificacao(tipo, idNotificado,
					dadosUsuarioBean.getUsuario().getIdUser(), idPost, false,
					"show/id=" + idPost);
			// Adiociona a notificao salva na queue.
			this.queueNotificacao.add(notificacaoService.salvar(notificacao));
		}

		return "true";
	}

	@RequestMapping(value = "notificacaoNovoUsuario", method = RequestMethod.POST)
	public @ResponseBody
	String receberNotificacaoNovoUsuario() {
		// adiociona a notificacaoJSON no queue
		String user = "novoUsuario";
		queueNovoMorador.add(user);
		
		return "true";
	}
	
	@RequestMapping(value = "verificaNotificacoesNovoUser", method = RequestMethod.POST)
	public @ResponseBody DeferredResult<ArrayList<String>> externalThreadNovoUser(){
		DeferredResult<ArrayList<String>> deffered = new DeferredResult<ArrayList<String>>();
		ArrayList<String> users = new ArrayList<>();
		
		for(String user : this.queueNovoMorador){
			users.add(user);
			queueNovoMorador.remove(user);
		}
		deffered.setResult(users);
		return deffered;
	}
	@RequestMapping(value = "verificaNotificacoes", method = RequestMethod.POST)
	public @ResponseBody
	DeferredResult<ArrayList<NotificacoesJSON>> externalThread() {
		DeferredResult<ArrayList<NotificacoesJSON>> deferred = new DeferredResult<ArrayList<NotificacoesJSON>>();
		ArrayList<NotificacoesJSON> array = new ArrayList<>();

		for (NotificacoesJSON result : this.queueNotificacaoJSON) {

			Notificacao n = queueNotificacao.poll();
			Usuario usuario = usuarioService.getById(n.getIdNotificacador());

			NotificacoesJSON json = new NotificacoesJSON();
			json.setIdPublicacao(n.getIdPost());
			json.SetTipo(n.getTipoNotificacao(), usuario.getNome());
			json.setImagem(usuario.getImagemView());
			json.setIdUser(n.getIdNotificacado());
			json.setIdUserComentou(n.getIdNotificacador());
			array.add(json);

			this.queueNotificacaoJSON.remove(result);

		}

		deferred.setResult(array);
		return deferred;
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
