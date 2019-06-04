package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DogDTO;
import com.example.demo.entity.Dog;
import com.example.demo.service.DogNotFoundException;
import com.example.demo.service.DogsService;

import java.util.List;
@RestController
@RequestMapping("/dogs")
public class DogsController {
    @Autowired DogsService service;
    @GetMapping
    public List<Dog> getDogs() {
        return service.getDogs();
    }
    @PostMapping
    public void postDogs(@RequestBody DogDTO dto) {
        service.add(dto);
    }
    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id) throws DogNotFoundException {
        return service.getDogById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}