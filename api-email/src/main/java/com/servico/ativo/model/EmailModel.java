package com.servico.ativo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Email")
public class EmailModel {
	
	@Id
	private String id;
	
	private String emailFrom;
	
	private String emailTo;
	
	private String subject;
	
	private String text;
	
	private LocalDate sendDateEmail;
	
	private StatusEmail statusEmail;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDate getSendDateEmail() {
		return sendDateEmail;
	}
	public void setSendDateEmail(LocalDate sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}
	public StatusEmail getStatusEmail() {
		return statusEmail;
	}
	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}
	
	
	
}
