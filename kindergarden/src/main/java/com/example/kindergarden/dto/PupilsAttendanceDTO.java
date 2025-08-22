package com.example.kindergarden.dto;

import com.example.kindergarden.Entity.Pupils;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PupilsAttendanceDTO {

    private Long id;
    private Date enterTime;
    private Date exitTime;
    private Pupils pupils;
    private String hasAttended;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Pupils getPupils() {
        return pupils;
    }

    public void setPupils(Pupils pupils) {
        this.pupils = pupils;
    }

    public String getHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(String hasAttended) {
        this.hasAttended = hasAttended;
    }
}
