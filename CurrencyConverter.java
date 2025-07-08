import java.util.Map;
//Logica de conversion
public class CurrencyConverter {
    private final ExchangeResponse exchangeRates;

    // Constructor
    public CurrencyConverter(ExchangeResponse exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public double convert(double amount, String from, String to) {
        // Obteniendo los rates
        Map<String, Double> rates = exchangeRates.getRates();

        // Validando las divisas
        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        // La matematica
        double result = amount * (rates.get(to) / rates.get(from));
        return Math.round(result * 100.0) / 100.0;
    }
}