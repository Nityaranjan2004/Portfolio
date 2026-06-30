package com.nitya.Portfolio.service.impl;

import com.nitya.Portfolio.dto.responce.CertificateResponse;
import com.nitya.Portfolio.entity.Certificate;
import com.nitya.Portfolio.repository.CertificateRepository;
import com.nitya.Portfolio.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    @Override
    public List<CertificateResponse> getAllCertificates() {
        return certificateRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    private CertificateResponse mapToResponse(Certificate certificate) {
        return CertificateResponse.builder()
                .id(certificate.getId())
                .title(certificate.getTitle())
                .issuer(certificate.getIssuer())
                .issueDate(certificate.getIssueDate())
                .credentialUrl(certificate.getCredentialUrl())
                .build();
    }
}
