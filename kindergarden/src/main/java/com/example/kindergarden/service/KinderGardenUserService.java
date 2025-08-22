package com.example.kindergarden.service;

import com.example.kindergarden.Entity.KInderGardenUsers;
import com.example.kindergarden.repository.KinderGardenUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KinderGardenUserService {

    @Autowired
    private KinderGardenUsersRepository kinderGardenUsersRepository;

    public List<KInderGardenUsers> getAll(){
        return kinderGardenUsersRepository.findAll();
    }
}
