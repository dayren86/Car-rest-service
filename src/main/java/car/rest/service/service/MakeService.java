package car.rest.service.service;

import car.rest.service.model.Make;
import car.rest.service.repository.MakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MakeService {

    private final MakeRepository makeRepository;

    public void saveMake(Make make) {
        makeRepository.save(make);
    }

    public void saveAllMake(List<Make> makeList) {
        makeRepository.saveAll(makeList);
    }

    public List<Make> getAllMake() {
        return makeRepository.findAll();
    }
}
