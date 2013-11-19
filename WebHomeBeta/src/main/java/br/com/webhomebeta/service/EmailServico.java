package br.com.webhomebeta.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import br.com.webhomebeta.entity.CalendarEvent;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.UsuarioTO;

/**
 * @author Fernando
 *
 */
@Service("emailServico")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class EmailServico {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	
	private static final String TEMPLATE = "template.vm";
	private static final String TEMPLATE_ESQUECI_SENHA = "templateSenha.vm";
	private static final String TEMPLATE_USUARIO_NAO_ACEITO = "templateUsuarioNaoAceito.vm";
	private static final String TEMPLATE_USUARIO_ACEITO = "templateUsuarioAceito.vm";
	private static final String TEMPLATE_NOVO_USUARIO = "templateNovoUsuario.vm";
	private static final String TEMPLATE_NOVO_APROVADO = "templateMoradorAprovado.vm";
	private static final String TEMPLATE_NOVA_RESERVA = "templateNovaReserva.vm";
	private static final String TEMPLATE_RESERVA_ACEITA = "templateReservaAceita.vm";
	private static final String FROM = "webhomecondominios@gmail.com";
	private static final String SUBJECT_NOVO_MORADOR = "Novo morador cadastrado!";
	private static final String SUBJECT_MORADOR_ACEITO = "Seu cadastro na Web Home foi aceito!";
	private static final String SUBJECT_MORADOR_APROVADO = "Validação de email Web Home!";
	private static final String SUBJECT_ESPACO_ACEITO = "A reserva realizada na Web Home foi aceita!";
	private static final String SUBJECT_MORADOR_NAO_ACEITO = "Seu cadastro na Web Home foi rejeitado!";
	private static final String SUBJECT_SENHA = "Recuperacao de senha - Web Home";
	private static final String SUBJECT_NOVA_RESERVA = "Pedido de nova reserva";
	private static final String SUBJECT_RESERVA_ACEITA= "Sua reserva foi aceita! - Web Home";
	

	public void emailNovoMorador(final Usuario usuario) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				Usuario u = usuarioService.getByCargo("Sindico");
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(u.getEmail());
				message.setFrom(FROM);
				message.setSubject(SUBJECT_NOVO_MORADOR);
				// passando os parâmetros para o template
				
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", u.getNome());
				model.put("nomeMorador", usuario.getNome());
				@SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE_NOVO_USUARIO, model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}

	
	public void emailMoradorNaoAceito(final Usuario usuario) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(usuario.getEmail());
				message.setFrom(FROM);
				message.setSubject(SUBJECT_MORADOR_NAO_ACEITO);
				// passando os parâmetros para o template
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", usuario.getNome());

				@SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE_USUARIO_NAO_ACEITO, model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}

	public void validaEmailMorador(final Usuario usuario){
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
			message.setTo(usuario.getEmail());
			message.setFrom(FROM);
			message.setSubject(SUBJECT_MORADOR_APROVADO);
			// passando os parâmetros para o template
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("nome", usuario.getNome());
			model.put("link", "http://localhost:8080/WebHomeBeta/aprovarEmail/email="+ usuario.getEmail()+"/proc");

			@SuppressWarnings("deprecation")
			String text = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, TEMPLATE_NOVO_APROVADO, model);
			message.setText(text, true);
				
			}
		};
		this.mailSender.send(preparator);
	}
	
	public void emailNovoMoradorAceito(final Usuario usuario) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(usuario.getEmail());
				message.setFrom(FROM);
				message.setSubject(SUBJECT_MORADOR_ACEITO);
				// passando os parâmetros para o template
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", usuario.getNome());

				@SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE_USUARIO_ACEITO, model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
	
	public void emailAlteracaoSenha(final UsuarioTO usuario) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				Usuario usuarioB = usuarioService.getUsuarioByLogin(usuario.getEmail());
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(usuario.getEmail());
				message.setFrom(FROM);
				message.setSubject(SUBJECT_SENHA);
				// passando os parâmetros para o template
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", usuarioB.getNome());
				model.put("senha",usuario.getSenha());
				model.put("link", "http://localhost:8080/WebHomeBeta");
				//alterando senha no banco
				
				usuarioService.update(usuarioB.getIdUser(), usuario.getSenha());
				@SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE_ESQUECI_SENHA, model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
	
	
	public void emailNovaReserva(final Usuario usuario , final CalendarEvent event) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo("fernandolima66@gmail.com");
				message.setFrom(FROM);
				message.setSubject(SUBJECT_NOVA_RESERVA);
				// passando os parâmetros para o template
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", usuario.getNome());
				model.put("DataEspaco", df.format(event.getStart()));
				model.put("link", "http://localhost:8080/WebHomeBeta");

				@SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE_NOVA_RESERVA, model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
	
	public void emailReservaAceita(final Usuario usuario , final CalendarEvent event) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo("fernandolima66@gmail.com");
				message.setFrom(FROM);
				message.setSubject(SUBJECT_RESERVA_ACEITA);
				// passando os parâmetros para o template
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", usuario.getNome());
				model.put("DataEspaco", df.format(event.getStart()));
				model.put("link", "http://localhost:8080/WebHomeBeta");

				@SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE_RESERVA_ACEITA, model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
	
	
	
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public static String getTemplate() {
		return TEMPLATE;
	}

	public static String getFrom() {
		return FROM;
	}

	public static String getTemplateSenha() {
		return TEMPLATE_ESQUECI_SENHA;
	}

	public static String getTemplateUsuarioNaoAceito() {
		return TEMPLATE_USUARIO_NAO_ACEITO;
	}

	public static String getTemplateUsuarioAceito() {
		return TEMPLATE_USUARIO_ACEITO;
	}

	public static String getSubjectNovoMorador() {
		return SUBJECT_NOVO_MORADOR;
	}

	public static String getSubjectMoradorAceito() {
		return SUBJECT_MORADOR_ACEITO;
	}

	public static String getSubjectMoradorNaoAceito() {
		return SUBJECT_MORADOR_NAO_ACEITO;
	}


	public static String getTemplateNovoUsuario() {
		return TEMPLATE_NOVO_USUARIO;
	}
	
	public static String getTemplateNovoEspaco() {
		return SUBJECT_ESPACO_ACEITO;
		
	}
	public static String getTemplateMoradorAprovado(){
		return SUBJECT_MORADOR_APROVADO;
	}


	public UsuarioService getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	public static String getTemplateEsqueciSenha() {
		return TEMPLATE_ESQUECI_SENHA;
	}


	public static String getTemplateNovoAprovado() {
		return TEMPLATE_NOVO_APROVADO;
	}


	public static String getTemplateNovaReserva() {
		return TEMPLATE_NOVA_RESERVA;
	}


	public static String getTemplateReservaAceita() {
		return TEMPLATE_RESERVA_ACEITA;
	}


	public static String getSubjectMoradorAprovado() {
		return SUBJECT_MORADOR_APROVADO;
	}


	public static String getSubjectEspacoAceito() {
		return SUBJECT_ESPACO_ACEITO;
	}


	public static String getSubjectSenha() {
		return SUBJECT_SENHA;
	}


	public static String getSubjectNovaReserva() {
		return SUBJECT_NOVA_RESERVA;
	}


	public static String getSubjectReservaAceita() {
		return SUBJECT_RESERVA_ACEITA;
	}
	
	

}
