package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    private final Position current_position;

    public MazeState(int row, int column){
        super(row,column);
        this.current_position = new Position(row,column);
        //????//
    }

    @Override
    public void setParent(AState father) {
        this.parent = father;}

    @Override

    public AState getParent() {
        return parent;
    }

    @Override
    public void setParentNull() {
        this.parent = null;
    }

}
