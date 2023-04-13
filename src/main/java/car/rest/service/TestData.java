package car.rest.service;

import car.rest.service.model.Car;
import car.rest.service.model.Category;
import car.rest.service.model.Make;
import car.rest.service.service.CarService;
import car.rest.service.service.MakeService;
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
    private final MakeService makeService;

    public void saveMakeToBase(List<String[]> carList) {
        Set<Make> makeSet = new LinkedHashSet<>();

        for (int i = 1; i < carList.size() - 1; i++) {
            String[] makeArray = carList.get(i);

            Make make = new Make();
            make.setName(makeArray[1]);

            makeSet.add(make);
        }

        makeService.saveAllMake(new ArrayList<>(makeSet));
    }

    public void saveCarToBase(List<String[]> carList) {
        List<Make> allMake = makeService.getAllMake();

        List<Car> carListSave = new LinkedList<>();

        for (int i = 1; i < carList.size() - 1; i++) {
            String[] strings = carList.get(i);

            Car car = new Car();
            car.setObjectId(strings[0]);
            car.setMake(allMake.stream().filter(make -> make.getName().equals(strings[1])).findFirst().get());
            car.setModel(strings[3]);
            car.setYearRelease(strings[2]);

            String[] splitCategory = strings[4].toUpperCase().split(",");

            for (int j = 0; j < splitCategory.length; j++) {
                if (splitCategory[j].trim().equals("VAN/MINIVAN")) {
                    car.setCategory(Category.valueOf("VANMINIVAN"));
                }else {
                    car.setCategory(Category.valueOf(splitCategory[j].trim()));
                }
            }

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
