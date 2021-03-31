package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D {

    public abstract long measureAlgorithmTimeMillis(int depth, int row, int column);
}
