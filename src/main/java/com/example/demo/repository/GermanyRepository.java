package com.example.demo.repository;

import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.Germany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GermanyRepository extends JpaRepository<Germany,Long> {

    Optional<Germany> findByUserId(int id);
}
