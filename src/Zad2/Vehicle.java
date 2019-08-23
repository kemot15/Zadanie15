package Zad2;

public class Vehicle {
    private String typ;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private String vin;

    public Vehicle() {
    }

    public Vehicle(String typ, String brand, String model, int year, int mileage, String vin) {
        this.typ = typ;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vin = vin;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "typ='" + typ + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", vin='" + vin + '\'' +
                "}";
    }
}
