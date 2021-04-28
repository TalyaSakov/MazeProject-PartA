package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

public class SimpleDecompressorInputStream extends OutputStream {
    OutputStream outputStream;

    @Override
    public void write(int b) throws IOException {

    }

    public void write(byte[] compressedBytes) throws IOException {
        LinkedList<Byte> tempLinkedList = new LinkedList<>();
        int runningIndex = 0; //the running index on the unCompressedBytes array
        byte binaryVariable = 0; //Indicates zero or ones.

        for (int i = 0; i < compressedBytes.length; i++) {
            byte tempByte = compressedBytes[i];
            for (int j = 0; j < tempByte; j++) {
                tempLinkedList.add(binaryVariable);
            }
            if (binaryVariable == 0){binaryVariable = 1;}
            else{binaryVariable = 0;}

        }
        byte[] unCompressedBytes = new byte[tempLinkedList.size()];
        for (int i = 0; i < tempLinkedList.size(); i++) {
            compressedBytes[i] = tempLinkedList.pollFirst();
        }
    }

}
