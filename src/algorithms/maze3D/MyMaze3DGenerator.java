package algorithms.maze3D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator {
    @Override
    public Maze3D generate(int depth, int rows, int column) {
        //values under 2X2 do not allow us to build a proper maze- exception will be throw
        if (rows < 2 || column < 2 || depth < 1){throw new RuntimeException("Maze must be greater then 1X2X2");}
        Maze3D maze3D = new Maze3D(depth, rows, column);
        for (int i = 0; i < depth; i++) {
            generate2D(rows,column,maze3D.map[i]);
        }
        generateStartAndFinish(maze3D);
        return maze3D;
    }

    private void generate2D(int rows,int column, int[][] layer){
        final ArrayList<int[]> frontiers = new ArrayList<>();
        final Random random = new Random();
        int x= ((rows/2));
        int y= (0);
        frontiers.add(new int[]{x, y, x, y});

        while (!frontiers.isEmpty()) {
            final int[] f = frontiers.remove(random.nextInt(frontiers.size()));
            x = f[2];
            y = f[3];
            if (layer[x][y] == 1) {
                layer[f[0]][f[1]] = layer[x][y] = 0;
                if (x >= 2 && layer[x - 2][y] == 1)
                    frontiers.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && layer[x][y - 2] == 1)
                    frontiers.add(new int[]{x, y - 1, x, y - 2});
                if (x < rows - 2 && layer[x + 2][y] == 1)
                    frontiers.add(new int[]{x + 1 , y, x + 2, y});
                if (y < column - 2 && layer[x][y + 2] == 1)
                    frontiers.add(new int[]{x, y + 1 , x, y + 2});
            }
        }
        Random rd = new Random();
        //fixing the most right
        for (int i = 0; i < rows - 3 ; i++) {
            if (layer[i][column - 2] == 0){
                if (rd.nextBoolean()) { layer[i][column-1] = 0;}
            }
        }

        for (int i = 0; i < column - 3 ; i++) {
            if (layer[1][i] == 0 && layer[0][i] == 1){ //fixing the most up
                if (rd.nextBoolean()) { layer[0][i] = 0;}
            }

            if (layer[rows - 2][i] == 0 && layer[rows -1][i] == 1){ //fixing the most bottom
                if (rd.nextBoolean()) { layer[rows -1][i] = 0;}
            }
        }
    }


    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        return 0;
    }

    private int lookForOptinalStartorEnd(Maze3D maze3D,String where) {
        LinkedList<Integer> positions = new LinkedList<>();
        Random rd = new Random();
        if (where.equals("Start")){
            for (int i = 0; i < maze3D.getColumn_maze3D() - 1; i++) {
                if (maze3D.map[0][0][i] == 0) {
                    positions.add(i);
                }
            }
            int pos = rd.nextInt(positions.size());
            return positions.get(pos);
        }
        else if (where.equals("End")){
            for (int i = 0; i < maze3D.getColumn_maze3D() - 1; i++) {
                if (maze3D.map[maze3D.getDepth_maze3D() - 1][maze3D.getRow_maze3D() - 1][i] == 0) {
                    positions.add(i);
                }
            }
            int pos = rd.nextInt(positions.size());
            return positions.get(pos);
        }
         return 0; // can't happen
    }
        public void generateStartAndFinish (Maze3D maze3D){
            maze3D.setStartPosition(0, 0, lookForOptinalStartorEnd(maze3D,"Start"));
            maze3D.setGoalPositionPosition(maze3D.getDepth_maze3D() - 1, maze3D.getRow_maze3D() - 1, lookForOptinalStartorEnd(maze3D,"End"));
        }
    }

