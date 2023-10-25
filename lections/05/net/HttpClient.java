package tinkoff2.net;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.net.http.HttpClient.newHttpClient;
import static java.time.temporal.ChronoUnit.SECONDS;

public class HttpClient {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(new URI("http://postman-echo.com/get"))
                .GET()
                .header("AcceptEncoding", "gzip")
                .timeout(Duration.of(10, SECONDS))
                .build();

        var response = newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
