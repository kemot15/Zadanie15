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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (year != vehicle.year) return false;
        if (mileage != vehicle.mileage) return false;
        if (!typ.equals(vehicle.typ)) return false;
        if (!brand.equals(vehicle.brand)) return false;
        if (!model.equals(vehicle.model)) return false;
        return vin.equals(vehicle.vin);
    }

    @Override
    public int hashCode() {
        int result = typ.hashCode();
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        result = 31 * result + mileage;
        result = 31 * result + vin.hashCode();
        return result;
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
                '}';
    }
}
