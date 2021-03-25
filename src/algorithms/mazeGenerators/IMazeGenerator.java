package algorithms.mazeGenerators;


public interface IMazeGenerator {
    Maze generate(int rows, int column);
    long measureAlgorithmTimeMillis(int column, int row);


}
