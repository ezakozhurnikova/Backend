package de.aittr.mvcdemo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }
    List<Car> getaAllCars(){
        return repository.findAll();
    }
}
