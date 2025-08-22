package com.example.kindergarden.service;

import com.example.kindergarden.Entity.Pupils;
import com.example.kindergarden.repository.PupilsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalInt;

@Service
public class PupilService {

    @Autowired
    private PupilsRepository pupilsRepository;

    public List<Pupils> getAll(){
        return pupilsRepository.findAll();
    }

    public void create(Pupils pupils){
        pupilsRepository.save(pupils);
    }

    public void delete(Long id){
        Pupils pupil = pupilsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pupil not found"));

        pupil.setDeleted(true);
        pupilsRepository.save(pupil);

    }

    public void update(Pupils pupils){
        Pupils pupil = pupilsRepository.findById(pupils.getId())
                .orElseThrow(() -> new RuntimeException("Pupil not found"));

        pupil.setName(pupils.getName());
        pupil.setLname(pupils.getLname());
        pupil.setSname(pupils.getSname());
        pupilsRepository.save(pupil);

    }


}
