package com.dl.auto_vault.car;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
@Table(name="car_details")
public class Car {
    @Id
    @Column(name = "car_name", unique = true)
    private String name;
    @Column(name = "car_description")
    private String description;
    @Column(name = "car_make")
    private String make;
    @Column(name = "car_model")
    private String model;
    private String type;
    private Integer year;
    private Integer price;
    private String engine;
    private Integer cylinders;
    private String fuel;
    private Integer mileage;
    private String transmission;
    private String trim;
    private String body;
    private Integer doors;
    private String exteriorColor;
    private String interiorColor;
    private String drivetrain;

    public Car() {
    }

    public Car(String interiorColor, String name, String description, String make, String model, String type, Integer year, Integer price, String engine, Integer cylinders, String fuel, Integer mileage, String transmission, String trim, String body, Integer doors, String exteriorColor, String drivetrain) {
        this.interiorColor = interiorColor;
        this.name = name;
        this.description = description;
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.price = price;
        this.engine = engine;
        this.cylinders = cylinders;
        this.fuel = fuel;
        this.mileage = mileage;
        this.transmission = transmission;
        this.trim = trim;
        this.body = body;
        this.doors = doors;
        this.exteriorColor = exteriorColor;
        this.drivetrain = drivetrain;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }
}
