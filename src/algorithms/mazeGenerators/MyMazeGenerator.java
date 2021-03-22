package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int column, int rows) {
        int NewColumn = column -2;
        int NewRows = rows -2;
        Maze maze =  new Maze(NewColumn,NewRows);
        maze.maze[0][0] = 0;
        maze.maze[NewColumn-1][NewRows-1] = 0;
        final LinkedList<int[]> frontiers = new LinkedList<>();
        final Random random = new Random();
//        int x = random.nextInt(column);
//        int y = random.nextInt(rows);
        int x = 1; //column
        int y = 0; //rows
        frontiers.add(new int[]{x, y, x, y});

        while (!frontiers.isEmpty()) {
            final int[] f = frontiers.remove(random.nextInt(frontiers.size()));
            x = f[2];
            y = f[3];
            if (maze.maze[x][y] == 1) {
                 maze.maze[f[0]][f[1]] = maze.maze[x][y] = 0;
                if (x >= 2 && maze.maze[x - 2][y] == 1)
                    frontiers.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && maze.maze[x][y - 2] == 1)
                    frontiers.add(new int[]{x, y - 1, x, y - 2});
                if (x < NewColumn - 2 && maze.maze[x + 2][y] == 1)
                    frontiers.add(new int[]{x + 1, y, x + 2, y});
                if (y < NewRows - 2 && maze.maze[x][y + 2] == 1)
                    frontiers.add(new int[]{x, y + 1, x, y + 2});
            }
        }

        Maze newMaze = new Maze(column, rows);
        for( int i=0; i < column-2;i++) {
            for (int j = 0; j < rows -2; j++) {
                newMaze.maze[i+1][j+1] = maze.maze[i][j];
            }
        }
        newMaze.maze[1][0] = 0;
        newMaze.maze[column - 2][rows -1] = 0;

        return newMaze;
    }
}
