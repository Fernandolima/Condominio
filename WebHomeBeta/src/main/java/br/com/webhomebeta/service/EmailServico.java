package br.com.webhomebeta.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.persistence.UniqueConstraint;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.UsuarioTO;

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
	private static final String FROM = "webhomecondominios@gmail.com";
	private static final String SUBJECT_NOVO_MORADOR = "Novo morador cadastrado!";
	private static final String SUBJECT_MORADOR_ACEITO = "Seu cadastro na WebHome foi aceito!";
	private static final String SUBJECT_MORADOR_NAO_ACEITO = "Seu cadastro na WebHome foi rejeitado!";

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
				model.put("link", "http://localhost:8080/WebHomeBeta/admin/validarMoradores");
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
				message.setSubject(SUBJECT_NOVO_MORADOR);
				// passando os parâmetros para o template
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", usuario.getNome());

				@SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE, model);
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

	

}
