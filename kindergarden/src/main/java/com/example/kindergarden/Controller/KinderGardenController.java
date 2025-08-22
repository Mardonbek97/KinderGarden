package com.example.kindergarden.Controller;

import com.example.kindergarden.Entity.KinderGardens;
import com.example.kindergarden.dto.KinderGardenDTO;
import com.example.kindergarden.service.KinderGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/kindergardens")
public class KinderGardenController {

    @Autowired
    private KinderGardenService kinderGardenService;

    @GetMapping
    public List<KinderGardenDTO> getAll(){
        return kinderGardenService.getAllKinderGardens();
    }

    @PostMapping("/add")
    private String add(@RequestBody KinderGardens kinderGardens){
        kinderGardenService.create(kinderGardens);
        return "Successfully added ";
    }

    @DeleteMapping ("/delete/{id}")
    private ResponseEntity<String> delete(@PathVariable Long id){
        kinderGardenService.delete(id);
        return ResponseEntity.ok("Student deleted");
    }

    @PutMapping("/update/{id}")
    private String delete(@PathVariable Long id, @RequestBody KinderGardens kinderGardens){
                kinderGardenService.update(id, kinderGardens);
        return "Updated";
    }

}