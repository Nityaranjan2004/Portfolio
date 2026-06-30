package com.nitya.Portfolio.service;

import com.nitya.Portfolio.dto.responce.CertificateResponse;
import com.nitya.Portfolio.entity.Certificate;

import java.util.List;

public interface CertificateService {
    List<CertificateResponse> getAllCertificates();
}
