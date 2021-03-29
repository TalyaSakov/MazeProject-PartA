package algorithms.mazeGenerators;

import algorithms.search.AState;
import algorithms.search.Solution;

import java.util.Arrays;
import java.util.List;

public class Maze {
    int [][] maze;
    int rows;
    int column;
    Position end_position;

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getMaze() {
        return maze;
    }

    //    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        for(int x=0; x< column ; x++){
//            for(int y=0; y<rows; y++)
//                sb.append(maze[x][y]);
//            sb.append("\n");
//        }
//        return sb.toString();}

    public String toString(List<AState> list){
        final char PASSAGE_CHAR = '*';
        final char WALL_CHAR = 'X';
        final char MARKED_CHAR = 'S';
        boolean[][] markedMaze;
        markedMaze = new boolean[this.getRows()][this.getColumn()];
        for (int i = 0; i < list.size(); i++) {
            int col = list.get(i).getColumn();
            int row = list.get(i).getRow();
            markedMaze[row][col] = true;
        }
        final StringBuffer b = new StringBuffer();
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
//        b.append( '\n' );
        for ( int x = 0; x < rows; x++ ){
//            b.append( WALL_CHAR );
            for ( int y = 0; y < column; y++ )
                if (markedMaze[x][y] == true){
                    b.append(MARKED_CHAR); }
            else{
                    b.append( maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR );
                }
//            b.append( WALL_CHAR );
            b.append( '\n' );
        }
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
        b.append( '\n' );
        return b.toString();
    }
    public String toString(){
        final char PASSAGE_CHAR = '*';
        final char WALL_CHAR = 'X';
        final StringBuffer b = new StringBuffer();
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
//        b.append( '\n' );
        for ( int x = 0; x < rows; x++ ){
//            b.append( WALL_CHAR );
            for ( int y = 0; y < column; y++ )
                b.append( maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR );
//            b.append( WALL_CHAR );
            b.append( '\n' );
        }
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
        b.append( '\n' );
        return b.toString();
    }


    public Maze(int rows, int column) {
        this.rows = rows;
        this.column = column;
        this.end_position = new Position(0,0);
        maze = new int[rows][column];
        int i,j;
        for  (i=0;i<this.column;i++){
            for (j=0;j<this.rows;j++){
                maze[j][i]=1;
            }
}
    }

    public void print() {
        System.out.println(this);
    }

    public Position getStartPosition() {
        return new Position(0,1);
    }

    public Position getGoalPosition() {
        return end_position;
    }
}
