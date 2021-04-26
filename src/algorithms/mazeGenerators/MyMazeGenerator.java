package algorithms.mazeGenerators;

import java.util.*;

public class MyMazeGenerator extends AMazeGenerator {

    boolean makeStartAndEnd = true;

    /**
     * Genrate a new maze instance.
     * @param rows - number of row's in the Maze
     * @param column - number of column's in the Maze
     * @param makeStartAndEnd- get true int order to initialized start and end pos'.
     * @return
     */
    public Maze generate(int rows, int column, boolean makeStartAndEnd) {
        this.makeStartAndEnd = makeStartAndEnd;
        return generate(rows, column);
    }
    @Override
    /**
     * Genrate a new maze instance.
     * Based on prime's algorithm-
     * Builds the next passage each time based on the neighbors you can walk through
     * @param rows - number of row's in the Maze
     * @param column - number of column's in the Maze
     */
    public Maze generate(int rows, int column) {
        if (rows < 2 || column < 2){throw new RuntimeException("Maze must be greater then 2X2");}
        Maze maze =  new Maze(rows,column);
        final ArrayList<int[]> primFronts = new ArrayList<>();
        final Random random = new Random();
        int x= ((rows/2));
        int y= (0);
        primFronts.add(new int[]{x, y, x, y});
        /**
         * As long as there are optional neighbors you will keep running
         */
        while (!primFronts.isEmpty()) {
            final int[] f = primFronts.remove(random.nextInt(primFronts.size()));
//            final int[] f = primFronts.pop();
            x = f[2];
            y = f[3];
            if (maze.maze[x][y] == 1) {
                maze.maze[f[0]][f[1]] = maze.maze[x][y] = 0;
                if (x >= 2 && maze.maze[x - 2][y] == 1)
                    primFronts.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && maze.maze[x][y - 2] == 1)
                    primFronts.add(new int[]{x, y - 1, x, y - 2});
                if (x < rows - 2 && maze.maze[x + 2][y] == 1)
                    primFronts.add(new int[]{x + 1 , y, x + 2, y});
                if (y < column - 2 && maze.maze[x][y + 2] == 1)
                    primFronts.add(new int[]{x, y + 1 , x, y + 2});
            }
        }
        arrangeBorders(rows,column,maze);
        initializeStartAndGoal(rows,column,maze);
        return maze;
    }

    private void initializeStartAndGoal(int rows, int column, Maze maze) {
        Random rd = new Random();
        /**
         * Initial start and end positions.
         * Make sure that the path to them is accessible using random.
         */

            LinkedList<Integer> startPositions = new LinkedList<>();
            for (int i = 0; i < column - 1; i++) {
                if (maze.maze[1][i] == 0) {
                    startPositions.addLast(i);
                }
            }

            LinkedList<Integer> endPositions = new LinkedList<>();
            for (int i = 0; i < column - 1; i++) {
                if (maze.maze[rows - 2][i] == 0) {
                    endPositions.addLast(i);
                }
            }

            int endPos = rd.nextInt(endPositions.size());
            endPos = endPositions.get(endPos);
            maze.maze[rows - 1][endPos] = 0;
            maze.setEndPosition(rows - 1, endPos);

            int startPos = rd.nextInt(startPositions.size());
            startPos = startPositions.get(startPos);
            maze.maze[0][startPos] = 0;
            maze.setStartPosition(0, startPos);
    }

    private void arrangeBorders(int rows, int column, Maze maze) {
        Random rd = new Random();
        /**
         * Choosing positions on the most right border to be zeros.
         */

        for (int i = 0; i < rows - 1 ; i++) {
            if (maze.maze[i][column - 2] == 0){
                if (rd.nextBoolean()) { maze.maze[i][column-1] = 0;}
            }
        }
        /**
         * Choosing positions on the most up border to be zeros. - Randomly.
         */
        for (int i = 0; i < column - 1 ; i++) {
            if (maze.maze[1][i] == 0 && maze.maze[0][i] == 1){
                if (rd.nextBoolean()) { maze.maze[0][i] = 0;}
            }

            /**
             * Choosing positions on the most button border to be zeros - Randomly.
             */
            if (maze.maze[rows - 2][i] == 0 && maze.maze[rows -1][i] == 1){
                if (rd.nextBoolean()) { maze.maze[rows -1][i] = 0;}
            }
        }

    }
}
