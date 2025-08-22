package com.example.kindergarden.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "pupils")
public class Pupils {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long Id;
    String name;
    @Column(name = "s_name")
    String sname;
    @Column(name = "l_name")
    String lname;
    @Column(name = "is_active")
    Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Parents parents;
    @ManyToOne
    @JoinColumn(name = "firm_id", nullable = false)
    private KinderGardens kinderGardens;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime create_at = LocalDateTime.now();
    private Boolean isDeleted = false;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public KinderGardens getKinderGardens() {
        return kinderGardens;
    }

    public void setKinderGardens(KinderGardens kinderGardens) {
        this.kinderGardens = kinderGardens;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
