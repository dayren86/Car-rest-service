package car.rest.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
public class Car {

    @Id
    private String objectId;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Make make;

    private String model;

    private String yearRelease;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Category category;
}
