package car.rest.service.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "make", fetch = FetchType.EAGER)
    private Set<Car> carSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Make make = (Make) o;
        return Objects.equals(name, make.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
