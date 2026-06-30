package com.nitya.Portfolio.controller;

import com.nitya.Portfolio.dto.responce.ApiResponse;
import com.nitya.Portfolio.dto.responce.ExperienceResponse;
import com.nitya.Portfolio.entity.Experience;
import com.nitya.Portfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExperienceController {

    private final ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ExperienceResponse>>> getAllExperiences() {
        List<ExperienceResponse> experiences = experienceService.getAllExperiences();
        return ResponseEntity.ok(ApiResponse.<List<ExperienceResponse>>builder()
                .success(true)
                .message("Experiences retrieved successfully")
                .data(experiences)
                .build());
    }

}
