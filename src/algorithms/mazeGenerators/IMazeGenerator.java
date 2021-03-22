package algorithms.mazeGenerators;


public interface IMazeGenerator {
    Maze generate(int column, int row);
    long measureAlgorithmTimeMillis(int column, int row);


}
