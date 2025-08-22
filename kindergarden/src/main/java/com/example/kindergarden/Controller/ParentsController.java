package com.example.kindergarden.Controller;

import com.example.kindergarden.Entity.Parents;
import com.example.kindergarden.service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/parents")
public class ParentsController {

    @Autowired
    private ParentsService parentsService;

    @GetMapping
    public List<Parents> getAll(){
        return parentsService.getAll();
    }

    @PostMapping("/create")
    public String create(@RequestBody Parents parents){
        parentsService.create(parents);
        return "Inserted";
    }

    @PutMapping("/update")
    public String update(@RequestBody Parents parents){
        parentsService.update(parents);
        return "Updated";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        parentsService.delete(id);
        return "Deleted";
    }

}
