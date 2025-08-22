package com.example.kindergarden.repository;

import com.example.kindergarden.Entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
