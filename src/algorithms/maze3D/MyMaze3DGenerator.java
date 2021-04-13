package algorithms.maze3D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator {
    @Override
    /**
     * Genrate maze3D instance.
     */
    public Maze3D generate(int depth, int rows, int column) {
        //values under 2X2 do not allow us to build a proper maze- exception will be throw
        if (rows < 2 || column < 2 || depth < 1){throw new RuntimeException("Maze must be greater then 1X2X2");}
        Maze3D maze3D = new Maze3D(depth, rows, column);
        for (int i = 0; i < depth; i++) {
            generateLayer(rows,column,maze3D.map[i]);
            if (i > 1 && (!verifyLayer(maze3D.map[i-1],maze3D.map[i],rows,column))){i = i-1;} //verify that there's a path between the two layers
        }
        generateStartAndFinish(maze3D); // generate maze3D's start and finish.
        return maze3D;
    }


    /**
     * verify that there's a path between the two layers
     * @param upperLayer upper-layer.
     * @param currentLayer current layer.
     * @param rows amount of rows in each layer.
     * @param column amount of columns in each layer.
     * @return if there is at least one path between the two layers.
     */
    private boolean verifyLayer(int[][] upperLayer, int[][] currentLayer,int rows, int column) {
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < column - 1; j++) {
                if (upperLayer[i][j] == 0 && currentLayer[i][j] ==0) {return true;}
            }
        }
        return false;
    }

    /**
     * Generate one layer.
     * @param rows - amount of rows in each layer.
     * @param column mount of columns in each layer.
     * @param layer - the layer itself.
     */
    private void generateLayer(int rows, int column, int[][] layer) {
        final ArrayList<int[]> primFronts = new ArrayList<>();
        final Random random = new Random();
        int x = ((rows / 2)); //The algorithm start from ((rows/2),0) position.
        int y = (0);
        primFronts.add(new int[]{x, y, x, y});
        while (!primFronts.isEmpty()) {
            final int[] f = primFronts.remove(random.nextInt(primFronts.size())); // Randomly choose a position on the maze from the list.
            x = f[2];
            y = f[3];
            if (layer[x][y] == 1) {
                /**
                 * if layer[x][y] == 1 -> it turns 0 and the algorithm adds new potential 1's positions around it to the list.
                 */
                layer[f[0]][f[1]] = layer[x][y] = 0;
                if (x >= 2 && layer[x - 2][y] == 1)
                    primFronts.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && layer[x][y - 2] == 1)
                    primFronts.add(new int[]{x, y - 1, x, y - 2});
                if (x < rows - 2 && layer[x + 2][y] == 1)
                    primFronts.add(new int[]{x + 1, y, x + 2, y});
                if (y < column - 2 && layer[x][y + 2] == 1)
                    primFronts.add(new int[]{x, y + 1, x, y + 2});
            }
        }
        arrangeBorders(rows,column,layer); //Arrange borders for each layer.
    }


    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        return 0;
    }

    /**
     * Function that decide about a potential maze's start\end.
     * @param maze3D
     * @param where
     * @return
     */
    private int lookForOptinalStartorEnd(Maze3D maze3D,String where) {
        LinkedList<Integer> positions = new LinkedList<>();
        Random rd = new Random();
        /**
         * Choosing the start position.
         */
        if (where.equals("Start")){
            for (int i = 0; i < maze3D.getColumn_maze3D() - 1; i++) {
                if (maze3D.map[0][0][i] == 0) {
                    positions.add(i);
                }
            }
            int pos = rd.nextInt(positions.size());
            return positions.get(pos);
        }
        /**
         * Choosing the end position.
         */
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

    /**
     * Generate Maze3D start and end.
     * @param maze3D - maze3D instance.
     */
    public void generateStartAndFinish (Maze3D maze3D){
        maze3D.setStartPosition(0, 0, lookForOptinalStartorEnd(maze3D,"Start"));
        maze3D.setGoalPositionPosition(maze3D.getDepth_maze3D() - 1, maze3D.getRow_maze3D() - 1, lookForOptinalStartorEnd(maze3D,"End"));
    }

    /**
     * a function that verify and arrange a fair - played maze's borders for each layer.
     * @param rows - amount of rows in each layer.
     * @param column mount of columns in each layer.
     * @param layer - the layer itself.
     */
    private void arrangeBorders(int rows,int column, int[][] layer){
        Random rd = new Random();
        arrangeRight(rows,column,layer,rd);
        arrangeUpAndButton( rows,column,layer,rd);
    }

    /**
     * arrage the up and button border for the layer.
     * @param rd - random instance.
     */
    private void arrangeUpAndButton(int rows, int column, int[][] layer, Random rd) {
        /**
         * Verification booleans to make sure that there's a position with zeros for the Start and End.
         */
        boolean upper_verification_bool = false;
        boolean button_verification_bool = false;
        int upper_verification_index = 0;
        int button_verification_index = 0;

        /**
         * Choosing positions on the most up border to be zeros. - Randomly.
         */
        for (int i = 0; i < column - 1; i++) {
            if (layer[1][i] == 0 && layer[0][i] == 1) {
                upper_verification_index = i;
                if (rd.nextBoolean()) {
                    layer[0][i] = 0;
                    upper_verification_bool = true;
                }
            }
            /**
             * Choosing positions on the most button border to be zeros - Randomly.
             */
            if (layer[rows - 2][i] == 0 && layer[rows - 1][i] == 1) {
                button_verification_index = i;
                if (rd.nextBoolean()) {
                    layer[rows - 1][i] = 0;
                    button_verification_bool = true;
                }
            }
        }
        if (!button_verification_bool) {
            layer[rows - 1][button_verification_index] = 0; }
        if (!upper_verification_bool) {
            layer[0][upper_verification_index] = 0; }
    }

    /**
     * Choosing positions on the most right border to be zeros.
     */
    private void arrangeRight(int rows, int column, int[][] layer, Random rd) {
        for (int i = 0; i < rows - 1; i++) {
            if (layer[i][column - 2] == 0) {
                if (rd.nextBoolean()) {
                    layer[i][column - 1] = 0;
                }
            }
        }
    }
}