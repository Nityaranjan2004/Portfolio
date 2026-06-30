package com.nitya.Portfolio.service.impl;

import com.nitya.Portfolio.dto.responce.EducationResponse;
import com.nitya.Portfolio.entity.Education;
import com.nitya.Portfolio.repository.EducationRepository;
import com.nitya.Portfolio.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    @Override
    public List<EducationResponse> getAllEducation() {
        return educationRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    private EducationResponse mapToResponse(Education education) {
        return EducationResponse.builder()
                .id(education.getId())
                .institution(education.getInstitution())
                .degree(education.getDegree())
                .fieldOfStudy(education.getFieldOfStudy())
                .cgpa(education.getCgpa())
                .startYear(education.getStartYear())
                .endYear(education.getEndYear())
                .build();
    }
}
