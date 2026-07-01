package com.nitya.Portfolio.controller;

import com.nitya.Portfolio.dto.responce.AboutResponse;
import com.nitya.Portfolio.dto.responce.ApiResponse;
import com.nitya.Portfolio.entity.About;
import com.nitya.Portfolio.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @GetMapping
    public ResponseEntity<ApiResponse<AboutResponse>> getAbout() {
        AboutResponse response = aboutService.getAbout();
        return ResponseEntity.ok(ApiResponse.<AboutResponse>builder()
                .success(true)
                .message("About info retrieved successfully")
                .data(response)
                .build());
    }

}
