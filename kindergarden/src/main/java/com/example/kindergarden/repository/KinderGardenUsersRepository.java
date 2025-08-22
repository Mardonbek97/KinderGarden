package com.example.kindergarden.repository;

import com.example.kindergarden.Entity.KInderGardenUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KinderGardenUsersRepository extends JpaRepository<KInderGardenUsers, Long> {

    Optional<KInderGardenUsers> findByUsername(String username);

}
