package com.dl.auto_vault.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String fuel,
            @RequestParam(required = false) String body,
            @RequestParam(required = false) Integer cylinders) {
        if (year != null && make != null) {
            return carService.getCarsByYearAndMake(year, make);
        } else if (name != null) {
            return carService.getCarByName(name);
        } else if (make != null) {
            return carService.getCarsByMake(make);
        } else if (model != null) {
            return carService.getCarsByModel(model);
        } else if (year != null) {
            return carService.getCarsByYear(year);
        } else if (fuel != null) {
            return carService.getCarsByFuel(fuel);
        } else if (body != null) {
            return carService.getCarsByBody(body);
        } else if (cylinders != null) {
            return carService.getCarsByCylinders(cylinders);
        } else {
            return carService.getCars();
        }
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.addCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        Car updatedCar = carService.updateCar(car);
        if (updatedCar != null) {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{carName}")
    public ResponseEntity<String> deleteCar(@PathVariable String carName) {
        carService.deleteCar(carName);
        return new ResponseEntity<>("Car deleted successfully", HttpStatus.OK);
    }

    
}
