package br.com.webhomebeta.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component("templateHtmlMail")
public class EnviaEmailHtmlVelocity {

	@Resource
	private JavaMailSender mailSender;

	@Resource
	private VelocityEngine velocityEngine;

	public void enviar() {

		// envia o e-mail

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,

				true, "ISO-8859-1");

				helper.setTo("fernandolima66@gmail.com");

				helper.setFrom("webhomecondominios@gmail.com");

				helper.setSubject("E-mail em formato HTML com Velocity e anotações do Spring");

				Map<String, String> model = new HashMap<String, String>();

				model.put("nome", "Fernando");

				// determina a localização do template

				String content = VelocityEngineUtils.mergeTemplateIntoString(

				velocityEngine, "WebHomeBeta/template/template.vm", model);

				helper.setText(content, true);

				FileSystemResource resource =

				new FileSystemResource(

				new File(System.getProperty("user.dir")
						+ "/src/main/webapp/webstatic/img/predio.jpg")

				);

				helper.addInline("imagem", resource);

			}

		};

		try {

			this.mailSender.send(preparator);

		} catch (MailException ex) {

			ex.printStackTrace();

		}

	}

	public static void main(String args[]) {

		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");

		EnviaEmailHtmlVelocity enviaEmailHtmlVelocity = (EnviaEmailHtmlVelocity) appCtx
				.getBean("templateHtmlMail");

		enviaEmailHtmlVelocity.enviar();

	}

}