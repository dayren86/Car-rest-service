package car.rest.service.model;

public enum Make {
    AUDI("Audi"),
    CHEVROLET("Chevrolet"),
    CADILLAC("Cadillac"),
    ACURA("Acura"),
    BMW("BMW"),
    CHRYSLER("Chrysler"),
    FORD("Ford"),
    BUICK("Buick"),
    INFINITI("INFINITI"),
    GMC("GMC"),
    HONDA("Honda"),
    HYUNDAI("Hyundai"),
    JEEP("Jeep"),
    GENESIS("Genesis"),
    DODGE("Dodge"),
    JAGUAR("Jaguar"),
    KIA("Kia"),
    LANDROVER("Land Rover"),
    LEXUS("Lexus"),
    MERCEDESBENZ("Mercedes-Benz"),
    MITSUBISHI("Mitsubishi"),
    LINCOLN("Lincoln"),
    MAZDA("MAZDA"),
    NISSAN("Nissan"),
    MINI("MINI"),
    PORSCHE("Porsche"),
    RAM("Ram"),
    SUBARU("Subaru"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("Volkswagen"),
    VOLVO("Volvo"),
    ALFAROMEO("Alfa Romeo"),
    FIAT("FIAT"),
    FREIGHTLINER("Freightliner"),
    MASERATI("Maserati"),
    TESLA("Tesla"),
    ASTONMARTIN("Aston Martin"),
    BENTLEY("Bentley"),
    FERRARI("Ferrari"),
    LAMBORGHINI("Lamborghini"),
    LOTUS("Lotus"),
    MCLAREN("McLaren"),
    ROLLSROYCE("Rolls-Royce"),
    SMART("smart"),
    SCION("Scion"),
    SRT("SRT"),
    SUZUKI("Suzuki"),
    FISKER("Fisker"),
    MAYBACH("Maybach"),
    MERCURY("Mercury"),
    SAAB("Saab"),
    HUMMER("HUMMER"),
    PONTIAC("Pontiac"),
    SATURN("Saturn"),
    ISUZU("Isuzu"),
    PANOZ("Panoz"),
    OLDSMOBILE("Oldsmobile"),
    DAEWOO("Daewoo"),
    PLYMOUTH("Plymouth"),
    EAGLE("Eagle"),
    GEO("Geo"),
    DAIHATSU("Daihatsu"),
    POLESTAR("Polestar"),
    RIVIAN("Rivian");

    private final String value;

    Make(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
