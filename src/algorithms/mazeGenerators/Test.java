package algorithms.mazeGenerators;

import IO.MyDecompressorInputStream;
import IO.SimpleCompressorOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;


public class Test {


    private static byte[] write (byte[] unCompressedBytes){
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
                sumBinaryVariable++;
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
        return compressedBytes;
    }


    private static byte[] decompress(byte[] compressedBytes) {
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
        int iterationsAmount = tempLinkedList.size();
        for (int i = 0; i < iterationsAmount; i++) {
            unCompressedBytes[i] = tempLinkedList.pollFirst();
        }
        return unCompressedBytes;
    }


    public static void main(String[] args){
        MyMazeGenerator test = new MyMazeGenerator();
        Maze maze=test.generate(10,10);
        System.out.println("MAZE BEFORE COMPRESS");
        maze.print();
        byte[] bytes= maze.toByteArray();
//        System.out.println(Arrays.toString(bytes));
        byte[] compressedBytes = write(bytes);
//        System.out.println(Arrays.toString(compressedBytes));
        System.out.println("---------------------------------------------------");
        byte[] unCompressedBytes = decompress(compressedBytes);
//        System.out.println(Arrays.toString(unCompressedBytes));
        Maze maze2 = new Maze(unCompressedBytes);
        System.out.println("Maze After Compress");
        maze2.print();
    }
}
