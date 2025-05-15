package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.Student;
import com.example.ApiClassRoom.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    @Autowired
    IStudentRepository repository;

    //SAVE

    public Student saveStudent(Student studentData) throws Exception{
        try{
            return this.repository.save(studentData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //MODIFY
    public Student modifyStudent(Integer id, Student studentData) throws Exception{
        try {
            Optional<Student> studentSearch=this.repository.findById(id);

            if(studentSearch.isPresent()){


                studentSearch.get().setDegree(studentData.getDegree());
                studentSearch.get().setAddress(studentData.getAddress());
                studentSearch.get().setBirthDay(studentData.getBirthDay());
                return this.repository.save(studentSearch.get());

            }else{
                throw new Exception(APIMessages.STUDENT_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH BY ID
    public Student  searchStudentById(Integer id) throws Exception{
        try{
            Optional<Student> studentImLookingFor=this.repository.findById(id);
            if (studentImLookingFor.isPresent()){
                return studentImLookingFor.get();
            }else{
                throw new Exception(APIMessages.STUDENT_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<Student> searchEveryStudent()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteStudent(Integer id)throws  Exception{
        try{
            Optional<Student> searchedStudent=this.repository.findById(id);
            if (searchedStudent.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.STUDENT_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
