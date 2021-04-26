package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMaze3DGenerator {

    /**
     * Measuring the algorithm process time in milliseconds.
     * @param depth - Maze's depth
     * @param row - Maze's row
     * @param column - Maze's column
     * @return - the amount of time as long
     */
    public abstract long measureAlgorithmTimeMillis(int depth, int row, int column);
}
