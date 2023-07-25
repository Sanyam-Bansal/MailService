package com.gemini.MailService.service;

public interface EmailSenderService {
	 void sendEmail(String toEmail, String body, String subject);
}
