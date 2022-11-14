package Task1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UpdateObject {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---->Update the object<----");
        String urlUpd = "https://jsonplaceholder.typicode.com/users/1";
        HttpRequest request1 = HttpRequest.newBuilder().uri(URI.create(urlUpd))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("""
                        {
                          "name": "Kurtis1 Weissnat111",
                          "username": "Elwyn.Skiles1",
                          "email": "Telly1.Hoeger@billy.biz",
                          "address": {
                            "street": "Rex Trail",
                            "suite": "Suite 280",
                            "city": "Howemouth",
                            "zipcode": "58804-1099",
                            "geo": {
                              "lat": "24.8918",
                              "lng": "21.8984"
                            }
                          },
                          "phone": "210.067.6132",
                          "website": "elvis.io",
                          "company": {
                            "name": "Johns Group",
                            "catchPhrase": "Configurable multimedia task-force",
                            "bs": "generate enterprise e-tailers"
                          }
                        }""".indent(2)))
                .build();
        HttpClient client1 = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());
        System.out.println("response1.statusCode() = " + response1.statusCode());
        System.out.println("response1.body() = " + response1.body());
    }
}
