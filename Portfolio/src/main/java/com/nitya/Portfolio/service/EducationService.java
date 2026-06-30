package com.nitya.Portfolio.service;

import com.nitya.Portfolio.dto.responce.EducationResponse;
import com.nitya.Portfolio.entity.Education;

import java.util.List;

public interface EducationService {
    List<EducationResponse> getAllEducation();
}
