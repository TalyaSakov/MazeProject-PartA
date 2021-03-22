package algorithms.mazeGenerators;

import java.util.Arrays;

public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
     public Maze generate(int column, int rows) {
        Maze maze =  new Maze(column,rows);
        for (int i = 0; i < maze.column ; i++) {
            for (int j = 0; j < maze.rows ; j++) {
                maze.maze[i][j] = (int) Math.round(Math.random());
            }
        }
        System.out.println(maze);
        return maze;
    }
}
