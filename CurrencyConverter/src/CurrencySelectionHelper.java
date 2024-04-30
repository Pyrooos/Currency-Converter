import java.util.List;
import java.util.Scanner;

public class CurrencySelectionHelper {
    public static String[] getCurrencySelection(int option, List<String> menuCurrency, Scanner keyboard) {
        String[] currencies = new String[2];
        String selectedCurrency = menuCurrency.get(option - 1);
        String[] parts = selectedCurrency.split(" ");
        currencies[0] = parts[1];
        System.out.println("You selected: " + currencies[0] + "\n");
        System.out.println("Please enter the number option for the second currency:");
        int optionCurrency2 = keyboard.nextInt();
        String selectedCurrency2 = menuCurrency.get(optionCurrency2 - 1);
        String[] parts2 = selectedCurrency2.split(" ");
        currencies[1] = parts2[1];
        System.out.println("You selected: " + currencies[1] + "\n");
        return currencies;
    }
}
