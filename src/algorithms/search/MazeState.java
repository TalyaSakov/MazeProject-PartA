package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    private final Position current_position;

    public MazeState(int row, int column){
        super();
        this.current_position = new Position(row,column);
        this.row = row;
        this.column = column;
        //????//
    }

}
