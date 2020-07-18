package com.example.demo.repository;

import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.Italy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItalyRepository extends JpaRepository<Italy,Long> {

    Optional<Italy> findByUserId(int id);
}
