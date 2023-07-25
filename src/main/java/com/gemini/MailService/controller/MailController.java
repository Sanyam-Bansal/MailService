package com.gemini.MailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gemini.MailService.entity.MailRequest;
import com.gemini.MailService.service.EmailSenderService;

@RestController
public class MailController {
	@Autowired
	private EmailSenderService emailSenderService;

	@PostMapping("/sendEmail")
	public ResponseEntity<Object> sendEmail(@RequestBody MailRequest mailRequest) {
		try {
			emailSenderService.sendEmail(mailRequest.getToEmail(), mailRequest.getBody(),
					mailRequest.getSubject());
			return ResponseEntity.ok("Email sent successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}
}
