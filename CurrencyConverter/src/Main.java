import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

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
            if(option != 8) {
                processOption(option, menuCurrency);
            }
        } while (option != 8);
        System.out.println("Exiting....");
    }

    private static void processOption(int option, List<String> menuCurrency) throws IOException {
        CurrencyAPI urlStr = new CurrencyAPI();
        Scanner keyboard = new Scanner(System.in);
        switch (option) {

            case 1:


                String selectedCurrency = menuCurrency.get(option - 1);
                String[] parts = selectedCurrency.split(" ");
                String currency = parts[1];
                System.out.println("You selected: " + currency + "\n");
                String currencyFrom = currency;
                System.out.println("Please enter the number option for the second currency:");
                int optionCurrency2 = keyboard.nextInt();
                String selectedCurrency2 = menuCurrency.get(optionCurrency2 - 1);
                String[] parts2 = selectedCurrency2.split(" ");
                String currency2Value = parts2[1];
                System.out.println("You selected: " + currency2Value + "\n");
                String currencyTo = currency2Value;
                ;
                String result = urlStr.getRequestResult();
                System.out.println(result);
            case 2:


                selectedCurrency = menuCurrency.get(option - 1);
                parts = selectedCurrency.split(" ");
                currency = parts[1];
                System.out.println("You selected: " + currency + "\n");
                currencyFrom = currency;
                System.out.println("Please enter the number option for the second currency:");
                optionCurrency2 = keyboard.nextInt();
                selectedCurrency2 = menuCurrency.get(optionCurrency2 - 1);
                parts2 = selectedCurrency2.split(" ");
                currency2Value = parts2[1];
                System.out.println("You selected: " + currency2Value + "\n");
                currencyTo = currency2Value;

                result = urlStr.getRequestResult();
                System.out.println(result);



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
