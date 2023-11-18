import io.ConsolePrinter;
import io.file.FileManager;
import model.Country;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        ConsolePrinter printer = new ConsolePrinter();

        try {
            Map<String, Country> countries = FileManager.importCountries();
            printer.printLine("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
            String countryCode = scanner.nextLine().toUpperCase();
            printer.printCountryInfo(countryCode, findCountry(countryCode, countries));
        } catch (FileNotFoundException | NumberFormatException e) {
            printer.printLine(e.getMessage());
        }
    }

    private Country findCountry(String countryCode, Map<String, Country> countries) {
        return countries.get(countryCode);
    }

}
