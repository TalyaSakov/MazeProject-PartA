package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int column, int row) {
        return new Maze(column,row);
    }
}
