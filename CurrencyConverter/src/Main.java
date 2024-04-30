import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String apiKey = "8f98c1c276b671d1e2365031";

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int option;

        List<String> menuCurrency = new ArrayList<>(Arrays.asList(
                "1.- USD American dollar",
                "2.- MXN Mexican Peso",
                "3.- ARS Argentine Peso",
                "4.- BOB Bolivian Boliviano",
                "5.- BRL Brazilian Real",
                "6.- CLP Chilean Peso",
                "7.- COP Colombian Peso",
                "8.- Exit"
        ));

        do {
            displayMenu(menuCurrency);
            option = keyboard.nextInt();
            if (option != 8) {
                processOption(option, menuCurrency);
            }
        } while (option != 8);
        System.out.println("Exiting....");
    }

    private static void processOption(int option, List<String> menuCurrency) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        switch (option) {
            case 1, 2, 3, 4, 5, 6, 7:
                String[] selectedCurrencies = CurrencySelectionHelper.getCurrencySelection(option, menuCurrency, keyboard);
                String currencyFrom = selectedCurrencies[0];
                String currencyTo = selectedCurrencies[1];
                CurrencyAPI currencyAPI = new CurrencyAPI(apiKey, currencyFrom, currencyTo);
                String result = currencyAPI.getRequestResult();
                System.out.println(currencyFrom+" to "+currencyTo+" = "+result);
                break;
        }
    }

    private static void displayMenu(List<String> menuCurrency) {
        System.out.println("*************************************\n\n             Menu\n");
        for (String currency : menuCurrency) {
            System.out.println(currency);
        }
        System.out.println("\n**************************************\n\nPlease select an option between 1 and 8:");
    }
}
