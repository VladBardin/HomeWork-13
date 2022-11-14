package Task1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetInfoByUsername {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---->Get info by username<----");
        String urlUsername = "https://jsonplaceholder.typicode.com/users?username=Leopoldo_Corkery";
        HttpRequest request5 = HttpRequest.newBuilder().uri(URI.create(urlUsername))
                .build();
        HttpClient client5 = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response5 = client5.send(request5, HttpResponse.BodyHandlers.ofString());
        System.out.println("response5.statusCode() = " + response5.statusCode());
        System.out.println("response5.body() = " + response5.body());
    }
}
