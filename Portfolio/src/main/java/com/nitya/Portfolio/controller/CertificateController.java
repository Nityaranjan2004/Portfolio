package com.nitya.Portfolio.controller;

import com.nitya.Portfolio.dto.responce.ApiResponse;
import com.nitya.Portfolio.dto.responce.CertificateResponse;
import com.nitya.Portfolio.entity.Certificate;
import com.nitya.Portfolio.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CertificateResponse>>> getAllCertificates() {
        List<CertificateResponse> certificates = certificateService.getAllCertificates();
        return ResponseEntity.ok(ApiResponse.<List<CertificateResponse>>builder()
                .success(true)
                .message("Certificates retrieved successfully")
                .data(certificates)
                .build());
    }

}
