import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CurrencyCalculator {
    private static List<String> menuCurrency = new ArrayList<>();

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        System.out.println("Would you like to make the conversion?");
        option = keyboard.nextInt();
        if (option == 1) {
            int amount = 0;
            System.out.println("How much money do you want to convert?");
            amount = keyboard.nextInt();
            try {
                ProcessOption processOption = new ProcessOption();
                String result = processOption.process(option, menuCurrency, amount);


                double conversionRate = Double.parseDouble(result);
                double totalConverted = conversionRate * amount;
                System.out.println("Total converted: " + totalConverted);
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else if (option ==2) {
            System.out.println("Exiting...");
        } else {
            System.out.println("Invalid option. Please select a number between 1 and 2.");
        }
    }}