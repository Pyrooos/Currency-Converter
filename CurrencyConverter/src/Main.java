import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Main {


    private static int amount;

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
                ProcessOption processOption = new ProcessOption();
                
                processOption.process(option, menuCurrency, amount);
            }
        } while (option != 8);
        System.out.println("Exiting....");
    }



    private static void displayMenu(List<String> menuCurrency) {
        System.out.println("*************************************\n\n             Menu\n");
        for (String currency : menuCurrency) {
            System.out.println(currency);
        }
        System.out.println("\n**************************************\n\nPlease select an option between 1 and 8:");
    }
}
