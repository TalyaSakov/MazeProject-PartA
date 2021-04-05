package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {
    @Override
    public long measureAlgorithmTimeMillis(int column, int row) {
        long start = System.currentTimeMillis(); //init start as current time
        generate(column,row); // running the maze generate
        long finish = System.currentTimeMillis(); //init finish as current time
        return finish - start; //sub between the 2 values and return
    }
}
