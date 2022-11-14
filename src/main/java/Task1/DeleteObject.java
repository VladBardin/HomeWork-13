package Task1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteObject {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---->Delete<----");
        String urlDel = "https://jsonplaceholder.typicode.com/users/9";
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(urlDel))
                .DELETE()
                .build();
        HttpClient client2 = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
        System.out.println("response2.statusCode() = " + response2.statusCode());
        System.out.println("response2.body() = " + response2.body());
    }
}
