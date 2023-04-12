package car.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CarApplication implements CommandLineRunner {

	private final TestData testData;

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String[]> strings = testData.readCSV();
		testData.saveMakeToBase(strings);
		testData.saveCarToBase(strings);
	}
}
