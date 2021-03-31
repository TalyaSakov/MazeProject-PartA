package algorithms.maze3D;

import algorithms.mazeGenerators.MyMazeGenerator;

public class MyMaze3DGenerator extends AMaze3DGenerator {
    @Override
    public Maze3D generate(int depth, int row, int column) {
        Maze3D maze3D = new Maze3D(depth, row, column);
        MyMazeGenerator mazeGenerator = new MyMazeGenerator();
        for (int i = 0; i < depth; i++) {
            maze3D.map[i] = mazeGenerator.generate(row, column, false).getMaze();
        }
        generateStartAndFinish(maze3D);
        return maze3D;
    }

    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        return 0;
    }

    private int lookForOptinalStartorEnd(Maze3D maze3D,String where) {
        if (where.equals("Start")){
            for (int i = 0; i < maze3D.getColumn_maze3D() - 1; i++) {
                if (maze3D.map[0][0][i] == 0) {
                    return i;
                }
            }
        }
        else if (where.equals("End")){
            for (int i = 0; i < maze3D.getColumn_maze3D() - 1; i++) {

                if (maze3D.map[maze3D.getDepth_maze3D() - 1][0][i] == 0) {

                    return i;
                }
            }
        }
         return 0; // can't happen
    }
        public void generateStartAndFinish (Maze3D maze3D){
            maze3D.setStartPosition(0, 0, lookForOptinalStartorEnd(maze3D,"Start"));
            maze3D.setGoalPositionPosition(maze3D.getDepth_maze3D() - 1, maze3D.getRow_maze3D() - 1, lookForOptinalStartorEnd(maze3D,"End"));
        }
    }

