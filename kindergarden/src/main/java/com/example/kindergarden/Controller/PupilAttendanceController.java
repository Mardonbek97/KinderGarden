package com.example.kindergarden.Controller;

import com.example.kindergarden.Entity.PupilAttendance;
import com.example.kindergarden.service.PupilAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/attendance")
public class PupilAttendanceController {

    @Autowired
    private PupilAttendanceService pupilAttendanceService;

    @GetMapping
    public List<PupilAttendance> getAll(){
        return pupilAttendanceService.getAll();
    }

    @PostMapping("/create")
    public String create(@RequestBody PupilAttendance pupilAttendance){
        pupilAttendanceService.create(pupilAttendance);
        return "Attendance inserted";
    }

    @PutMapping("/update")
    public String update(@RequestBody PupilAttendance pupilAttendance){
        pupilAttendanceService.update(pupilAttendance);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        pupilAttendanceService.delete(id);
        return "deleted";
    }

}
