package com.example.demo.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {

    private Long id;

    @NotBlank(message = "Course code is required")
    private String code;

    @NotBlank(message = "Course title is required")
    private String title;

    @Min(value = 1, message = "Credit must be at least 1")
    private Double credit;

    private String type;
    private String semester;
    private Long departmentId;
    private String teacher;
}