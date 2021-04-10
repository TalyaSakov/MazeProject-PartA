package algorithms.mazeGenerators;


public interface IMazeGenerator {
    /**
     * Generate a new maze
     * @param rows - Maze's row
     * @param column - Maze's column
     * @return - a new maze .
     */
    Maze generate(int rows, int column);

    /**
     * Measuring the time of the algorithm
     *@param row - Maze's row
     * @param column - Maze's column
     * @return - long for the amount of time
     */
    long measureAlgorithmTimeMillis(int column, int row);


}
