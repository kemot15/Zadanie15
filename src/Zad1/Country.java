package Zad1;

public class Country {
    private String id;
    private String name;
    private int population;

    public Country() {
    }

    public Country(String id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return name + " (" +  id + ") ma " + population + " ludnosci";
    }
}
