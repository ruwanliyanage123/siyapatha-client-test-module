import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientRequest {
    private String name;

    public ClientRequest(String name) {
        this.name = name;
    }
    public void clientRequest(int number) {
        try {
            URL url = new URL("http://localhost:8080/book");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            String requestBody = "{\"isbn\": "+ number +", \"name\": \"The secret"+number+"\", \"author\": \""+name+"\", \"price\": 49.99}";
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

