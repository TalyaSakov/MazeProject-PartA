package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleCompressorOutputStream extends OutputStream {
    public OutputStream outputStream;

    public SimpleCompressorOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    /**
     *  we will run over the matrix.
     *  In each run on a set of parametres of the same value, we count the number they have appeard (size of the group).
     *  the commpresed array will hold the amount of the appreance of each value, each time.
     */

    @Override
    public void write(byte[] unCompressedBytes) throws IOException {
      LinkedList<Byte> tempLinkedList = new LinkedList<>();
        int runningIndex = 0; //the running index on the unCompressedBytes array
        byte binaryVariable = 0; //Indicates zero or ones.

        while (runningIndex < unCompressedBytes.length) {
            byte sumBinaryVariable = 0;
            while (runningIndex < unCompressedBytes.length && unCompressedBytes[runningIndex] == binaryVariable) {
                if (sumBinaryVariable == 127) {
                    tempLinkedList.add(sumBinaryVariable);
                    sumBinaryVariable = 0;
                }
                sumBinaryVariable++; //holds the value for each group of same varialbe
                runningIndex ++;
            }
            tempLinkedList.add(sumBinaryVariable);
            if (binaryVariable == 0){binaryVariable = 1;}
            else{binaryVariable = 0;}
        }
        byte[] compressedBytes = new byte[tempLinkedList.size()];
        int iterationsAmount = tempLinkedList.size();
        for (int i = 0; i < iterationsAmount; i++) {
            compressedBytes[i] = tempLinkedList.pollFirst();
        }
        outputStream.write(compressedBytes);
    }
}

