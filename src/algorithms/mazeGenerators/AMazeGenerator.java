package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {
    @Override
    public long measureAlgorithmTimeMillis(int column, int row) {
        long start = System.currentTimeMillis();
        generate(column,row);
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
