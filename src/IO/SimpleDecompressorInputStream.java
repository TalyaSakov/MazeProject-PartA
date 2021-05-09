package IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class SimpleDecompressorInputStream extends InputStream {
    InputStream inputStream;

    /**
     *We will go over all the values ​​of the compressed array.
     * Each value of 0 or 1 is opened according to the number of its instances
     * respectively in the compressed array
     */

    public SimpleDecompressorInputStream(InputStream inputStream) {
        this.inputStream = inputStream; //Bytearrayinputstream(compressed)
    }

    public int read(byte[] decompressedBytes) throws IOException {

        inputStream.read(decompressedBytes);

        LinkedList<Byte> tempLinkedList = new LinkedList<>();
        byte binaryVariable = 0; //Indicates zero or ones.

        for (byte tempByte : decompressedBytes) {
            for (int j = 0; j < tempByte; j++) {
                tempLinkedList.add(binaryVariable);
            }
            if (binaryVariable == 0) {
                binaryVariable = 1;
            } else {
                binaryVariable = 0;
            }
        }

//        compressedBytes = new byte[tempLinkedList.size()];
        int iterationsAmount = tempLinkedList.size();
        for (int i = 0; i < iterationsAmount; i++) {
            decompressedBytes[i] = tempLinkedList.pollFirst(); //Making compressedBytes to UncompressedBytes
        }

       return 0;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}