package com.example.kindergarden.Entity;

import com.example.kindergarden.enums.KinderGardenUserType;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "users")
public class KInderGardenUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "kindergarden_id", nullable = false)
    private KinderGardens kinderGardens;
    private String username;
    private String password;
    @Column(name = "role")
    private KinderGardenUserType kinderGardenUserType;
    private String phone;
    @Column(name = "is_active")
    private Boolean isActive;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "create_time")
    private Date createTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "update_time")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KinderGardens getKinderGardens() {
        return kinderGardens;
    }

    public void setKinderGardens(KinderGardens kinderGardens) {
        this.kinderGardens = kinderGardens;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public KinderGardenUserType getKinderGardenUserType() {
        return kinderGardenUserType;
    }

    public void setKinderGardenUserType(KinderGardenUserType kinderGardenUserType) {
        this.kinderGardenUserType = kinderGardenUserType;
    }
}
