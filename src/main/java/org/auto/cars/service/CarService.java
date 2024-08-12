package org.auto.cars.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.auto.cars.dto.CarDto;
import org.auto.cars.entity.Car;
import org.auto.cars.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public List<CarDto> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(item -> modelMapper.map(item, CarDto.class))
                .toList();
    }


    public void add(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);

        carRepository.save(car);
    }


    public CarDto getById(Long id) {
        Car cars = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found"));
        return modelMapper.map(cars, CarDto.class);
    }

    public void deleteById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found"));
        carRepository.delete(car);
    }

    public void update(Long id, CarDto carDto) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Car not found"));
        modelMapper.map(carDto, car);
        carRepository.save(car);
    }

    public List<CarDto> getByYear(Integer year) {
        List<CarDto> carList=new ArrayList<>();
        List<Car> cars= carRepository.findByProdYear(year);
        for (Car car : cars) {
            carList.add(modelMapper.map(car, CarDto.class));
        }
        return carList;
    }

}

