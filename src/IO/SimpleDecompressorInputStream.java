package IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class SimpleDecompressorInputStream extends InputStream {
    InputStream inputStream;


    public SimpleDecompressorInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int read(byte[] compressedBytes) throws IOException {
        inputStream.read(compressedBytes);

        LinkedList<Byte> tempLinkedList = new LinkedList<>();
        byte binaryVariable = 0; //Indicates zero or ones.

        for (byte tempByte : compressedBytes) {
            for (int j = 0; j < tempByte; j++) {
                tempLinkedList.add(binaryVariable);
            }
            if (binaryVariable == 0) {
                binaryVariable = 1;
            } else {
                binaryVariable = 0;
            }

        }
//        byte[] unCompressedBytes = new byte[tempLinkedList.size()];

        int iterationsAmount = tempLinkedList.size();
        for (int i = 0; i < iterationsAmount; i++) {
            compressedBytes[i] = tempLinkedList.pollFirst(); //Makeing compressedBytes to UncompressedBytes
        }
       return 0;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}