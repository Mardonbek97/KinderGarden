package com.example.kindergarden.repository;

import com.example.kindergarden.Entity.Pupils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PupilsRepository extends JpaRepository<Pupils, Long> {
}
