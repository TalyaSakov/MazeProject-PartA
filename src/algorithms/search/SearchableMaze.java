package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchableMaze implements ISearchable {
    private Maze maze;
    private LinkedList<MazeState> m_states;
    String searchingAlgorithm;

    public SearchableMaze(Maze maze){
        this.maze = maze;
    }

    public AState getStart(){
        Position startPosition = maze.getStartPosition();
        return (new MazeState(startPosition.getRowIndex(),startPosition.getColumnIndex()));
    }

    @Override
    public AState getEnd() {
        Position endPosition = maze.getEndPosition();
        return (new MazeState(endPosition.getRowIndex(),endPosition.getColumnIndex()));
    }


    public List<AState> getAllPossibleStates(AState curr_state,String searchingAlgorithm){
        this.searchingAlgorithm = searchingAlgorithm;
        return getAllPossibleStates(curr_state);
    }

    public List<AState> getAllPossibleStates(AState curr_state){
        if (!(curr_state instanceof MazeState)){
            return null;
        }
        MazeState curr_state_maze = (MazeState)curr_state;
        List<AState> Possible_states = new ArrayList<>();
        //Map all the positions around the current state


        //Diagonals
        //UpRight
        if (this.searchingAlgorithm == "BestFS"){
            if (curr_state_maze.getRow() >= 1){
                if (Diagonal_Verification("goUpRight",curr_state_maze,new MazeState(curr_state_maze.getRow() -1,curr_state_maze.getColumn()))){
                    Position goUpRight = new Position(curr_state_maze.getRow() - 1, curr_state_maze.getColumn() + 1);
                    Possible_states.add(new MazeState(goUpRight.getRowIndex(),goUpRight.getColumnIndex(),5));
                }
                if (Diagonal_Verification("goUpLeft",curr_state_maze,new MazeState(curr_state_maze.getRow() -1,curr_state_maze.getColumn()))){
                    Position goUpLeft = new Position(curr_state_maze.getRow() - 1 , curr_state_maze.getColumn() -1 );
                    Possible_states.add(new MazeState(goUpLeft.getRowIndex(),goUpLeft.getColumnIndex(),5));
                }

            }
            if (curr_state_maze.getRow() < maze.getRows() - 1 ) {
                if (Diagonal_Verification("goDownRight",curr_state_maze,new MazeState(curr_state_maze.getRow() +1,curr_state_maze.getColumn()))){
                    Position goDownRight = new Position(curr_state_maze.getRow() + 1, curr_state_maze.getColumn() + 1);
                    Possible_states.add(new MazeState(goDownRight.getRowIndex(),goDownRight.getColumnIndex(),5));
                }
                if (Diagonal_Verification("goDownLeft",curr_state_maze,new MazeState(curr_state_maze.getRow() +1,curr_state_maze.getColumn()))){
                    Position goDownLeft = new Position(curr_state_maze.getRow() + 1, curr_state_maze.getColumn() -1);
                    Possible_states.add(new MazeState(goDownLeft.getRowIndex(),goDownLeft.getColumnIndex(),5));
                }
            }
        }


        //Not diagonals
        if (Non_Diagonal_Verification("goDown",curr_state_maze)){
            Position goDown = new Position(curr_state_maze.getRow() + 1, curr_state_maze.getColumn());
            Possible_states.add(new MazeState(goDown.getRowIndex(),goDown.getColumnIndex(),10));
        }
        if (Non_Diagonal_Verification("goUp",curr_state_maze)) {
            Position goUp = new Position(curr_state_maze.getRow() -1, curr_state_maze.getColumn());
            Possible_states.add(new MazeState(goUp.getRowIndex(),goUp.getColumnIndex(),10));
        }
        if (Non_Diagonal_Verification("goLeft",curr_state_maze)){
            Position goLeft = new Position(curr_state_maze.getRow(), curr_state_maze.getColumn() -1);
            Possible_states.add(new MazeState(goLeft.getRowIndex(),goLeft.getColumnIndex(),10));
        }
        if (Non_Diagonal_Verification("goRight",curr_state_maze)){
            Position goRight = new Position(curr_state_maze.getRow(), curr_state_maze.getColumn() + 1);
            Possible_states.add(new MazeState(goRight.getRowIndex(),goRight.getColumnIndex(),10));
        }
//        System.out.println(maze.toString(Possible_states));
    return Possible_states;
    }

    public boolean Diagonal_Verification(String str,MazeState curr_state_maze,MazeState next_curr_state){return switch (str) {
        case "goUpRight" -> Non_Diagonal_Verification("goUp",curr_state_maze) && Non_Diagonal_Verification("goRight",next_curr_state);
        case "goUpLeft" -> Non_Diagonal_Verification("goUp",curr_state_maze) && Non_Diagonal_Verification("goLeft",next_curr_state);
        case "goDownRight" -> Non_Diagonal_Verification("goDown",curr_state_maze) && Non_Diagonal_Verification("goRight",next_curr_state);
        case "goDownLeft" -> Non_Diagonal_Verification("goDown",curr_state_maze) && Non_Diagonal_Verification("goLeft",next_curr_state);
        default -> false;
    };}


    public boolean Non_Diagonal_Verification(String str,MazeState curr_state_maze){
        return switch (str) {
            case "goUp" -> (curr_state_maze.getRow() >= 1 && this.maze.getMaze()[curr_state_maze.getRow() - 1][curr_state_maze.getColumn()] == 0);
            case "goDown" -> (curr_state_maze.getRow() < maze.getRows() - 1 && this.maze.getMaze()[curr_state_maze.getRow() + 1][curr_state_maze.getColumn()] == 0);
            case "goLeft" -> (curr_state_maze.getColumn() >= 1 && this.maze.getMaze()[curr_state_maze.getRow()][curr_state_maze.getColumn() - 1] == 0);
            case "goRight" -> (curr_state_maze.getColumn() < maze.getColumn() - 1 && this.maze.getMaze()[curr_state_maze.getRow()][curr_state_maze.getColumn() + 1] == 0);
            default -> false;
        };
    }
}
