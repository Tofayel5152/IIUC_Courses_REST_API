package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    // "Maintain List<Model> for in-memory data"
    private final List<Course> courses = new ArrayList<>();

    // "Simulate ID generation using a counter variable"
    private Long nextId = 100L;

    public CourseService() {
        // Adding the example data from your PDF scenario
        courses.add(new Course(nextId++, "CSE-2340", "Software Development-1", 2.0, "Lab", "Autumn 2025", 2L, "MAS"));
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(Long id) {
        // "Use loops or removeIf() for search"
        // Using stream/filter is the modern equivalent of a loop search
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Course addCourse(Course course) {
        course.setId(nextId++); // Auto-increment ID starting from 100
        courses.add(course);
        return course;
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Optional<Course> existingCourseOpt = courses.stream().filter(c -> c.getId().equals(id)).findFirst();

        if (existingCourseOpt.isPresent()) {
            Course existingCourse = existingCourseOpt.get();
            // Updating fields only if they are not null (Partial Update)
            if (updatedCourse.getCode() != null)
                existingCourse.setCode(updatedCourse.getCode());
            if (updatedCourse.getTitle() != null)
                existingCourse.setTitle(updatedCourse.getTitle());
            if (updatedCourse.getCredit() != null)
                existingCourse.setCredit(updatedCourse.getCredit());
            if (updatedCourse.getType() != null)
                existingCourse.setType(updatedCourse.getType());
            if (updatedCourse.getSemester() != null)
                existingCourse.setSemester(updatedCourse.getSemester());
            if (updatedCourse.getDepartmentId() != null)
                existingCourse.setDepartmentId(updatedCourse.getDepartmentId());
            if (updatedCourse.getTeacher() != null)
                existingCourse.setTeacher(updatedCourse.getTeacher());
            return existingCourse;
        }
        return null;
    }

    public boolean deleteCourse(Long id) {
        // "Use removeIf() for delete operations"
        return courses.removeIf(c -> c.getId().equals(id));
    }
}