package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    /**
     * Measuring the time of the algorithm
     *@param row - Maze's row
     * @param column - Maze's column
     * @return - long for the amount of time
     */
    @Override
    public long measureAlgorithmTimeMillis(int column, int row) {
        long start = System.currentTimeMillis();
        generate(column,row);
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
