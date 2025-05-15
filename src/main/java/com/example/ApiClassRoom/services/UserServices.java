package com.example.ApiClassRoom.services;


import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    IUserRepository repository;

    //SAVE

    public User saveUser(User userData) throws Exception{
        try{
            return this.repository.save(userData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //MODIFY
    public User modifyUser(Integer id, User userData) throws Exception{
        try {
            Optional<User> userSearch=this.repository.findById(id);

            if(userSearch.isPresent()){


                userSearch.get().setName(userData.getName());
                userSearch.get().setUserType(userData.getUserType());
                userSearch.get().setEmail(userData.getEmail());
                userSearch.get().setPassword(userData.getPassword());
                userSearch.get().setPhone(userData.getPhone());
                return this.repository.save(userSearch.get());

            }else{
                throw new Exception(APIMessages.USER_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //SEARCH BY ID
    public User searchUserById(Integer id) throws Exception{
        try{
            Optional<User> userImLookingFor=this.repository.findById(id);
            if (userImLookingFor.isPresent()){
                return userImLookingFor.get();
            }else{
                throw new Exception(APIMessages.USER_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<User> searchEveryUser()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteUser(Integer id)throws  Exception{
        try{
            Optional<User> searchedUser=this.repository.findById(id);
            if (searchedUser.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.USER_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
