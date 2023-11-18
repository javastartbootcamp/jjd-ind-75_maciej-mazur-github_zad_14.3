package io;

import model.Country;

public class ConsolePrinter {
    public void printLine(String text) {
        System.out.println(text);
    }

    public void printCountryInfo(String countryCode, Country country) {
        if (country == null) {
            printLine("Kod kraju " + countryCode + " nie został znaleziony.");
        } else {
            printLine(country.toString());
        }
    }
}
