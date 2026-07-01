package com.nitya.Portfolio.dto.responce;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationResponse {

    private Long id;
    private String institution;
    private String degree;
    private String fieldOfStudy;
    private Double cgpa_or_percent;
    private Integer startYear;
    private Integer endYear;
}