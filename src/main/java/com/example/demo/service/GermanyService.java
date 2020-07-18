package com.example.demo.service;

import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.Germany;
import com.example.demo.repository.GermanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GermanyService {

    @Autowired
    private GermanyRepository germanyRepository;

    public void save (Germany germany){
        germanyRepository.save(germany);
    }

    public Germany find(int id){
        return germanyRepository.findByUserId(id).orElse(null);
    }
}
