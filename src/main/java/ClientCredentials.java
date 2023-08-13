public class ClientCredentials {
    private String clientID;
    private String clientSecret;

    public ClientCredentials(String clientID, String clientSecret){
        this.clientID = clientID;
        this.clientSecret = clientSecret;
    }

    public String getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
