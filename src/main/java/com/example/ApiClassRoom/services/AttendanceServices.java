package com.example.ApiClassRoom.services;



import com.example.ApiClassRoom.helpers.APIMessages;
import com.example.ApiClassRoom.models.Attendance;
import com.example.ApiClassRoom.repositories.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServices {
    @Autowired
    IAttendanceRepository repository;

    //SAVE

    public Attendance saveAttendance(Attendance attendanceData) throws Exception{
        try{
            return this.repository.save(attendanceData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //MODIFY
    public Attendance modifyAttendance(Integer id, Attendance attendanceData) throws Exception{
        try {
            Optional<Attendance> attendanceSearch=this.repository.findById(id);

            if(attendanceSearch.isPresent()){


                attendanceSearch.get().setDate(attendanceData.getDate());
                attendanceSearch.get().setState(attendanceData.getState());
                return this.repository.save(attendanceSearch.get());

            }else{
                throw new Exception(APIMessages.ATTENDANCE_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //SEARCH BY ID
    public Attendance searchAttendanceById(Integer id) throws Exception{
        try{
            Optional<Attendance> attendanceImLookingFor=this.repository.findById(id);
            if (attendanceImLookingFor.isPresent()){
                return attendanceImLookingFor.get();
            }else{
                throw new Exception(APIMessages.ATTENDANCE_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //SEARCH ALL
    public List<Attendance> searchEveryAttendance()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }


    //DELETE
    public boolean deleteAttendance(Integer id)throws  Exception{
        try{
            Optional<Attendance> searchedAttendance=this.repository.findById(id);
            if (searchedAttendance.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception(APIMessages.ATTENDANCE_NOT_FOUND.getText());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
