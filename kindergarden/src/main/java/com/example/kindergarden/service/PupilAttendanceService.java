package com.example.kindergarden.service;

import com.example.kindergarden.Entity.PupilAttendance;
import com.example.kindergarden.repository.PupilsAttendaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PupilAttendanceService {

     @Autowired
    private PupilsAttendaceRepository pupilsAttendaceRepository;

     public List<PupilAttendance> getAll(){
         return pupilsAttendaceRepository.findAll();
     }

     public void create(PupilAttendance pupilAttendance){
         pupilsAttendaceRepository.save(pupilAttendance);
     }

     public void update(PupilAttendance pupilAttendance){
         PupilAttendance pupilAttendance1 = pupilsAttendaceRepository.findById(pupilAttendance.getId())
                 .orElseThrow(() -> new RuntimeException("Not Found"));

         pupilAttendance1.setHasAttended(pupilAttendance.getHasAttended());
         pupilAttendance1.setEnterTime(pupilAttendance.getEnterTime());
         pupilAttendance1.setExitTime(pupilAttendance.getExitTime());

         pupilsAttendaceRepository.save(pupilAttendance1);
     }

     public void delete(Long id){
          pupilsAttendaceRepository.deleteById(id);
     }

}
