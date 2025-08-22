package com.example.kindergarden.service;

import com.example.kindergarden.Entity.Child;
import com.example.kindergarden.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public List<Child> findAll(){
        return childRepository.findAll();
    }

    public Child create(Child child){

       return childRepository.save(child);
    }

    public void delete(Long id){
             childRepository.deleteById(id);
    }

    public Child update(Long id, Child child){
        Child child1 = childRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        child1.setAvatarUrl(child.getAvatarUrl());
        child1.setEnrollmentDate(child.getEnrollmentDate());
        child1.setName(child.getName());
        child1.setParentName(child.getParentName());
        child1.setUrlName(child.getUrlName());

        return childRepository.save(child1);
    }
}
