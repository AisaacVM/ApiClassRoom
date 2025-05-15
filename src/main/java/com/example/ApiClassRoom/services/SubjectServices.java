package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.Subject;
import com.example.ApiClassRoom.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServices {

    @Autowired
    ISubjectRepository repository;

    //SAVE

    public Subject saveSubject(Subject subjectData) throws Exception{
        try{
            return this.repository.save(subjectData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //MODIFY
    public Subject modifySubject(Integer id, Subject subjectData) throws Exception{
        try {
            Optional<Subject> subjectSearch=this.repository.findById(id);

            if(subjectSearch.isPresent()){


                subjectSearch.get().setName(subjectData.getName());
                return this.repository.save(subjectSearch.get());

            }else{
                throw new Exception(APIMessages.SUBJECT_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //SEARCH BY ID
    public Subject searchSubjectById(Integer id) throws Exception{
        try{
            Optional<Subject> subjectImLookingFor=this.repository.findById(id);
            if (subjectImLookingFor.isPresent()){
                return subjectImLookingFor.get();
            }else{
                throw new Exception(APIMessages.SUBJECT_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<Subject> searchEverySubject()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteSubject(Integer id)throws  Exception{
        try{
            Optional<Subject> searchedSubject=this.repository.findById(id);
            if (searchedSubject.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.SUBJECT_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
