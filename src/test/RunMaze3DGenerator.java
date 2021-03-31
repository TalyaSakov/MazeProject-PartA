package test;

import algorithms.maze3D.IMazeGenerator3D;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

public class RunMaze3DGenerator {
        public static void main(String[] args) {
            MyMaze3DGenerator myMaze3DGenerator = new MyMaze3DGenerator();
// prints the time it takes the algorithm to run
//    System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(100/*rows*/,100/*columns*/)));
// generate another maze
            long start = System.currentTimeMillis();
            Maze3D maze = myMaze3DGenerator.generate(500,500,500);
            long finish = System.currentTimeMillis();
            System.out.println(finish - start);
// prints the maze
//            maze.print();
// get the maze entrance
//        Position startPosition = maze.getStartPosition();
//// print the start position
//        System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"
//// prints the maze exit position
//        System.out.println(String.format("Goal Position: %s", maze.getEndPosition()));
        }
}
