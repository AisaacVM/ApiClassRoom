package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.Course;
import com.example.ApiClassRoom.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServices {

    @Autowired
    ICourseRepository repository;

    //SAVE

    public Course saveCourse(Course courseData) throws Exception{
        try{
            return this.repository.save(courseData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //MODIFY
    public Course modifyCourse(Integer id, Course courseData) throws Exception{
        try {
            Optional<Course> courseSearch=this.repository.findById(id);

            if(courseSearch.isPresent()){


                courseSearch.get().setName(courseData.getName());
                return this.repository.save(courseSearch.get());

            }else{
                throw new Exception(APIMessages.COURSE_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //SEARCH BY ID
    public Course searchCourseById(Integer id) throws Exception{
        try{
            Optional<Course> courseImLookingFor=this.repository.findById(id);
            if (courseImLookingFor.isPresent()){
                return courseImLookingFor.get();
            }else{
                throw new Exception(APIMessages.COURSE_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<Course> searchEveryCourse()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteCourse(Integer id)throws  Exception{
        try{
            Optional<Course> searchedCourse=this.repository.findById(id);
            if (searchedCourse.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.COURSE_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}


