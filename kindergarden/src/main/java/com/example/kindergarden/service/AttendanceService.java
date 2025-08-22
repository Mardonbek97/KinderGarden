package com.example.kindergarden.service;

import com.example.kindergarden.Entity.Attendance;
import com.example.kindergarden.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAll(){
        return attendanceRepository.findAll();
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    public Attendance create(Attendance attendance){
        return attendanceRepository.save(attendance);
    }

    public Attendance update(Attendance attendance){
        Attendance attendance1 = attendanceRepository.findById(attendance.getId())
                .orElseThrow(()-> new RuntimeException("Not Found"));

        attendance1.setDate(attendance.getDate());
        attendance1.setStatus(attendance.getStatus());

        return attendanceRepository.save(attendance1);

    }

    public void delete(Long id){
        attendanceRepository.deleteById(id);
    }

}
