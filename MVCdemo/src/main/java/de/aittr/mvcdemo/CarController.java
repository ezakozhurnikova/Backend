package de.aittr.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarController {
    private CarService service;

    public CarController(CarService service) {

        this.service = service;
    }

    @GetMapping("/cars")
    public String getAllUsers(Model model){
        List<Car> cars=service.getaAllCars();
        model.addAttribute("cars",cars);
        return "cars_view";
    }
}
