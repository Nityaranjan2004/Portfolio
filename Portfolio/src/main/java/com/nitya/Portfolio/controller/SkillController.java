package com.nitya.Portfolio.controller;

import com.nitya.Portfolio.dto.responce.ApiResponse;
import com.nitya.Portfolio.dto.responce.SkillResponse;
import com.nitya.Portfolio.entity.Skill;
import com.nitya.Portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SkillResponse>>> getAllSkills() {
        List<SkillResponse> skills = skillService.getAllSkills();
        return ResponseEntity.ok(ApiResponse.<List<SkillResponse>>builder()
                .success(true)
                .message("Skills retrieved successfully")
                .data(skills)
                .build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<ApiResponse<List<SkillResponse>>> getSkillsByCategory(@PathVariable String category) {
        List<SkillResponse> skills = skillService.getSkillsByCategory(category);
        return ResponseEntity.ok(ApiResponse.<List<SkillResponse>>builder()
                .success(true)
                .message("Skills in category " + category + " retrieved successfully")
                .data(skills)
                .build());
    }

}
