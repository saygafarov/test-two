package com.example.test_two.controller;

import com.example.test_two.entity.Animal;
import com.example.test_two.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public List<Animal> showAllAnimal() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimal(@PathVariable int id) {
        return animalService.getAnimal(id);
    }

    @PostMapping("/animals")
    public Animal addNewAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);

        return animal;
    }

    @PutMapping("/animals")
    public Animal updateAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);

        return animal;
    }

    @DeleteMapping("/animals/{id}")
    public String deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);

        return "Animal with ID = " + id + " was deleted";
    }
}
