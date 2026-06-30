package com.nitya.Portfolio.dto.responce;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertificateResponse {

    private Long id;
    private String title;
    private String issuer;
    private LocalDate issueDate;
    private String credentialUrl;
}
