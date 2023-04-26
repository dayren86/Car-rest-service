package car.rest.service;

import car.rest.service.model.Car;
import car.rest.service.model.Category;
import car.rest.service.model.Make;
import car.rest.service.service.CarService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TestData {

    private final CarService carService;

    public void saveCarToBase(List<String[]> carList) {
        List<Car> carListSave = new LinkedList<>();

        for (int i = 1; i < carList.size() - 1; i++) {
            String[] carString = carList.get(i);

            Car car = new Car();
            car.setObjectId(carString[0]);
            car.setModel(carString[3]);
            car.setYearRelease(carString[2]);
            car.setMake(Arrays.stream(Make.values()).filter(make -> make.getValue().equals(carString[1])).findFirst().orElseThrow());

            String[] splitCategory = carString[4].split(",");
            car.setCategory(Arrays.stream(Category.values()).filter(category -> category.getValue().equals(splitCategory[0])).findFirst().orElseThrow());

            carListSave.add(car);
        }

        carService.saveAllCar(carListSave);
    }

    public List<String[]> readCSV() {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/file.csv"))) {
            return csvReader.readAll();

        } catch (CsvException | IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
