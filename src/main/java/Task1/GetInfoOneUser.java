package Task1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetInfoOneUser {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---->Get info about one user<----");
        String urlUser = "https://jsonplaceholder.typicode.com/users/10";
        HttpRequest request4 = HttpRequest.newBuilder().uri(URI.create(urlUser))
                .build();
        HttpClient client4 = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response4 = client4.send(request4, HttpResponse.BodyHandlers.ofString());
        System.out.println("response4.statusCode() = " + response4.statusCode());
        System.out.println("response4.body() = " + response4.body());
    }
}
