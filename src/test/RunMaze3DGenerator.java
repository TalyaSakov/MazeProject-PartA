package test;

import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
public class RunMaze3DGenerator {
        public static void main(String[] args) {
            MyMaze3DGenerator myMaze3DGenerator = new MyMaze3DGenerator();
// prints the time it takes the algorithm to run
//    System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(100/*rows*/,100/*columns*/)));
// generate another maze

            Maze3D maze = myMaze3DGenerator.generate(3,10,10);

// prints the maze
            maze.print();
// get the maze entrance
//        Position startPosition = maze.getStartPosition();
//// print the start position
//        System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"
//// prints the maze exit position
//        System.out.println(String.format("Goal Position: %s", maze.getEndPosition()));
        }
}
