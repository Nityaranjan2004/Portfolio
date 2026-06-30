package com.nitya.Portfolio.service.impl;

import com.nitya.Portfolio.dto.request.ContactRequest;
import com.nitya.Portfolio.entity.ContactMessage;
import com.nitya.Portfolio.repository.ContactMessageRepository;
import com.nitya.Portfolio.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String toEmail;

    @Override
    public ContactMessage saveMessage(ContactRequest contactRequest) {
        ContactMessage contactMessage = ContactMessage.builder()
                .name(contactRequest.getName())
                .email(contactRequest.getEmail())
                .subject(contactRequest.getSubject())
                .message(contactRequest.getMessage())
                .build();
        
        ContactMessage savedMessage = contactMessageRepository.save(contactMessage);
        sendEmailNotification(savedMessage);
        return savedMessage;
    }

    private void sendEmailNotification(ContactMessage message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(toEmail);
            mailMessage.setTo(toEmail);
            mailMessage.setReplyTo(message.getEmail());
            mailMessage.setSubject("Portfolio Contact Inquiry: " + message.getSubject());
            mailMessage.setText(
                "Hello Nitya,\n\n" +
                "You have received a new contact message from your portfolio website:\n\n" +
                "Sender Name: " + message.getName() + "\n" +
                "Sender Email: " + message.getEmail() + "\n" +
                "Subject: " + message.getSubject() + "\n\n" +
                "Message:\n" + message.getMessage() + "\n\n" +
                "Best regards,\n" +
                "Your Portfolio System"
            );
            mailSender.send(mailMessage);
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
