package com.example.kindergarden.Controller;


import com.example.kindergarden.Entity.Child;
import com.example.kindergarden.repository.ChildRepository;
import com.example.kindergarden.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/kids")
public class ChildController {

    @Autowired
    //private ChildRepository repository;
    private ChildService childService;

    @GetMapping
    public List<Child> getAll() {
        return childService.findAll();
    }

    @PostMapping
    public Child  create(@RequestBody Child child, @RequestParam MultipartFile file) throws Exception {
        child.setEnrollmentDate(LocalDate.now());
        child.setAvatarUrl("https://placehold.co/40x40.png");
        String uploadDir = "C:/Java/kindergarden/images/";
        String fileName = UUID.randomUUID() + file.getOriginalFilename();
        Path filePath = (Path) Paths.get(uploadDir + fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        child.setUrlName(filePath.toString());

        return childService.create(child);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable Long id) {
        childService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Child update(@PathVariable Long id,
                        @RequestBody Child child){
        return childService.update(id, child);
    }

}
