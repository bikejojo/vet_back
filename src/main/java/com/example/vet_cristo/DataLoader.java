package com.example.vet_cristo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.vet_cristo.model.Pet;
import com.example.vet_cristo.repository.PetRepository;

public class DataLoader implements CommandLineRunner {
    private final PetRepository petRepository;

    public DataLoader(PetRepository petRepository){
        this.petRepository = petRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        petRepository.deleteAll();

      /*  petRepository.save(new Pet("1", "Buddy", "Dog", "Golden Retriever", 3, "Male", "Golden", "user1"));
        petRepository.save(new Pet("2", "Whiskers", "Cat", "Siamese", 2, "Female", "White", "user2"));*/
    }
}
