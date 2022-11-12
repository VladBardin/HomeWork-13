package HomeTask13;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HomeTask13 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---->Create a new object<----");
        String url = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString("""
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
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());

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

        System.out.println("---->Task two<----");
        for (int n = 46; n <= 50; n++) {
            String urlC = "https://jsonplaceholder.typicode.com/posts/10/comments/?id=" + n;
            HttpRequest request6Comments = HttpRequest.newBuilder().uri(URI.create(urlC))
                    .build();
            HttpClient client6Comments = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();
            HttpResponse<String> response6Comments = client6Comments.send(request6Comments, HttpResponse.BodyHandlers.ofString());
            System.out.println("StatusCode() = " + response6Comments.statusCode());
            System.out.println("Body() = " + response6Comments.body());
            String[] arr = response6Comments.body().split("\n");
            String comment = arr[4] + "\n" + arr[6];
            try (FileWriter file = new FileWriter("user-" + n + "-post-" + "10-comments.json")) {
                file.write(comment);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---->Task Three<----");
        String urlCompleted = "https://jsonplaceholder.typicode.com/users/1/todos?completed=false";
        HttpRequest request7 = HttpRequest.newBuilder().uri(URI.create(urlCompleted))
                .build();
        HttpClient client7 = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response7 = client7.send(request7, HttpResponse.BodyHandlers.ofString());
        System.out.println("TaskThree.statusCode() = " + response7.statusCode());
        System.out.println("TaskThree.body() = " + response7.body());
    }
}
