package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyCompressorOutputStream extends OutputStream {

    OutputStream outputStream;

    public MyCompressorOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] unCompressedBytes) throws IOException {
        byte[] compressedBytes = new byte[unCompressedBytes.length]; //first, with the same size of unCompressed
        int runningIndex = 0;
        int variableIndex = 0;
        int compressionIndex = getMazeIndex(unCompressedBytes, runningIndex, variableIndex);
        while (runningIndex <= compressionIndex){
            compressedBytes[runningIndex] = unCompressedBytes[runningIndex];
            runningIndex ++;
        }
        while (runningIndex <= unCompressedBytes.length){
            int sumOnes = 0;
            while (unCompressedBytes[runningIndex] != 0){
               sumOnes ++;
            }


        }
    }


    private int getMazeIndex(byte[] unCompressedBytes, int runningIndex, int variableIndex) {
        while (variableIndex < 6){
            if (unCompressedBytes[runningIndex] == -1 ){
                variableIndex++;
                runningIndex++; }
            else { runningIndex++;
        }
    }
        return runningIndex;
    }
}

