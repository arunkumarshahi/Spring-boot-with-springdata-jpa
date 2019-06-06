package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.DogDTO;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogsRepository;

import java.util.List;
import java.util.Optional;
@Component
public class DogsService {
    @Autowired DogsRepository repository;
    public void add(DogDTO dto) {
        repository.save(toEntity(dto));
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Dog> getDogs() {
        return (List<Dog>) repository.findAll();
    }
    public Dog getDogById(long id) throws DogNotFoundException {
        Optional<Dog> optionalDog = repository.findById(id);
        return optionalDog.orElseThrow(() -> new DogNotFoundException("Couldn't find a Dog with id: "+ id));
        //new DogNotFoundException("Couldn't find a Dog with id: " ));
    }
    private Dog toEntity(DogDTO dto) {
        Dog entity = new Dog();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        if(dto.getId()!=0L) {
        	entity.setId(dto.getId());	
        }
        return entity;
    }
}