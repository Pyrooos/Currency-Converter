import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyAPI {
    private static final String baseUrl = "https://v6.exchangerate-api.com/v6/";
    private String apiKey="8f98c1c276b671d1e2365031";
    private String currencyFrom;
    private String currencyTo;
    private String urlStr;

    public CurrencyAPI( String currencyFrom, String currencyTo) {

        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.urlStr = baseUrl + apiKey + "/pair/" + currencyFrom + "/" + currencyTo;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public String getRequestResult() throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        return jsonobj.get("conversion_rate").getAsString();
    }
}
