package com.nitya.Portfolio.service;

import com.nitya.Portfolio.dto.request.ContactRequest;
import com.nitya.Portfolio.entity.ContactMessage;

import java.util.List;

public interface ContactMessageService {
    ContactMessage saveMessage(ContactRequest contactRequest);
}
