package models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;

public class Client {
    HttpClient client;
    
    public Client() {
        this.client = HttpClient.newHttpClient();
    }

    public String get(String url) {
        HttpRequest request = this.genGetBuilder(url);
        return sendRequest(request);
    }

    public String post(String url, String body, String... token) {        
        HttpRequest request = genPostBuilder(url, body, token);        
        return sendRequest(request);
    }

    public String put(String url, String body, String... token) {
        HttpRequest request = genPutBuilder(url, body, token);        
        return sendRequest(request);
    }

    public String delete(String url, String... token) {
        HttpRequest request = genDeleteBuilder(url, token);
        return sendRequest(request);
    }

    private HttpRequest genGetBuilder(String url, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);
        }
        return builder.build();
    }

    private HttpRequest genPostBuilder(String url, String body, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        builder.POST(HttpRequest.BodyPublishers.ofString(body));
        builder.header("Content-Type", "application/json");        
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);
        }
        return builder.build();
    }

    private HttpRequest genPutBuilder(String url, String body, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        builder.PUT(HttpRequest.BodyPublishers.ofString(body));
        builder.header("Content-Type", "application/json");
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);
        }
        return builder.build();
    }

    private HttpRequest genDeleteBuilder(String url, String... args) {
        Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url));
        builder.DELETE();
        if(args.length > 0) {
            String token = args[0];
            builder.header("Authorization", "Bearer " + token);
        }
        return builder.build();
    }

    private String sendRequest(HttpRequest request) {
        String result = "";
        try {
            result = trySendRequest(request);
        } catch (Exception e) {
            System.err.println("Hiba! A kérés sikertelen!");
            System.err.println(e.getMessage());
        }
        return result;
    }
    private String trySendRequest(HttpRequest request) 
            throws IOException, InterruptedException {
        HttpResponse<String> response = 
        client.send(request, BodyHandlers.ofString());
        return response.body();        
    }    
}
