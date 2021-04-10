package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    /**
     * constructor - build new maze from a given size
     * @param row -number of row in the new maze
     * @param column- number of column in the new maze
     * @return maze object
     */
    @Override
    public Maze generate(int row, int column) {
        if (row < 2 || column < 2){throw new RuntimeException("Maze must be greater then 2X2");}
        return new Maze(column,row);

    }
}
