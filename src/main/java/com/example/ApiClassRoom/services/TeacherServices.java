package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServices {

    @Autowired
    ITeacherRepository repository;

    //SAVE
    public Teacher saveTeacher(Teacher teacherData)throws Exception{
        try{
            return this.repository.save(teacherData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //MODIFY
    public Teacher modifyTeacher(Integer id,Teacher teacherData) throws Exception{
        try {
           Optional <Teacher> teacherSearch=this.repository.findById(id);

           if(teacherSearch.isPresent()){


               teacherSearch.get().setSkill(teacherData.getSkill());
               return this.repository.save(teacherSearch.get());

           }else{
               throw new Exception(APIMessages.TEACHER_NOT_FOUND.getText());
           }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //SEARCH BY ID
    public Teacher searchTeacherById(Integer id) throws Exception{
        try{
            Optional<Teacher> teacherImLookingFor=this.repository.findById(id);
            if (teacherImLookingFor.isPresent()){
                return teacherImLookingFor.get();
            }else{
                throw new Exception(APIMessages.TEACHER_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<Teacher> searchEveryTeacher()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteTeacher(Integer id)throws  Exception{
        try{
            Optional<Teacher> searchedTeacher=this.repository.findById(id);
            if (searchedTeacher.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.TEACHER_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
