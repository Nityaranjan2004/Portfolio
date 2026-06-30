package com.nitya.Portfolio.controller;

import com.nitya.Portfolio.dto.responce.ApiResponse;
import com.nitya.Portfolio.dto.responce.EducationResponse;
import com.nitya.Portfolio.entity.Education;
import com.nitya.Portfolio.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EducationController {

    private final EducationService educationService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EducationResponse>>> getAllEducation() {
        List<EducationResponse> education = educationService.getAllEducation();
        return ResponseEntity.ok(ApiResponse.<List<EducationResponse>>builder()
                .success(true)
                .message("Education details retrieved successfully")
                .data(education)
                .build());
    }

}
