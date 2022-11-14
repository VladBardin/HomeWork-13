package Task1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetInfoAllUsers {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---->Get info about all users<----");
        String urlInfo = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request3 = HttpRequest.newBuilder().uri(URI.create(urlInfo))
                .build();
        HttpClient client3 = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response3 = client3.send(request3, HttpResponse.BodyHandlers.ofString());
        System.out.println("response3.statusCode() = " + response3.statusCode());
        System.out.println("response3.body() = " + response3.body());
    }
}
