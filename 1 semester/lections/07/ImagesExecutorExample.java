package org.example.lecture;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class ImagesExecutorExample {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        Callable<Void> callable = () -> {
            downloadImage();
            return null;
        };
        for (Future<Void> future : executorService.invokeAll(Stream.generate(() -> callable).limit(10).toList())) {
            future.get();
        }
        executorService.shutdown();
        System.out.println("Finish download images " + (System.currentTimeMillis() - start));
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
