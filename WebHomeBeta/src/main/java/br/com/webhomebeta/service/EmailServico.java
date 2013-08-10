package br.com.webhomebeta.service;

import java.util.HashMap;
import java.util.List;
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

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.UsuarioTO;

@Service("emailServico")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class EmailServico {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	private static final String TEMPLATE = "template.vm";
	private static final String FROM = "webhomecondominios@gmail.com";
	private static final String SUBJECT = "Novo morador cadastrado!";

	public void enviarEmail(final Usuario usuario) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(usuario.getEmail());
				message.setFrom(FROM);
				message.setSubject(SUBJECT);
				// passando os parâmetros para o template
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("nome", "Fernando");

				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, TEMPLATE, model);
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

	public static String getSubject() {
		return SUBJECT;
	}

}
