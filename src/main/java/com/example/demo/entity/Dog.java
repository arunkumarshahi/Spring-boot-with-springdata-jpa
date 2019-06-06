package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dog {
    @Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	@Id
    @GeneratedValue
    private long id;
    private String name;
    @Column(name = "age", nullable = false, length = 1)
    private int age;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}