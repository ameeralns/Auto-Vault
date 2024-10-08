package com.dl.auto_vault.car;

import jakarta.persistence.Access;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }
    public List<Car>getCarFromMake (String make){
        return carRepository.findAll().stream()
                .filter(car -> make.equalsIgnoreCase(car.getMake()))
                .collect(Collectors.toList());

    }

    public List<Car> getCarFromModel (String model){
        return carRepository.findAll().stream()
                .filter(car -> model.equalsIgnoreCase(car.getModel()))
                .collect(Collectors.toList());

    }

    public List<Car> getCarByName(String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarByDescription(String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getDescription().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByMake (String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getMake().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByModel (String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getModel().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByYear (int year){
        return carRepository.findAll().stream()
                .filter(car -> year == car.getYear())
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByYearAndMake (int year, String make){
        return carRepository.findAll().stream()
                .filter(car -> year == car.getYear() && car.getMake().toLowerCase().contains(make.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByCylinders (int searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getCylinders() == searchText)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByFuel (String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getFuel().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByDoors (int searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getDoors() == searchText)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByBody (String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getBody().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByExteriorColor (String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getExteriorColor().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByInteriorColor (String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getInteriorColor().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByDrivetrain (String searchText){
        return carRepository.findAll().stream()
                .filter(car -> car.getDrivetrain().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Car addCar (Car car){
        carRepository.save(car);
        return car;
    }

    public Car updateCar (Car updatedCar){
        Optional<Car> existingCar = carRepository.findByName(updatedCar.getName());

        if (existingCar.isPresent()) {
            Car carToUpdate = existingCar.get();
            carToUpdate.setName(updatedCar.getName());
            carToUpdate.setDescription(updatedCar.getDescription());
            carToUpdate.setYear(updatedCar.getYear());
            carToUpdate.setModel(updatedCar.getModel());
            carToUpdate.setCylinders(updatedCar.getCylinders());
            carToUpdate.setFuel(updatedCar.getFuel());
            carToUpdate.setDoors(updatedCar.getDoors());
            carToUpdate.setBody(updatedCar.getBody());
            carToUpdate.setExteriorColor(updatedCar.getExteriorColor());
            carToUpdate.setInteriorColor(updatedCar.getInteriorColor());
            carToUpdate.setDrivetrain(updatedCar.getDrivetrain());

            carRepository.save(carToUpdate);
            return carToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteCar (String carName){
        carRepository.deleteByName(carName);
    }





}
