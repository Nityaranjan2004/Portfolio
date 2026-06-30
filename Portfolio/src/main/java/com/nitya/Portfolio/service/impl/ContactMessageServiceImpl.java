package com.nitya.Portfolio.service.impl;

import com.nitya.Portfolio.dto.request.ContactRequest;
import com.nitya.Portfolio.entity.ContactMessage;
import com.nitya.Portfolio.repository.ContactMessageRepository;
import com.nitya.Portfolio.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    @Override
    public ContactMessage saveMessage(ContactRequest contactRequest) {
        ContactMessage contactMessage = ContactMessage.builder()
                .name(contactRequest.getName())
                .email(contactRequest.getEmail())
                .subject(contactRequest.getSubject())
                .message(contactRequest.getMessage())
                .build();
        return contactMessageRepository.save(contactMessage);
    }

}
