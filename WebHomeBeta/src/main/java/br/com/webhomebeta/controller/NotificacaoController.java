package br.com.webhomebeta.controller;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import br.com.webhomebeta.bean.DadosUsuarioBean;
import br.com.webhomebeta.entity.Notificacao;
import br.com.webhomebeta.json.NotificacoesJSON;
import br.com.webhomebeta.service.NotificacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;


@Controller
public class NotificacaoController {
	
	
	@Autowired
	private DadosUsuarioBean dadosUsuarioBean;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private NotificacaoService notificacaoService;
	
	private Queue<DeferredResult<NotificacoesJSON>> queueNotificacaoJSON = new ConcurrentLinkedQueue<DeferredResult<NotificacoesJSON>>();
	private Queue<Notificacao> queueNotificacao = new ConcurrentLinkedQueue<>();
	
		@RequestMapping(value = "home/notificacaoInicial", method = RequestMethod.GET)
		public NotificacoesJSON inicia(){
			SecurityContext context = SecurityContextHolder.getContext();
			if (context instanceof SecurityContext) {
				// Pega as informacoes da autenticacao
				Authentication authentication = context.getAuthentication();
				if (authentication instanceof Authentication) {
					// Pega o usuario que logou
					dadosUsuarioBean.setUsuario(usuarioService
							.getUsuarioByLogin(((UserDetailsImp) authentication
									.getPrincipal()).getUsername()));

				}
			}
			return null;
		}
	
		// Salva no banco uma notificacao que usuario fez < Recebendo como parametro
		// o ID da publicacao
		// e o tipo de notificacao

		// Testando
		@RequestMapping(value = "home/notificacao", method = RequestMethod.POST)
		public @ResponseBody
		DeferredResult<NotificacoesJSON> receberNotificacao(
				@RequestParam("id") int idPublicacao, @RequestParam("tipo") String tipo) {
			
			//adiociona a notificacaoJSON para a DeferredResult
			DeferredResult<NotificacoesJSON> deferredResult = new DeferredResult<>();
			this.queueNotificacaoJSON.add(deferredResult);
			
			Notificacao notificacao = new Notificacao(tipo, idPublicacao,
					dadosUsuarioBean.getUsuario().getIdUser());
			
			//Adiociona a notificao salva na queue
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
				json.SetTipo(n.getTipoNotificacao(), dadosUsuarioBean.getUsuario().getNome());
				
				result.setResult(json);
				
				this.queueNotificacaoJSON.remove(result);
			}
		}
	
}
