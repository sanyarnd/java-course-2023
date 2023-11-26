package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public static long[] hackerNewsTopStories() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(TOP_STORIES_URL))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String[] ids = response.body().replaceAll("[\\[\\]\"]", "").split(",");
            long[] result = new long[ids.length];
            for (int i = 0; i < ids.length; i++) {
                result[i] = Long.parseLong(ids[i]);
            }
            return result;
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }
    }

    public static String news(long id) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(String.format(ITEM_URL, id)))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String titlePattern = "\"title\"\\s*:\\s*\"([^\"]+)\"";
            Pattern pattern = Pattern.compile(titlePattern);
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return "Title not found";
            }
        } catch (IOException | InterruptedException e) {
            return "Error fetching news";
        }
    }
}
