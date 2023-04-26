package car.rest.service.service;

import car.rest.service.model.Car;
import car.rest.service.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private String sortSave;

    public void savaCar(Car car) {
        carRepository.save(car);
    }

    public void saveAllCar(List<Car> carList) {
        carRepository.saveAll(carList);
    }

    public List<Car> findAllCar() {
        return carRepository.findAll();
    }

    public Car findCarByObjectId(String objectId) {
        return carRepository.findById(objectId).orElseThrow();
    }

    public List<Car> searchCar(String make, String model, Integer minYear, Integer maxYear, String category) {

        List<Car> collect = carRepository.findAll().stream().filter(car -> car.getMake().toString().equals(make)).collect(Collectors.toList());

        System.out.println(collect.size());

        if (!category.isEmpty()) {
            collect = collect.stream().filter(car -> car.getCategory().toString().equals(category)).collect(Collectors.toList());

            System.out.println(collect.size());
        }

        if (minYear != null && maxYear != null) {
            List<Integer> collectYear = IntStream.rangeClosed(minYear, maxYear).boxed().collect(Collectors.toList());

            collect = collect.stream().filter(car -> collectYear.contains(Integer.valueOf(car.getYearRelease()))).collect(Collectors.toList());

            System.out.println(collect.size());
        }

        if (!model.isEmpty()) {
            collect = collect.stream().filter(car -> car.getModel().equalsIgnoreCase(model)).collect(Collectors.toList());
            System.out.println(collect.size());
        }

        return collect;
    }

    public Page<Car> findPage(Integer page, String sort) {
        if (sort != null) {
            sortSave = sort;
        }

        if (sortSave == null) {
            return carRepository.findAll(PageRequest.of(page, 20));
        }

        PageRequest of = PageRequest.of(page, 20, Sort.by(sortSave));
        return carRepository.findAll(of);
    }

    public void updateCar(Car car) {
        Car carByObjectId = findCarByObjectId(car.getObjectId());
        carByObjectId.setMake(car.getMake());
        carByObjectId.setModel(car.getModel());
        carByObjectId.setYearRelease(car.getYearRelease());
        carByObjectId.setCategory(car.getCategory());

        carRepository.save(carByObjectId);
    }

    public void deleteCar(String objectId) {
        carRepository.deleteById(objectId);
    }
}
