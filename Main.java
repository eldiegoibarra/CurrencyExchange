import java.util.InputMismatchException;
import java.util.Scanner;
import com.google.gson.JsonObject;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static CurrencyService currencyService = new CurrencyService();

    public static void main(String[] args) {
        while (true) {
            try {
                printMenu();
                int choice = scanner.nextInt();
                handleChoice(choice);
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Limpiando input invalido
            } catch (RuntimeException e) {
                System.err.println("Exchange service error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static void printMenu() {
        System.out.println("--- Currency Exchange ---");
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        System.out.println("3. USD to GBP");
        System.out.println("4. GBP to USD");
        System.out.println("5. USD to CLP");
        System.out.println("6. CLP to USD");
        System.out.println("7. Salir");
        System.out.print("Choose one option: ");
    }

    public static void handleChoice(int choice) {
        String baseCurrency = "";
        String targetCurrency = "";

        try {
            switch (choice) {
                case 1:
                    System.out.println("USD to EUR");
                    baseCurrency = "USD";
                    targetCurrency = "EUR";
                    break;
                case 2:
                    System.out.println("EUR to USD");
                    baseCurrency = "EUR";
                    targetCurrency = "USD";
                    break;
                case 3:
                    System.out.println("USD to GBP");
                    baseCurrency = "USD";
                    targetCurrency = "GBP";
                    break;
                case 4:
                    System.out.println("GBP to USD");
                    baseCurrency = "GBP";
                    targetCurrency = "USD";
                    break;
                case 5:
                    System.out.println("USD to CLP");
                    baseCurrency = "USD";
                    targetCurrency = "CLP";
                    break;
                case 6:
                    System.out.println("CLP to USD");
                    baseCurrency = "CLP";
                    targetCurrency = "USD";
                    break;
                case 7:
                    System.out.println("Exiting... ");
                    System.exit(0);
                default:
                    System.out.println("Not valid");
                    return; // Importante: salir del método si la opción no es válida
            }

            System.out.println("Please add the amount you would like to convert: ");
            double amount = scanner.nextDouble();

            ExchangeResponse exchangeRates = currencyService.getExchangeRates(baseCurrency);
            CurrencyConverter converter = new CurrencyConverter(exchangeRates);
            double convertedAmount = converter.convert(amount, baseCurrency, targetCurrency);

            // Mostrar el resultado
            System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);

        } catch (APIException e) {
            System.err.println("API Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Error al obtener los tipos de cambio: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}