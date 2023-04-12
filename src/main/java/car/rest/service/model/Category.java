package car.rest.service.model;

public enum Category {
    CONVERTIBLE("Convertible"),
    COUPE("Coupe"),
    HATCHBACK("Hatchback"),
    PICKUP("Pickup"),
    SEDAN("Sedan"),
    SUV("SUV"),
    SUV1992("SUV1992"),
    SUV2020("SUV2020"),
    VANMINIVAN("Van/Minivan"),
    WAGON("Wagon");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
