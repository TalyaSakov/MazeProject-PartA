package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int row, int column) {
        if (row < 2 || column < 2){throw new RuntimeException("Maze must be greater then 2X2");} //values under 2X2 do not allow us to build a proper maze
        return new Maze(column,row);

    }
}
