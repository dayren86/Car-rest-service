package car.rest.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Car {

    @Id
    private String objectId;

    @Enumerated(EnumType.STRING)
    private Make make;

    private String model;

    private String yearRelease;

    @Enumerated(EnumType.STRING)
    private Category category;
}
