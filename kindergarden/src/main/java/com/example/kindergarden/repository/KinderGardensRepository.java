package com.example.kindergarden.repository;

import com.example.kindergarden.Entity.KinderGardens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KinderGardensRepository  extends JpaRepository<KinderGardens, Long> {

    //isDeleted true or false

}
