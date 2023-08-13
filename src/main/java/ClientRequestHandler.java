public class ClientRequestHandler {
    public static void main(String[] args) {
       ClientRequest clientRequest = new ClientRequest("client1");
       sentClientRequest(clientRequest, 0, 10);
    }

    public static void sentClientRequest(ClientRequest clientRequest, int start, int count) {
        for (int i = start; i < start + count; i++) {
            clientRequest.clientRequest(i);
        }
    }
}
