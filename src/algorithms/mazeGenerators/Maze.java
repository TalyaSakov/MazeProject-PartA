package algorithms.mazeGenerators;

import algorithms.search.AState;
import algorithms.search.MazeState;
import algorithms.search.Solution;

import java.util.Arrays;
import java.util.List;

public class Maze {
    int[][] maze;
    int rows;
    int column;
    Position end_position;
    Position start_position;

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getMaze() {
        return maze;
    }


    public String toString() {
        //display the maze as a string based on the values ​​in it
        final char PASSAGE_CHAR = '0';
        final char WALL_CHAR = '1';
        final char START_CHAR = 'S';
        final char END_CHAR = 'E';
        final StringBuffer b = new StringBuffer();
        //running over the matrix values ​,
        // we will mark a wall and a passage as 1 and 0 respectively.
        // In addition we will identify the start and goal positions and mark them accordingly

        for (int x = 0; x < rows; x++) {
            b.append("{ ");
                for (int y = 0; y < column; y++) {
                    //checking if it's a start position
                    if (x == start_position.row && y == start_position.column){
                        b.append(START_CHAR);
                        b.append(' ');}
                    //checking if it's a goal position
                    else if (x == end_position.row && y == end_position.column){
                        b.append(END_CHAR);
                        b.append(' ');}
                    //checking if it's a wall or passage
                    else{
                        b.append(maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
                        b.append(' ');}
                }
//            b.append( WALL_CHAR );
                b.append("}");
                b.append('\n');
            }
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );


            b.append('\n');
            return b.toString();
        }


    public Maze(int rows, int column) {
        //constructor - build the maze with walls only, start and goal positions
        this.rows = rows;
        this.column = column;
        this.end_position = new Position(0, 0);
        maze = new int[rows][column];
        int i, j;
        for (i = 0; i < this.column; i++) {
            for (j = 0; j < this.rows; j++) {
                maze[j][i] = 1;
            }
        }
    }

    public void print() {
        System.out.println(this);
    }

    public void setStartPosition(int row, int column) {
        start_position = new Position(row, column);
    }

    public void setEndPosition(int row, int column) {
        end_position = new Position(row, column);
    }

    public Position getEndPosition() {
        return end_position;

    }


    public Position getStartPosition() {
        return start_position;

    }
}


