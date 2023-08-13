public class ClientRequestHandler {
    public static void main(String[] args) {
        ClientRequest client1 = new ClientRequest("client1");
        ClientRequest client2 = new ClientRequest("client2");
        ClientRequest client3 = new ClientRequest("client3");

        sentClientRequest(client1, 100, 10, null);
        sentClientRequest(client2, 200, 10, null);
        sentClientRequest(client3, 300, 10, null);
    }

    public static void sentClientRequest(ClientRequest clientRequest, int start, int count, String token) {
        for (int i = start; i < start + count; i++) {
            clientRequest.clientRequest(i, token);
        }
    }
}
