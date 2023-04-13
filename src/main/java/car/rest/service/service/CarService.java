package car.rest.service.service;

import car.rest.service.model.Car;
import car.rest.service.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void saveAllCar(List<Car> carList) {
        carRepository.saveAll(carList);
    }
}
