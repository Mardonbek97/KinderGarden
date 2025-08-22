package com.example.kindergarden.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "pupilattendance")
public class PupilAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "enter_time")
    private Date enterTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "exit_time")
    private Date exitTime;
    @ManyToOne
    @JoinColumn(name = "pupils_id", nullable = false)
    private Pupils pupils;
    @Column(name = "has_attended")
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
