package com.example.kindergarden.service;

import com.example.kindergarden.Entity.Parents;
import com.example.kindergarden.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentsService {

    @Autowired
    private ParentsRepository parentsRepository;

    public List<Parents> getAll(){
        return parentsRepository.findAll();
    }

    public void create(Parents parents){
        parentsRepository.save(parents);
    }

    public void update(Parents parents){
        Parents parent = parentsRepository.findById(parents.getId())
                .orElseThrow(() -> new RuntimeException("Not found"));

        parent.setAddress(parents.getAddress());
        parent.setFullName(parents.getFullName());

        parentsRepository.save(parent);

    }

    public void delete(Long id){
        Parents parent = parentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        parent.setDeleted(true);
        parentsRepository.save(parent);
    }
}
