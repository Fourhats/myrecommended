package com.myrecommended.business.emails;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.myrecommended.models.Answer;
import com.myrecommended.models.Question;
import com.myrecommended.models.Recommended;
import com.myrecommended.models.User;
import com.myrecommended.services.users.dtos.SendContactRequestDTO;

@Component
public class EmailManager {

	@Autowired
	private EmailSender emailSender;
	
	@Value("#{configProps}")
	private Properties properties;
	
	public void SendUserRegistrationEmail(String userName, String userEmail) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("{UserName}", userName);
		
		try {
			this.emailSender.sendEMail(userEmail, "Registración satisfactoria - Mis Recomendados", this.properties.getProperty("folder.emails"), "registrationEmail", values);
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void SendNewPasswordGenerationEmail(User user, String newPassword) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("{UserName}", user.getName());
		values.put("{NewPassword}", newPassword);
		
		try {
			this.emailSender.sendEMail(user.getEmail(), "Nuevo Password - Mis Recomendados", this.properties.getProperty("folder.emails"), "recoverPasswordEmail", values);
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void SendRecommendedHiredEmail(User user, Recommended recommended) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("{UserName}", user.getName());
		values.put("{RecommendedName}", recommended.getName());
		values.put("{RecommendedEmail}", recommended.getEmail());
		values.put("{RecommendedPhone}", recommended.getPhone());
		
		try {
			this.emailSender.sendEMail(user.getEmail(), "Contacto de Recomendado - Mis Recomendados", this.properties.getProperty("folder.emails"), "recommendedHiredEmail", values);
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void SendCustomerHireEmail(User user, Recommended recommended) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("{RecommendedName}", recommended.getName());
		values.put("{CustomerName}", user.getName() + " " + user.getSurname());
		values.put("{CustomerEmail}", user.getEmail());
		
		try {
			this.emailSender.sendEMail(recommended.getEmail(), "Te han contactado - Mis Recomendados", this.properties.getProperty("folder.emails"), "customerHireYouEmail", values);
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void SendQuestionAskedEmail(Question question, Recommended recommended) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("{RecommendedName}", recommended.getName());
		values.put("{UserName}", question.getUser().getName() + " " + question.getUser().getSurname());
		values.put("{Question}", question.getDescription());
		
		try {
			this.emailSender.sendEMail(recommended.getEmail(), "Te han preguntado - Mis Recomendados", this.properties.getProperty("folder.emails"), "askQuestionEmail", values);
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void SendQuestionAnsweredEmail(Answer answer, Recommended recommended) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("{UserName}", answer.getQuestion().getUser().getName());
		values.put("{Question}", answer.getQuestion().getDescription());
		values.put("{RecommendedName}", recommended.getName());
		values.put("{Answer}", answer.getDescription());
		
		try {
			this.emailSender.sendEMail(answer.getQuestion().getUser().getEmail(), "Han respondido a tu pregunta - Mis Recomendados", this.properties.getProperty("folder.emails"), "questionAnsweredEmail", values);
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void SendContact(SendContactRequestDTO sendContactDto) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("{Name}", sendContactDto.getName());
		values.put("{Description}", sendContactDto.getDescription());
		values.put("{Email}", sendContactDto.getEmail());
		
		try {
			this.emailSender.sendEMail("danielorozco87@gmail.com", "Nuevo contacto - Mis Recomendados", this.properties.getProperty("folder.emails"), "newContactEmail", values);
			this.emailSender.sendEMail("pedroalessandri@gmail.com", "Nuevo contacto - Mis Recomendados", this.properties.getProperty("folder.emails"), "newContactEmail", values);
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}