package model;

public class Country {
    private final String countryCode;
    private final String countryName;
    private final int population;

    public Country(String countryCode, String countryName, int population) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) ma %d ludności.%n", countryName, countryCode, population);
    }
}
