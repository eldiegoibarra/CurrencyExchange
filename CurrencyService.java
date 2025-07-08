import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
// Este es mi comunicador con la API
public class CurrencyService {
    private final String apiKey;
    private static final String url = "https://v6.exchangerate-api.com/v6/";
    private final Gson gson = new Gson();

    public CurrencyService() {
        this.apiKey = EnvLoader.get("EXCHANGE_RATE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("❌ API key no encontrada en .env");
        }
    }

    public ExchangeResponse getExchangeRates(String baseCurrency) throws APIException {
        if (baseCurrency == null || baseCurrency.length() != 3) {
            throw new APIException("Invalid base currency code");
        }
        HttpClient client = HttpClient.newHttpClient();
        String fullURL = url + apiKey + "/latest/" + baseCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullURL))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new APIException("API returned status: " + response.statusCode());
            }
            return gson.fromJson(response.body(), ExchangeResponse.class);
        } catch (Exception e) {
            throw new APIException("Failed to get rates: " + e.getMessage());
        }
    }
}
