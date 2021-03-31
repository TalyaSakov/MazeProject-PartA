package algorithms.maze3D;

import algorithms.mazeGenerators.MyMazeGenerator;

public class MyMaze3DGenerator extends AMaze3DGenerator {
    @Override
    public Maze3D generate(int depth, int row, int column) {
        Maze3D maze3D = new Maze3D(depth,row,column);
        MyMazeGenerator mazeGenerator = new MyMazeGenerator();
        for (int i = 0; i < depth; i++) {
            maze3D.map[i] = mazeGenerator.generate(row,column).getMaze();
        }
        return maze3D;
    }

    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        return 0;
    }
}
