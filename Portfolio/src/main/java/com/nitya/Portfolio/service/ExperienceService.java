package com.nitya.Portfolio.service;

import com.nitya.Portfolio.dto.responce.ExperienceResponse;
import com.nitya.Portfolio.entity.Experience;

import java.util.List;

public interface ExperienceService {
    List<ExperienceResponse> getAllExperiences();
}
