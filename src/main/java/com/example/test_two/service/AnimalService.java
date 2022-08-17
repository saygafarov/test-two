package com.example.test_two.service;

import com.example.test_two.entity.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> getAllAnimals();

    void saveAnimal(Animal animal);

    Animal getAnimal(int id);

    void deleteAnimal(int id);
}
