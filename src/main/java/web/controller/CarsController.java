package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

	@GetMapping(value = "/cars")
	public String cars(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
		List<Car> list = new ArrayList<>();
		list.add(new Car("Lada", "Blue", 2101));
		list.add(new Car("BMV", "White", 325));
		list.add(new Car("Mersedes", "Black", 124));
		list.add(new Car("Mersedes", "Red", 60));
		list.add(new Car("BMW", "Yellow", 720));
		list = CarService.carsCount(list, allCars);
		model.addAttribute("list", list);
		return "car";
	}
	
}