package com.example.kindergarden.Controller;

import com.example.kindergarden.Entity.Pupils;
import com.example.kindergarden.repository.PupilsRepository;
import com.example.kindergarden.service.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/pupils")
public class PupilController {

    @Autowired
    private PupilService pupilService;

    @GetMapping
    public List<Pupils> getAll(){
       return pupilService.getAll();
    }

    @PostMapping("/create")
    public String create(@RequestBody Pupils pupils){
        pupilService.create(pupils);
        return "pupil inserted";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        pupilService.delete(id);
        return "pupil deleted";
    }

    @PutMapping("/update")
    public String update(@RequestBody Pupils pupils){
        pupilService.update(pupils);
        return "pupil updated";
    }


}
