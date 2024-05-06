import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProcessOption {
    public String process(int option, List<String> menuCurrency, int amount) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String result = "";
        switch (option) {

            case 1, 2, 3, 4, 5, 6, 7:

                String[] selectedCurrencies = CurrencySelectionHelper.getCurrencySelection(option, menuCurrency, keyboard);
                CurrencyAPI currencyAPI = new CurrencyAPI(selectedCurrencies[0], selectedCurrencies[1] );
                currencyAPI.setCurrencyFrom(selectedCurrencies[0]);
                currencyAPI.setCurrencyTo(selectedCurrencies[1]);
                result = currencyAPI.getRequestResult();
                System.out.println(currencyAPI.getCurrencyFrom() + " to " + currencyAPI.getCurrencyTo() + " = " + result);
                CurrencyCalculator currencyCalculator = new CurrencyCalculator();
                CurrencyCalculator.main(null);
                break;

            default:
                System.out.println("Invalid option, Please select a number between 1 and 7.");
        }
        return result;
    }
}
