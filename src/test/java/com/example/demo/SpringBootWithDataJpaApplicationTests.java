package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Dog;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootWithDataJpaApplicationTests {
	private static final String ROOT_URL = "http://localhost:8080";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void contextLoads() {
	}

//	 @Test
//	    public void testGetAllDogs()
//	    {
//	        ResponseEntity<Dog> responseEntity =
//	        restTemplate.getForEntity(ROOT_URL+"/dogs", Dog.class);
//	        Dog posts = Arrays.asList(responseEntity.getBody());
//	        assertNotNull(posts);
//	    }
	@Test
	public void testGetDogs() {
		Dog[] post = restTemplate.getForObject(ROOT_URL + "/dogs", Dog[].class);
		System.out.print("size .." + post.length);
		assertNotNull(post);
		assertEquals(post.length, 5);
	}

	@Test
	public void testGetDogById() {
		ResponseEntity<Dog> post = restTemplate.getForEntity(ROOT_URL + "/dogs/1", Dog.class);
		Dog dog = post.getBody();
		System.out.println("dog name .." + dog.getName());
		assertNotNull(dog);
		assertEquals(dog.getName(), "Bailey");

	}
}
