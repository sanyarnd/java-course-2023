package org.example.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CopyOnWriteArrayList {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(100000);
        List<Integer> values = Collections.synchronizedList(new ArrayList<>());
        Stream.generate(() -> new Thread(() -> {
                values.add(ThreadLocalRandom.current().nextInt(0, 1000));
                latch.countDown();
            }))
            .limit(100000)
            .forEach(Thread::start);
        latch.await();
        System.out.println(values.size());
    }

}
