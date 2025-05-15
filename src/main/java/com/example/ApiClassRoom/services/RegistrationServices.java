package com.example.ApiClassRoom.services;


import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.Registration;
import com.example.ApiClassRoom.repositories.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServices {
    @Autowired
    IRegistrationRepository repository;

    //SAVE

    public Registration saveRegistration(Registration registrationData) throws Exception{
        try{
            return this.repository.save(registrationData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //MODIFY
    public Registration modifyRegistration(Integer id, Registration registrationData) throws Exception{
        try {
            Optional<Registration> registrationSearch=this.repository.findById(id);

            if(registrationSearch.isPresent()){


                registrationSearch.get().setRegistrationDate(registrationData.getRegistrationDate());
                return this.repository.save(registrationSearch.get());

            }else{
                throw new Exception(APIMessages.REGISTRATION_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //SEARCH BY ID
    public Registration searchRegistrationById(Integer id) throws Exception{
        try{
            Optional<Registration> registrationImLookingFor=this.repository.findById(id);
            if (registrationImLookingFor.isPresent()){
                return registrationImLookingFor.get();
            }else{
                throw new Exception(APIMessages.REGISTRATION_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<Registration> searchEveryRegistration()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteRegistration(Integer id)throws  Exception{
        try{
            Optional<Registration> searchedRegistration=this.repository.findById(id);
            if (searchedRegistration.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.REGISTRATION_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
