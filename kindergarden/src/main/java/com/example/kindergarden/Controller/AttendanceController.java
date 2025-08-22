package com.example.kindergarden.Controller;


import com.example.kindergarden.Entity.Attendance;
import com.example.kindergarden.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/{date}")
    public List<Attendance> getAttendanceByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return attendanceService.getAttendanceByDate(date);
    }

    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendanceList) {
        return attendanceService.create(attendanceList);
    }

    @PutMapping("/api/attendance/update")
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        Attendance updated = attendanceService.update(attendance);
        return ResponseEntity.ok(updated);
    }
}