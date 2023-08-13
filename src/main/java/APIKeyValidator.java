import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIKeyValidator {
    private static APIKeyValidator instance;

    private APIKeyValidator() {
    }

    public static APIKeyValidator getInstance() {
        if (instance == null) {
            instance = new APIKeyValidator();
        }
        return instance;
    }

    public String getAPIKey(ClientCredentials credentials) {
        try {
            URL url = new URL("http://localhost:8080/auth");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            String requestBody = "{\"clientID\": \"" + credentials.getClientID() + "\", \"clientSecret\": \"" + credentials.getClientSecret() + "\"}";
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            String apiKey = connection.getHeaderField("X-API-KEY");
            connection.disconnect();
            return apiKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
