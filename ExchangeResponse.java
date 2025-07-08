import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ExchangeResponse {
    @SerializedName("base_code")
    private String baseCurrency;

    @SerializedName("conversion_rates")
    private Map<String, Double> rates;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}