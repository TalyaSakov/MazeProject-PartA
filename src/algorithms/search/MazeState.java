package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    private final Position current_position;
    private MazeState parent;

    public MazeState(int row, int column){
        super(row,column);
        this.current_position = new Position(row,column);
        MazeState parent = null;
        //????//
    }

    @Override
    public void setParent(AState father) {
        if (father instanceof MazeState){
        this.parent = (MazeState)father;}
    }


    @Override

    public MazeState getParent() {
        return parent;
    }

    @Override
    public void setParentNull() {
        this.parent = null;
    }

}
