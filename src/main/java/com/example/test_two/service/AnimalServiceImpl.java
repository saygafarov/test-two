package com.example.test_two.service;

import com.example.test_two.repository.AnimalRepository;
import com.example.test_two.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {

        return animalRepository.findAll();
    }

    @Override
    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public Animal getAnimal(int id) {
        Optional<Animal> animal = animalRepository.findById(id);

        return animal.orElse(null);
    }

    @Override
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }
}
