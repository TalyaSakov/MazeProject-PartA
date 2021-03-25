package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchableMaze implements ISearchable {
    private Maze maze;
    private LinkedList<MazeState> m_states;

    public SearchableMaze(Maze maze){
        this.maze = maze;
    }

    public AState getStart(){
        Position startPosition = maze.getStartPosition();
        return (new MazeState(startPosition.getRowIndex(),startPosition.getColumnIndex()));
    }

    @Override
    public AState getEnd() {
        Position endPosition = maze.getGoalPosition();
        return (new MazeState(endPosition.getRowIndex(),endPosition.getColumnIndex()));
    }

    public List<AState> PossibleStates(AState curr_state){
        List<AState> Possible_states = new ArrayList<>();

        //Map all the positions around the current state

        //Diagonals

        //UpRight
        if (curr_state.getRow() >= 1){
            if (curr_state.getColumn() < maze.getColumn() && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn() + 1] == 0){
                Position goUpRight = new Position(curr_state.getRow() - 1, curr_state.getColumn() + 1);
                Possible_states.add(new MazeState(goUpRight.getRowIndex(),goUpRight.getColumnIndex()));
            }
            if (curr_state.getColumn() >= 1 && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn() - 1] == 0){
                Position goUpLeft = new Position(curr_state.getRow() - 1 , curr_state.getColumn() -1 );
                Possible_states.add(new MazeState(goUpLeft.getRowIndex(),goUpLeft.getColumnIndex()));
            }

        }
        if (curr_state.getRow() < maze.getRows() - 1 ) {
            if (curr_state.getColumn() < maze.getColumn() - 1 && this.maze.getMaze()[curr_state.getRow() + 1][curr_state.getColumn() + 1] == 0){
                Position goDownRight = new Position(curr_state.getRow() + 1, curr_state.getColumn() + 1);
                Possible_states.add(new MazeState(goDownRight.getRowIndex(),goDownRight.getColumnIndex()));
            }
            if (curr_state.getColumn() >= 1 && this.maze.getMaze()[curr_state.getRow() + 1][curr_state.getColumn() - 1] == 0){
                Position goDownLeft = new Position(curr_state.getRow() + 1, curr_state.getColumn() -1);
                Possible_states.add(new MazeState(goDownLeft.getRowIndex(),goDownLeft.getColumnIndex()));
            }
        }

        //Not diagonals
        if (curr_state.getRow() < maze.getRows() - 1 && this.maze.getMaze()[curr_state.getRow() + 1][curr_state.getColumn()] == 0){
            Position goDown = new Position(curr_state.getRow() + 1, curr_state.getColumn());
            Possible_states.add(new MazeState(goDown.getRowIndex(),goDown.getColumnIndex()));
        }
        if (curr_state.getRow() >= 1 && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn()] == 0) {
            Position goUp = new Position(curr_state.getRow() -1, curr_state.getColumn());
            Possible_states.add(new MazeState(goUp.getRowIndex(),goUp.getColumnIndex()));
        }
        if (curr_state.getColumn() >= 1 && this.maze.getMaze()[curr_state.getRow()][curr_state.getColumn() - 1] == 0){
            Position goLeft = new Position(curr_state.getRow(), curr_state.getColumn() -1);
            Possible_states.add(new MazeState(goLeft.getRowIndex(),goLeft.getColumnIndex()));
        }
        if (curr_state.getColumn() < maze.getColumn() - 1 && this.maze.getMaze()[curr_state.getRow()][curr_state.getColumn() + 1] == 0){
            Position goRight = new Position(curr_state.getRow(), curr_state.getColumn() + 1);
            Possible_states.add(new MazeState(goRight.getRowIndex(),goRight.getColumnIndex()));
        }

    return Possible_states;
    }

}
