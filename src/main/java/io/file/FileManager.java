package io.file;

import model.Country;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManager {
    private static final String FILE_NAME = "countries.csv";

    public static Map<String, Country> importCountries() throws FileNotFoundException {
        Map<String, Country> countries = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(FILE_NAME))
        ) {
            String[] split;

            while (scanner.hasNextLine()) {
                split = scanner.nextLine().split(";");
                countries.put(split[0], createCountryFromSplitString(split));
            }

            return countries;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Brak pliku " + FILE_NAME + ".");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Błąd formatu danych o populacji w pliku " + FILE_NAME);
        }
    }

    private static Country createCountryFromSplitString(String[] split) {
        return new Country(split[0], split[1], Integer.parseInt(split[2]));
    }
}
