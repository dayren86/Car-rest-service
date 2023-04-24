package car.rest.service.controller;

import car.rest.service.model.Car;
import car.rest.service.model.Category;
import car.rest.service.model.Make;
import car.rest.service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(name = "/")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ModelAndView getCarMVC(@RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "sort", required = false) String sort) {

        ModelAndView modelAndView = new ModelAndView("main");
        System.out.println(sort);

        Page<Car> pages = carService.findPage(Optional.ofNullable(page).orElse(0), sort);

        modelAndView.addObject("pagedObject", pages);

        return modelAndView;
    }

    @GetMapping("/upadatetemplate/{objectId}")
    public ModelAndView updateUserMVC(@PathVariable("objectId") String objectId) {
        ModelAndView carMVC = new ModelAndView("updatecar");
        carMVC.addObject("car", carService.findCarByObjectId(objectId));
        carMVC.addObject("categoryArray", Category.values());
        carMVC.addObject("makeArray", Make.values());

        return carMVC;
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute(name = "user") Car car) {
        carService.updateCar(car);

        return "redirect:/";
    }

    @PostMapping("/{objectId}")
    public String deleteUser(@PathVariable("objectId") String objectId) {
        carService.deleteCar(objectId);

        return "redirect:/";
    }

}
