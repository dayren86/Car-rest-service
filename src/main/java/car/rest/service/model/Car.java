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

    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

    private String model;

    private String  yearRelease;

    @Enumerated(EnumType.STRING)
    private Category category;
}
