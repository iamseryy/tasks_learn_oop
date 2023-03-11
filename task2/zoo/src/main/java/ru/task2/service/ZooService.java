package ru.task2.service;

import ru.task2.model.*;
import ru.task2.model.base.Animal;
import ru.task2.model.base.Bird;
import ru.task2.model.base.Pet;
import ru.task2.model.base.Trainedable;
import ru.task2.repository.DataBase;
import ru.task2.view.ViewUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ZooService {
    private static DataBase db = DataBase.getInstance();

    public void addAnimal(Optional<Animal> animal){
        if (animal.isEmpty()){
            System.out.println("\nCancelled");
        } else {
            int id = db.add(animal.get());
            System.out.println("\nAnimal added, id: " + id);
        }

        ViewUtils.pressEnterToContinue();
    }

    public void printAnimals(){
        Optional<HashMap<Integer, Animal>> animalsOpt = db.findAll();
        if (animalsOpt.isEmpty()){
            System.out.println("\nThere are no animals in the zoo");
        }else{
            HashMap<Integer, Animal> animals = animalsOpt.get();
            System.out.println();
            animals.entrySet().stream().forEach(animal ->  {
                System.out.println("ID: " + animal.getKey());
                identifyAnimalAndExecute(animal.getValue(), (animalExecute) -> animalExecute.printAbout());});
        }

        ViewUtils.pressEnterToContinue();
    }

    public void printDetailAnimal(){
        System.out.println("\nDetail information about animal\n");
        Optional<Integer> idOpt = ViewUtils.inputInt("Enter ID or enter an empty string to cancel: ");
        if(!idOpt.isEmpty()){
            Optional<Animal> animalOptional = db.findById(idOpt.get());
            if(!animalOptional.isEmpty()){
                Animal animal = animalOptional.get();
                System.out.println();
                identifyAnimalAndExecute(animal, (animalExecute) -> animalExecute.printAbout());
            } else System.out.println("\nAnimal not found\n");
        } else System.out.println("\nCancelled\n");

        ViewUtils.pressEnterToContinue();
    }

    public void removeAnimal(){
        System.out.println("\nRemoving an animal from the zoo\n");
        Optional<Integer> idOpt = ViewUtils.inputInt("Enter ID or enter an empty string to cancel: ");
        if(!idOpt.isEmpty()){
            Optional<Animal> animalOptional = db.findById(idOpt.get());
            if(!animalOptional.isEmpty()){
                db.deleteById(idOpt.get());
                System.out.println("\nAnimal removed\n");
            }else System.out.println("\nAnimal not found\n");
        } else System.out.println("\nCancelled\n");

        ViewUtils.pressEnterToContinue();
    }

    public void makeAnimalSound(){
        System.out.println("\nMake the animal make a sound\n");
        Optional<Integer> idOpt = ViewUtils.inputInt("Enter ID or enter an empty string to cancel: ");
        if(!idOpt.isEmpty()){
            Optional<Animal> animalOptional = db.findById(idOpt.get());
            if(!animalOptional.isEmpty()){
                Animal animal = animalOptional.get();
                identifyAnimalAndExecute(animal, (animalExecute) -> animalExecute.makeSound());
            } else System.out.println("\nAnimal not found\n");
        } else System.out.println("\nCancelled\n");

        ViewUtils.pressEnterToContinue();
    }

    public void makeAllAnimalSound(){
        Optional<HashMap<Integer, Animal>> animalsOpt = db.findAll();
        System.out.println("\nMake all animals make a sound");
        if (animalsOpt.isEmpty()){
            System.out.println("\nThere are no animals in the zoo");
        }else{
            HashMap<Integer, Animal> animals = animalsOpt.get();
            animals.entrySet().stream().forEach(animal ->  identifyAnimalAndExecute(animal.getValue(), (animalExecute) -> animalExecute.makeSound()));
        }

        ViewUtils.pressEnterToContinue();
    }

    public void letGoFly(){
        Optional<HashMap<Integer, Animal>> animalsOpt = db.findAll();
        System.out.println("\nLet go fly\n");
        if (animalsOpt.isEmpty()){
            System.out.println("\nThere are no animals in the zoo");
        }else {
            Set<Animal> birds = animalsOpt.get().entrySet().stream()
                    .filter(animal -> (Bird.class.isAssignableFrom(animal.getValue().getClass())))
                    .map(bird -> bird.getValue())
                    .collect(Collectors.toSet());
            if (birds.isEmpty()){
                System.out.println("\nThere are no birds in the zoo");
            }else {
                birds.forEach(bird -> {
                    System.out.println("I'm " + identifyAnimal(bird));
                    ((Bird) bird).fly();
                    System.out.println();
                });
            }
        }

        ViewUtils.pressEnterToContinue();
    }

    public void petAnAnimal(){
        Optional<HashMap<Integer, Animal>> animalsOpt = db.findAll();
        System.out.println("\nPet an animal\n");
        if (animalsOpt.isEmpty()){
            System.out.println("\nThere are no animals in the zoo");
        }else {
            Set<Animal> pets = animalsOpt.get().entrySet().stream()
                    .filter(animal -> (Pet.class.isAssignableFrom(animal.getValue().getClass())))
                    .map(pet -> pet.getValue())
                    .collect(Collectors.toSet());
            if (pets.isEmpty()){
                System.out.println("\nThere are no pets in the zoo");
            }else {
                pets.forEach(pet -> {
                    System.out.println("I'm " + identifyAnimal(pet));
                    identifyAnimalAndExecute(pet, (petExec) -> ((Pet) petExec).showAffection());
                    System.out.println();
                });
            }
        }

        ViewUtils.pressEnterToContinue();
    }

    public void training(){
        Optional<HashMap<Integer, Animal>> animalsOpt = db.findAll();
        System.out.println("\nTraining\n");
        if (animalsOpt.isEmpty()){
            System.out.println("\nThere are no animals in the zoo");
        }else {
            Set<Animal> dogs = animalsOpt.get().entrySet().stream()
                    .filter(animal -> ((Dog.class.isAssignableFrom(animal.getValue().getClass())) && ((Dog) animal.getValue()).isTrained()))
                    .map(dog -> dog.getValue())
                    .collect(Collectors.toSet());
            if (dogs.isEmpty()){
                System.out.println("\nThere are no trained dogs in the zoo");
            }else {
                dogs.forEach(dog -> {
                    identifyAnimalAndExecute(dog, (dogTrain) -> {
                        ((Trainedable) dogTrain).Lie();
                        ((Trainedable) dogTrain).Sit();
                        ((Trainedable) dogTrain).SpinAround();
                    });
                    System.out.println();
                });
            }
        }

        ViewUtils.pressEnterToContinue();
    }

    public void identifyAnimalAndExecute(Animal animal, Execute execute){
        if(animal instanceof Cat){
            execute.AnimalExecute(((Cat) animal));
        } else if (animal instanceof Tiger) {
            execute.AnimalExecute(((Tiger) animal));
        } else if (animal instanceof Dog) {
            execute.AnimalExecute(((Dog) animal));
        } else if (animal instanceof Wolf) {
            execute.AnimalExecute(((Wolf) animal));
        } else if (animal instanceof Chicken) {
            execute.AnimalExecute(((Chicken) animal));
        } else if (animal instanceof Stork) {
            execute.AnimalExecute(((Stork) animal));
        }
    }

    public String identifyAnimal(Animal animal){
        if(animal instanceof Cat){
            return "Cat";
        } else if (animal instanceof Tiger) {
            return "Tiger";
        } else if (animal instanceof Dog) {
            return "Dog";
        } else if (animal instanceof Wolf) {
            return "Wolf";
        } else if (animal instanceof Chicken) {
            return "Chicken";
        } else if (animal instanceof Stork) {
            return "Stork";
        }
        return "Animal not defined";
    }

}
