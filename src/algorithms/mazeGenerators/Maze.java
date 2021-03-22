package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {
    int [][] maze;
    int rows;
    int column;





//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        for(int x=0; x< column ; x++){
//            for(int y=0; y<rows; y++)
//                sb.append(maze[x][y]);
//            sb.append("\n");
//        }
//        return sb.toString();}
    public String toString(){
        final char PASSAGE_CHAR = ' ';
        final char WALL_CHAR = '▓';
        final StringBuffer b = new StringBuffer();
        for ( int x = 0; x < column + 2; x++ )
            b.append( WALL_CHAR );
        b.append( '\n' );
        for ( int y = 0; y < rows; y++ ){
            b.append( WALL_CHAR );
            for ( int x = 0; x < column; x++ )
                b.append( maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR );
            b.append( WALL_CHAR );
            b.append( '\n' );
        }
        for ( int x = 0; x < column + 2; x++ )
            b.append( WALL_CHAR );
        b.append( '\n' );
        return b.toString();
    }


    public Maze(int column, int rows) {
        this.rows = rows;
        this.column = column;
        maze = new int[column][rows];
        int i,j;
        for  (i=0;i<this.column;i++){
            for (j=0;j<this.rows;j++){
                maze[i][j]=1;
            }
}
    }}
