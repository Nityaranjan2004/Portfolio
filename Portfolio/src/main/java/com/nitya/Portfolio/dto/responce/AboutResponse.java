package com.nitya.Portfolio.dto.responce;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AboutResponse {

    private String name;
    private String designation;
    private String bio;
    private String email;
    private String phone;
    private String location;
    private String githubUrl;
    private String linkedinUrl;
    private String leetcodeUrl;
}
