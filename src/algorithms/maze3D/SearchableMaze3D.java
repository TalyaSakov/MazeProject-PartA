package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.ISearchable;
import algorithms.search.MazeState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchableMaze3D implements ISearchable {
        private Maze3D maze3D;
        String searchingAlgorithm;

        public SearchableMaze3D(Maze3D maze3D){
            this.maze3D = maze3D;
        }

        public Maze3DState getStart(){
            Position3D startPosition = maze3D.getStartPosition();
            return (new Maze3DState(startPosition.getDepthIndex(),startPosition.getRowIndex(),startPosition.getColumnIndex()));
        }

        @Override
        public AState getEnd() {
            Position3D goalPosition = maze3D.getGoalPosition();
            return (new Maze3DState(goalPosition.getDepthIndex(),goalPosition.getRowIndex(),goalPosition.getColumnIndex()));
        }


        public List<AState> getAllPossibleStates(AState curr_state,String searchingAlgorithm){
            this.searchingAlgorithm = searchingAlgorithm;
            return getAllPossibleStates(curr_state);
        }

        public List<AState> getAllPossibleStates(AState curr_state) {
            if (!(curr_state instanceof Maze3DState)) {
                return null;
            }
            Maze3DState curr_state_maze = (Maze3DState) curr_state;
            List<AState> Possible_states = new ArrayList<>();//Map all the positions around the current state


            //Not diagonals
            if (Non_Diagonal_Verification("goDown", curr_state_maze)) {
                Position3D goDown = new Position3D(curr_state_maze.getDepth(), curr_state_maze.getRow() + 1, curr_state_maze.getColumn());
                Possible_states.add(new Maze3DState(goDown.getDepthIndex(), goDown.getRowIndex(), goDown.getColumnIndex()));
            }
            if (Non_Diagonal_Verification("goUp", curr_state_maze)) {
                Position3D goUp = new Position3D(curr_state_maze.getDepth(), curr_state_maze.getRow() - 1, curr_state_maze.getColumn());
                Possible_states.add(new Maze3DState(goUp.getDepthIndex(), goUp.getRowIndex(), goUp.getColumnIndex()));
            }
            if (Non_Diagonal_Verification("goLeft", curr_state_maze)) {
                Position3D goLeft = new Position3D(curr_state_maze.getDepth(), curr_state_maze.getRow(), curr_state_maze.getColumn() - 1);
                Possible_states.add(new Maze3DState(goLeft.getDepthIndex(), goLeft.getRowIndex(), goLeft.getColumnIndex()));
            }
            if (Non_Diagonal_Verification("goRight", curr_state_maze)) {
                Position3D goRight = new Position3D(curr_state_maze.getDepth(), curr_state_maze.getRow(), curr_state_maze.getColumn() + 1);
                Possible_states.add(new Maze3DState(goRight.getDepthIndex(), goRight.getRowIndex(), goRight.getColumnIndex()));
            }

            //floors
            if (floors_Verification("goUpstairs",curr_state_maze)){
                Position3D goUpstairs = new Position3D(curr_state_maze.getDepth()+1,curr_state_maze.getRow(), curr_state_maze.getColumn());
                Possible_states.add(new Maze3DState(goUpstairs.getDepthIndex(),goUpstairs.getRowIndex(),goUpstairs.getColumnIndex()));
            }
            if (floors_Verification("goDownstairs",curr_state_maze)) {
                Position3D goDownstairs = new Position3D(curr_state_maze.getDepth()-1,curr_state_maze.getRow(), curr_state_maze.getColumn());
                Possible_states.add(new Maze3DState(goDownstairs.getDepthIndex(),goDownstairs.getRowIndex(),goDownstairs.getColumnIndex()));
            }

            Collections.shuffle(Possible_states);
            return Possible_states;

        }



        public boolean Non_Diagonal_Verification(String str,Maze3DState curr_state_maze){
            return switch (str) {
                case "goUp" -> (curr_state_maze.getRow() >= 1 && this.maze3D.getMaze3D()[curr_state_maze.getDepth()][curr_state_maze.getRow()-1][curr_state_maze.getColumn()] == 0);
                case "goDown" -> (curr_state_maze.getRow() < maze3D.getRow_maze3D() - 1 && this.maze3D.getMaze3D()[curr_state_maze.getDepth()][curr_state_maze.getRow()+1][curr_state_maze.getColumn()] == 0);
                case "goLeft" -> (curr_state_maze.getColumn() >= 1 && this.maze3D.getMaze3D()[curr_state_maze.getDepth()][curr_state_maze.getRow()][curr_state_maze.getColumn()-1] == 0);
                case "goRight" -> (curr_state_maze.getColumn() < maze3D.getColumn_maze3D() - 1 && this.maze3D.getMaze3D()[curr_state_maze.getDepth()][curr_state_maze.getRow()][curr_state_maze.getColumn()+1] == 0);
                default -> false;
            };
        }
        public boolean floors_Verification(String str,Maze3DState curr_state_maze){
            return switch (str) {
                case "goUpstairs" -> (curr_state_maze.getDepth() < this.maze3D.getDepth_maze3D()-1 && this.maze3D.getMaze3D()[curr_state_maze.getDepth()+1][curr_state_maze.getRow()][curr_state_maze.getColumn()] == 0);
                case "goDownstairs" -> (curr_state_maze.getDepth() > 0 && this.maze3D.getDepth_maze3D()>0 && this.maze3D.getMaze3D()[curr_state_maze.getDepth()-1][curr_state_maze.getRow()][curr_state_maze.getColumn()] == 0);
            default -> false;
        };}
    }

