package com.ileiwe.service.courseService;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.repository.CourseRepository;
import com.ileiwe.data.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course createCourse(CourseDto courseDto, Long id) {
        //validate that course to be created is not in the repo, if it is, throw an exception
        //validate that instructor is valid,i.e not null
    //Get Instructor by id
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        Course courseToCreate = new Course();
        courseToCreate.setTitle(courseDto.getTitle());
        courseToCreate.setDescription(courseDto.getDescription());
        courseToCreate.setDuration(courseDto.getDuration());
        courseToCreate.setLanguage(courseDto.getLanguage());
        courseToCreate.setImageUrls(courseDto.getImgUrl());
      return   courseRepository.save(courseToCreate);
        // create courses
    }

    @Override
    public Course updateCourse(CourseDto courseDto, Long id, Long num) {
        Course course = courseRepository.findById(id).orElse(null);
        if (instructorRepository.findById(id).isPresent()){
            Instructor instructor = instructorRepository.findById(id).get();

            if (course!=null){
                course.setTitle(courseDto.getTitle());
                course.setDescription(courseDto.getDescription());
                course.setLanguage(courseDto.getLanguage());
                course.setImageUrls(courseDto.getImgUrl());
                course.setInstructor(instructor);
                return courseRepository.save(course);
            }else{
                throw new NullPointerException("Instructor with id" + id + "not found");
            }

        }

        return courseRepository.save(course);
    }

    @Override
    public Course updateCourseWithTitle(String title) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }

    @Override
    public Course viewCourse(Long id) {
        return null;
    }

    @Override
    public void publishCourse(Long id) {

    }

    @Override
    public Course findCourseByTitle(String title) {
        return null;
    }
}
