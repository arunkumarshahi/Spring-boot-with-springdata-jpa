package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Dog;

public interface DogsRepository extends CrudRepository<Dog, Long> {

}
