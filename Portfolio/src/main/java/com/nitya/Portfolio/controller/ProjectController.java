package com.nitya.Portfolio.controller;

import com.nitya.Portfolio.dto.responce.ApiResponse;
import com.nitya.Portfolio.dto.responce.ProjectResponse;
import com.nitya.Portfolio.entity.Project;
import com.nitya.Portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getAllProjects() {
        List<ProjectResponse> projects = projectService.getAllProjects();
        return ResponseEntity.ok(ApiResponse.<List<ProjectResponse>>builder()
                .success(true)
                .message("Projects retrieved successfully")
                .data(projects)
                .build());
    }

}
