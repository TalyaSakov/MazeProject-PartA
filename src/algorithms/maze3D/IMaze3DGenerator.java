package algorithms.maze3D;

public interface IMaze3DGenerator {

    /**
     * Generate 3D - maze
     * @param depth - Maze's depth
     * @param row - Maze's row
     * @param column - Maze's column
     * @return - 3D maze instance.
     */
    public Maze3D generate(int depth, int row, int column);

    /**
     * Measuring the algorithm process time in milliseconds.
     * @param depth - Maze's depth
     * @param row - Maze's row
     * @param column - Maze's column
     * @return - the amount of time as long
     */
    public long measureAlgorithmTimeMillis(int depth, int row, int column);

}
