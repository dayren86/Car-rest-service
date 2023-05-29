package car.rest.service.controller;

import car.rest.service.model.Car;
import car.rest.service.model.Category;
import car.rest.service.model.Make;
import car.rest.service.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/")
@SecurityRequirement(name = "openid")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ModelAndView getCarMVC(@RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "sort", required = false) String sort) {

        ModelAndView modelAndView = new ModelAndView("main");

        Page<Car> pages = carService.findPage(Optional.ofNullable(page).orElse(0), sort);

        modelAndView.addObject("pagedObject", pages);

        return modelAndView;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createcartemplate")
    public ModelAndView createCarMVC() {
        return new ModelAndView("createcar").addObject("makeArray", Make.values()).addObject("categoryArray", Category.values());
    }

    @Operation(summary = "Create car")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public String createCar(@ModelAttribute(name = "car") Car car) {
        carService.saveCar(car);

        return "redirect:/";
    }

    @Operation(summary = "Update car")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/updatetemplate/{objectId}")
    public ModelAndView updateUserMVC(@PathVariable("objectId") String objectId) {
        ModelAndView carMVC = new ModelAndView("updatecar");
        carMVC.addObject("car", carService.findCarByObjectId(objectId));
        carMVC.addObject("categoryArray", Category.values());
        carMVC.addObject("makeArray", Make.values());

        return carMVC;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public String updateUser(@ModelAttribute(name = "car") Car car) {
        carService.updateCar(car);

        return "redirect:/";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{objectId}")
    public String deleteUser(@PathVariable("objectId") String objectId) {
        carService.deleteCar(objectId);

        return "redirect:/";
    }

    @GetMapping("/searchtemplate")
    public ModelAndView searchCarMVC() {
        return new ModelAndView("search").addObject("makeArray", Make.values()).addObject("categoryArray", Category.values());
    }

    @GetMapping("/searchcar")
    public ModelAndView search(@RequestParam(value = "make", required = false) String make,
                               @RequestParam(value = "model", required = false) String model,
                               @RequestParam(value = "minYear", required = false) Integer minYear,
                               @RequestParam(value = "maxYear", required = false) Integer maxYear,
                               @RequestParam(value = "category", required = false) String category) {

        List<Car> carList = carService.searchCar(make, model, minYear, maxYear, category);

        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("pagedObject", carList)
                .addObject("makeArray", Make.values())
                .addObject("categoryArray", Category.values());

        return modelAndView;
    }
}
