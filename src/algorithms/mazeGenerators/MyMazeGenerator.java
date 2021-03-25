package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int column) {
        int NewColumn = column -2;
        int NewRows = rows -2;
        Maze maze =  new Maze(NewRows,NewColumn);
        maze.maze[0][0] = 0;
        maze.maze[NewRows-1][NewColumn-1] = 0;
        final LinkedList<int[]> frontiers = new LinkedList<>();
        final Random random = new Random();
//        int x = random.nextInt(column);
//        int y = random.nextInt(rows);
        int x = 0; //rows
        int y = 1; //column
        frontiers.add(new int[]{x, y, x, y});

        while (!frontiers.isEmpty()) {
            final int[] f = frontiers.remove(random.nextInt(frontiers.size()));
            x = f[2];
            y = f[3];
            maze.print();
            if (maze.maze[x][y] == 1) {
                 maze.maze[f[0]][f[1]] = maze.maze[x][y] = 0;
                if (x >= 2 && maze.maze[x - 2][y] == 1)
                    frontiers.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && maze.maze[x][y - 2] == 1)
                    frontiers.add(new int[]{x, y - 1, x, y - 2});
                if (x < NewRows - 2 && maze.maze[x + 2][y] == 1)
                    frontiers.add(new int[]{x + 1 , y, x + 2, y});
                if (y < NewColumn - 2 && maze.maze[x][y + 2] == 1)
                    frontiers.add(new int[]{x, y + 1 , x, y + 2});
            }
        }

        Maze newMaze = new Maze(rows, column);
        for( int i=0; i < rows-2;i++) {
            for (int j = 0; j < column -2; j++) {
                newMaze.maze[i+1][j+1] = maze.maze[i][j];
            }
        }
        newMaze.maze[0][1] = 0;
        newMaze.maze[rows -1][column -2] = 0;
        return newMaze;
    }
}
