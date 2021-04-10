package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {
    /**
     *
     * @param column
     * @param row
     * @return time measure of the algorithm
     */
    @Override
    public long measureAlgorithmTimeMillis(int column, int row) {
        long start = System.currentTimeMillis();
        generate(column,row);
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
