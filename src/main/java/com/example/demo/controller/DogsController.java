package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.dto.DogDTO;
import com.example.demo.entity.Dog;
import com.example.demo.service.DogNotFoundException;
import com.example.demo.service.DogsService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/dogs")
public class DogsController extends ResponseEntityExceptionHandler {
	@Autowired
	DogsService service;

	@GetMapping
	public List<Dog> getDogs() {
		return service.getDogs();
	}

	// @ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void postDogs(@RequestBody DogDTO dto) {
		service.add(dto);
	}

//    @GetMapping("/{id}")
//    public Dog getById(@PathVariable(required = true) long id) throws DogNotFoundException {
//        return service.getDogById(id);
//    }
	@GetMapping("/{id}")
	@ExceptionHandler(DogNotFoundException.class)
	public ResponseEntity<Dog> getById(@PathVariable(required = true) long id) {

		Dog dog = service.getDogById(id);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader1", "MyValue1");
		responseHeaders.set("MyResponseHeader2", "MyValue2");
		return new ResponseEntity<>(dog, responseHeaders, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) long id) {
		service.delete(id);
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<DogDTO> updateById(@PathVariable(required = true) long id, @RequestBody @Valid DogDTO dto,
//			BindingResult result) throws DogNotFoundException {
//		if (result.hasErrors()) {
//			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//		}
//		Dog dog = service.getDogById(id);
//		dto.setId(dog.getId());
//		service.add(dto);
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("MyResponseHeader1", "MyValue1");
//		responseHeaders.set("MyResponseHeader2", "MyValue2");
//		return new ResponseEntity<>(dto, responseHeaders, HttpStatus.CREATED);
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dog> updateById(@PathVariable(required = true) long id, @RequestBody @Valid Dog dto,
			BindingResult result) throws DogNotFoundException {
		if (result.hasErrors()) {
			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
		}
		Dog dog = service.getDogById(id);
//		dto.setId(dog.getId());
//		service.add(dto);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader1", "MyValue1");
		responseHeaders.set("MyResponseHeader2", "MyValue2");
		return new ResponseEntity<>(dto, responseHeaders, HttpStatus.CREATED);
	}
}