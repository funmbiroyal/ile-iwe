package com.ileiwe.controller;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.service.courseService.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/{id}")
    public ResponseEntity<?>createCourse(@RequestBody CourseDto courseDto, @PathVariable Long id){
        return ResponseEntity.ok().body(courseService.createCourse(courseDto,id));
    }
    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.viewCourse(id);
    }
    @PutMapping("/update/{id}/{num}")
    public Course updateCourse(@PathVariable Long id,@RequestBody CourseDto courseDto,Long num){
        return courseService.updateCourse(courseDto,id,num);
    }
}
