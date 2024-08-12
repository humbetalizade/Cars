package org.auto.cars.controller;


import org.auto.cars.dto.CarDto;
import org.auto.cars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public String addCar(@RequestBody CarDto car) {
        carService.add(car);
        return "Car added";
    }

    @GetMapping("/getAll")
    public List<CarDto> getAllCars() {
        return carService.getAll();
    }

    @GetMapping("/getById{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @DeleteMapping("/delete{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return "Car deleted";
    }

    @PutMapping("/update{id}")
    public String updateCar(@PathVariable Long id, @RequestBody CarDto car) {
        carService.update(id, car);
        return "Car updated";
    }

    @GetMapping("/getByYear{year}")
    public List<CarDto> getByYear(@PathVariable Integer year) {
        return carService.getByYear(year);
    }

}
