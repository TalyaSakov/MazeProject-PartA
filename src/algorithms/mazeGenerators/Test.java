package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class Test {

    public static void main(String[] args){
        MyMazeGenerator test = new MyMazeGenerator();
        Maze maze=test.generate(5,5);
        byte[] bytes= maze.toByteArray();
        System.out.println(bytes);




    }
}
