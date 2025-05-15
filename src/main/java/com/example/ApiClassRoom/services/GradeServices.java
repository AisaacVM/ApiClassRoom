package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.Grades;
import com.example.ApiClassRoom.repositories.IGradesReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServices {

    @Autowired
    IGradesReposity repository;

    //SAVE

    public Grades saveGrades(Grades gradesData) throws Exception{
        try{
            return this.repository.save(gradesData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //MODIFY
    public Grades modifyGrades(Integer id, Grades gradesData) throws Exception{
        try {
            Optional<Grades> gradesSearch=this.repository.findById(id);

            if(gradesSearch.isPresent()){


                gradesSearch.get().setMark(gradesData.getMark());
                gradesSearch.get().setExam(gradesData.getExam());
                return this.repository.save(gradesSearch.get());

            }else{
                throw new Exception(APIMessages.GRADES_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //SEARCH BY ID
    public Grades searchGradesById(Integer id) throws Exception{
        try{
            Optional<Grades> gradesImLookingFor=this.repository.findById(id);
            if (gradesImLookingFor.isPresent()){
                return gradesImLookingFor.get();
            }else{
                throw new Exception(APIMessages.GRADES_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<Grades> searchEveryGrades()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteGrades(Integer id)throws  Exception{
        try{
            Optional<Grades> searchedGrades=this.repository.findById(id);
            if (searchedGrades.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.GRADES_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
