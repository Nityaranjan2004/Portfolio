package com.nitya.Portfolio.controller;

import com.nitya.Portfolio.dto.request.ContactRequest;
import com.nitya.Portfolio.dto.responce.ApiResponse;
import com.nitya.Portfolio.entity.ContactMessage;
import com.nitya.Portfolio.service.ContactMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactMessageService contactMessageService;

    @PostMapping
    public ResponseEntity<ApiResponse<ContactMessage>> sendMessage(@Valid @RequestBody ContactRequest contactRequest) {
        ContactMessage savedMessage = contactMessageService.saveMessage(contactRequest);
        return ResponseEntity.ok(ApiResponse.<ContactMessage>builder()
                .success(true)
                .message("Message sent successfully")
                .data(savedMessage)
                .build());
    }



}
