package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int column) {
//        int NewColumn = column -2;
//        int NewRows = rows -1;
        Maze maze =  new Maze(rows,column);
//        maze.maze[0][0] = 0;
//        maze.maze[NewRows-1][NewColumn-1] = 0;
        final LinkedList<int[]> frontiers = new LinkedList<>();
        final Random random = new Random();

        int x= ((rows/2));
        int y= (0);
//        int x = 0 ; //rows
//        int y = column / 2; //column
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

//        Maze newMaze = new Maze(rows, column);
//        for( int i=0; i < rows-2;i++) {
//            for (int j = 0; j < column -2; j++) {
//                newMaze.maze[i+1][j+1] = maze.maze[i][j];
//            }
//        }

        LinkedList<Integer> startPositions = new LinkedList<>();
        for (int i = 0; i < column - 1 ; i++) {
            if (maze.maze[1][i] == 0){
                startPositions.addLast(i);
            }
        }

        LinkedList<Integer> endPositions = new LinkedList<>();
        for (int i = 0; i < rows - 1 ; i++) {
            if (maze.maze[i][column - 2] == 0){
                endPositions.addLast(i);
            }
        }

        int endPos = random.nextInt(endPositions.size());
        endPos = endPositions.get(endPos);
        maze.maze[endPos][column - 1] = 0;
        maze.setEndPosition(endPos,rows -1);

        int startPos = random.nextInt(startPositions.size());
        startPos = startPositions.get(startPos);
        maze.maze[0][startPos] = 0;
        maze.setStartPosition(0,startPos);


        return maze;
    }
}
