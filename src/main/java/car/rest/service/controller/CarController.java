package car.rest.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(name = "/")
public class CarController {

    @GetMapping
    public ModelAndView getFindCarMVC() {
        ModelAndView modelAndView = new ModelAndView("findCar");
        modelAndView.addObject("findAllMake");

        return modelAndView;
    }
}
