package com.ileiwe.service.courseService;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Course createCourse(CourseDto courseDto, Long id);
    Course updateCourse(CourseDto courseDto, Long id,Long num);
    Course updateCourseWithTitle(String title);
    void deleteCourse(Long id);
    Course viewCourse(Long id);
    void publishCourse(Long id);
    Course findCourseByTitle(String title);





}
