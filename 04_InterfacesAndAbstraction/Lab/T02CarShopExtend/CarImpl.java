package CarShop;

public class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public Integer getHorsePower() {
        return this.horsePower;
    }


    public String countryProduced() {
        return this.countryProduced;
    }

    public Double getPrice() {
        return null;
    }

    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.model, this.countryProduced, Car.TIRES);
    }
}
