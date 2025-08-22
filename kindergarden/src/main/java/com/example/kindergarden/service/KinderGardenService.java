package com.example.kindergarden.service;

import com.example.kindergarden.Entity.KinderGardens;
import com.example.kindergarden.dto.KinderGardenDTO;
import com.example.kindergarden.repository.KinderGardensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KinderGardenService {

     @Autowired
    private KinderGardensRepository kinderGardensRepository;

     public List<KinderGardenDTO> getAllKinderGardens(){
         return kinderGardensRepository.findAll()
                 .stream()
                 .map(kinderGardens -> new KinderGardenDTO(kinderGardens.getId(),
                         kinderGardens.getFirmName()))
                 .toList();
     }

     public void create(KinderGardens kinderGardens){
         kinderGardensRepository.save(kinderGardens);
     }

    public void delete(Long id){
        KinderGardens kinderGardens = kinderGardensRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        kinderGardens.setDeleted(true);
        kinderGardensRepository.save(kinderGardens);
    }

    public void update(Long id, KinderGardens kinderGardens){
        KinderGardens kinderGarden = kinderGardensRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        kinderGarden.setFirmName(kinderGardens.getFirmName());
        kinderGarden.setStatus(kinderGardens.getStatus());
        kinderGarden.setDeleted(kinderGardens.getDeleted());

         kinderGardensRepository.save(kinderGarden);
    }

}
