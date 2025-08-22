package com.example.kindergarden.dto;

import com.example.kindergarden.Entity.KinderGardens;
import com.example.kindergarden.enums.KinderGardenUserType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class KinderGardenUsersDTO {

    private Long id;
    private KinderGardens kinderGardens;
    private String username;
    private String password;
    private KinderGardenUserType kinderGardenUserType;
    private String phone;
    private Boolean isActive;
    private Date createTime;
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
