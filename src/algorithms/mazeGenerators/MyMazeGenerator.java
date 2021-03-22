package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int column, int rows) {
        Maze maze =  new Maze(column,rows);
        final LinkedList<int[]> frontiers = new LinkedList<>();
        final Random random = new Random();
        int x = random.nextInt(column);
        int y = random.nextInt(rows);
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
                if (x < column - 2 && maze.maze[x + 2][y] == 1)
                    frontiers.add(new int[]{x + 1, y, x + 2, y});
                if (y < rows - 2 && maze.maze[x][y + 2] == 1)
                    frontiers.add(new int[]{x, y + 1, x, y + 2});
            }
        }
        System.out.println(maze);
        return maze;
    }
}
