package org.example.lecture;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class ImagesExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Thread> workers = Stream.generate(() -> new Thread(ImagesExample::downloadImage))
            .limit(5)
            .toList();
        workers.forEach(Thread::start);
        for (var worker : workers) {
            worker.join();
        }
        System.out.println("Finished download images");
    }

    private static void downloadImage() {
        try {
            URL url = new URL("https://source.unsplash.com/featured/300x201");
            InputStream in = new BufferedInputStream(url.openStream());
            Path path = Paths.get("image-" + UUID.randomUUID() + ".jpg");
            Files.write(path, in.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
