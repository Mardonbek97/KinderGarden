package com.example.kindergarden.Teachers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class TeachersDTORowMapper implements Function<Teacher, TeachersDTO> {

    @Override
    public TeachersDTO apply(Teacher teacher){
        return new TeachersDTO(
                teacher.getId(),
                teacher.getFullName(),
                teacher.getSalary()
        );
    }

    public List<Teacher> apply(Long id, String fullName, double salary) {
        return null;
    }
}
