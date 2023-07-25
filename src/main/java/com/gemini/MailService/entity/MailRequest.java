package com.gemini.MailService.entity;

import lombok.Data;

@Data
public class MailRequest {
	
	String toEmail;
	String subject;
	String body;
	public MailRequest(String toEmail, String subject, String body) {
		super();
		this.toEmail = toEmail;
		this.subject = subject;
		this.body = body;
	}
	
}
