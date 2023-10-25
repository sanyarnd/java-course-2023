package tinkoff2.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MMFile {
    static int length = 1024;

    public static void main(String[] args) throws Exception {
        try (RandomAccessFile file = new RandomAccessFile("memory_mapped.dat", "rw")) {
            MappedByteBuffer out = file.getChannel()
                    .map(FileChannel.MapMode.READ_WRITE, 0, length);

            for (int i = 0; i < length; i++) {
                out.put((byte) 'x');
            }
        }
    }
}
