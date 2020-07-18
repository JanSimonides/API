package com.example.demo.service;

import com.example.demo.model.entity.leagues.England;
import com.example.demo.model.entity.leagues.Italy;
import com.example.demo.repository.ItalyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItalyService {
    @Autowired
    private ItalyRepository italyRepository;

    public void save (Italy italy){
        italyRepository.save(italy);
    }

    public Italy find(int id){
        return italyRepository.findByUserId(id).orElse(null);
    }
}
