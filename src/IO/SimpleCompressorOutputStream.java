package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleCompressorOutputStream extends OutputStream {
    OutputStream outputStream;

    public SimpleCompressorOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        return;
    }

    @Override
    public void write(byte[] unCompressedBytes) throws IOException {
//        byte[] compressedBytes = new byte[unCompressedBytes.length]; //first, with the same size of unCompressed
        LinkedList<Byte> tempLinkedList = new LinkedList<>();
        int runningIndex = 0; //the running index on the unCompressedBytes array
        int variableIndex = 0; //indicates the index of a class variable (like start postion, etc)
        byte binaryVariable = 0; //Indicates zero or ones.

        while (runningIndex <= unCompressedBytes.length) {
            byte sumBinaryVariable = 0;
            while (unCompressedBytes[runningIndex] == binaryVariable) {
                if (sumBinaryVariable == 127) {
                    tempLinkedList.add(sumBinaryVariable);
                    sumBinaryVariable = 0;
                }
                sumBinaryVariable++;
                runningIndex ++;
            }
            tempLinkedList.add(sumBinaryVariable);
            if (binaryVariable == 0){binaryVariable = 1;}
            else{binaryVariable = 0;}
            runningIndex ++;
        }
        byte[] compressedBytes = new byte[tempLinkedList.size()];
        for (int i = 0; i < tempLinkedList.size(); i++) {
            compressedBytes[i] = tempLinkedList.pollFirst();
        }
    }
}

