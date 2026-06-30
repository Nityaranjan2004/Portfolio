package com.nitya.Portfolio.service;

import com.nitya.Portfolio.dto.responce.ProjectResponse;
import com.nitya.Portfolio.entity.Project;

import java.util.List;

public interface ProjectService {
    List<ProjectResponse> getAllProjects();
    List<ProjectResponse> getFeaturedProjects();
}
