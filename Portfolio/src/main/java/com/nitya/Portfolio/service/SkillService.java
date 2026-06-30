package com.nitya.Portfolio.service;

import com.nitya.Portfolio.dto.responce.SkillResponse;
import com.nitya.Portfolio.entity.Skill;

import java.util.List;

public interface SkillService {
    List<SkillResponse> getAllSkills();
    List<SkillResponse> getSkillsByCategory(String category);
}
