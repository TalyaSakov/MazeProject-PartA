package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {

    boolean makeStartAndEnd = true;

    public Maze generate(int rows, int column, boolean makeStartAndEnd) {
        this.makeStartAndEnd = makeStartAndEnd;
        return generate(rows, column);
    }
    @Override
    public Maze generate(int rows, int column) {
        Maze maze =  new Maze(rows,column);
        final LinkedList<int[]> frontiers = new LinkedList<>();
        final Random random = new Random();
        int x= ((rows/2));
        int y= (0);
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
                if (x < rows - 2 && maze.maze[x + 2][y] == 1)
                    frontiers.add(new int[]{x + 1 , y, x + 2, y});
                if (y < column - 2 && maze.maze[x][y + 2] == 1)
                    frontiers.add(new int[]{x, y + 1 , x, y + 2});
            }
        }
        Random rd = new Random();
        //fixing the most right
        for (int i = 0; i < rows - 3 ; i++) {
            if (maze.maze[i][column - 2] == 0){
                if (rd.nextBoolean()) { maze.maze[i][column-1] = 0;}
            }
        }

        for (int i = 0; i < column - 3 ; i++) {
            if (maze.maze[1][i] == 0 && maze.maze[0][i] == 1){ //fixing the most up
                if (rd.nextBoolean()) { maze.maze[0][i] = 0;}
            }

            if (maze.maze[rows - 2][i] == 0 && maze.maze[rows -1][i] == 1){ //fixing the most bottom
                if (rd.nextBoolean()) { maze.maze[rows -1][i] = 0;}
            }
        }

        if (makeStartAndEnd) {

            LinkedList<Integer> startPositions = new LinkedList<>();
            for (int i = 0; i < column - 1; i++) {
                if (maze.maze[1][i] == 0) {
                    startPositions.addLast(i);
                }
            }

            LinkedList<Integer> endPositions = new LinkedList<>();
            for (int i = 0; i < rows - 1; i++) {
                if (maze.maze[rows - 2][i] == 0) {
                    endPositions.addLast(i);
                }
            }

            int endPos = random.nextInt(endPositions.size());
            endPos = endPositions.get(endPos);
            maze.maze[rows - 1][endPos] = 0;
            maze.setEndPosition(rows - 1, endPos);

            int startPos = random.nextInt(startPositions.size());
            startPos = startPositions.get(startPos);
            maze.maze[0][startPos] = 0;
            maze.setStartPosition(0, startPos);

        }

        return maze;
    }
}
