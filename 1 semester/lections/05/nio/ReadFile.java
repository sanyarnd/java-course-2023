package tinkoff2.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        //в файле 3 байта
        FileChannel inChannel = FileChannel.open(Path.of("nio.txt"));

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf); //position = 3, bytesRead = 3
        while (bytesRead != -1) {
            buf.flip(); // limit = 3, position = 0

            while(buf.hasRemaining()) { // position < limit
                System.out.print((char) buf.get()); // position++
            }

            buf.clear(); //position = 0
            bytesRead = inChannel.read(buf);
        }
        inChannel.close();
    }
}
