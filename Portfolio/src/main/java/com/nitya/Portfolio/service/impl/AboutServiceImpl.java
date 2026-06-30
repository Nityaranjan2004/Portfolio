package com.nitya.Portfolio.service.impl;

import com.nitya.Portfolio.dto.responce.AboutResponse;
import com.nitya.Portfolio.entity.About;
import com.nitya.Portfolio.repository.AboutRepository;
import com.nitya.Portfolio.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;

    @Override
    public AboutResponse getAbout() {
        About about = aboutRepository.findAll().stream().findFirst().orElse(new About());
        return mapToResponse(about);
    }


    private AboutResponse mapToResponse(About about) {
        return AboutResponse.builder()
                .name(about.getName())
                .designation(about.getDesignation())
                .bio(about.getBio())
                .email(about.getEmail())
                .phone(about.getPhone())
                .location(about.getLocation())
                .githubUrl(about.getGithubUrl())
                .linkedinUrl(about.getLinkedinUrl())
                .leetcodeUrl(about.getLeetcodeUrl())
                .build();
    }
}
