public class ClientRequestHandler {
    public static void main(String[] args) {
        String apiKey1 = getAPIKey(new ClientCredentials("client_id_1", "11111"));
        String apiKey2 = getAPIKey(new ClientCredentials("client_id_2", "22222"));
        //String apiKey3 = getAPIKey(new ClientCredentials("client_id_3", "33333"));
        String apiKey3 = null;

        ClientRequest client1 = new ClientRequest("client1", apiKey1);
        ClientRequest client2 = new ClientRequest("client2", apiKey2);
        ClientRequest client3 = new ClientRequest("client3", apiKey3);

        sentClientRequest(client1, 100, 10);
        sentClientRequest(client2, 200, 10);
        sentClientRequest(client3, 300, 10);
    }

    public static void sentClientRequest(ClientRequest clientRequest, int start, int count) {
        for (int i = start; i < start + count; i++) {
            clientRequest.clientRequest(i);
        }
    }

    private static String getAPIKey(ClientCredentials credentials){
        return APIKeyValidator.getInstance().getAPIKey(credentials);
    }
}
