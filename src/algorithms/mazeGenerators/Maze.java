package algorithms.mazeGenerators;
/**
 * Maze class contains 5 fields - maze, row, column, end_position and start_position .
 */
public class Maze {
    int[][] maze;
    int rows;
    int column;
    Position end_position;
    Position start_position;

    /**
     * @return the maze's row amount.
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return the maze's column amount.
     */
    public int getColumn() {
        return column;
    }

    /**
     * @return the maze's maze field.
     */
    public int[][] getMaze() {
        return maze;
    }

    /**
     * display the maze as a string based on the values ​​in it.
     * we will run on the maze cells. Cells with a value of 1 will be defined as walls and mark with char 1, otherwise they will mark as passage with char 0
     * start position and end position would mark as S and E respectively
     */
    public String toString() {
        //
        final char PASSAGE_CHAR = '0';
        final char WALL_CHAR = '1';
        final char START_CHAR = 'S';
        final char END_CHAR = 'E';
        final StringBuffer b = new StringBuffer();

        for (int x = 0; x < rows; x++) {
            b.append("{ ");
            for (int y = 0; y < column; y++) {

                if (x == start_position.row && y == start_position.column) {
                    b.append(START_CHAR);
                    b.append(' ');
                }
                //checking if it's a goal position
                else if (x == end_position.row && y == end_position.column) {
                    b.append(END_CHAR);
                    b.append(' ');
                }
                //checking if it's a wall or passage
                else {
                    b.append(maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
                    b.append(' ');
                }
            }
            b.append("}");
            b.append('\n');
        }
            b.append('\n');
            return b.toString();
        }

    /**
     * constructor - build new maze from a given size
     * initializing the maze fields as full of 1's.
     * @param rows
     * @param column
     */
    public Maze(int rows, int column) {
        //constructor - build the maze with walls only, start and goal positions
        this.rows = rows;
        this.column = column;
        this.start_position = new Position(rows-1,column -1);
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


    /**
     * Make a new Position instance and make it as the startPosition field.
     * @param row - Start position row.
     * @param column - Start position column.
     */
    public void setStartPosition(int row, int column) {
        start_position = new Position(row, column);
    }

    /**
     * Make a new Position instance and make it as the endPosition field.
     * @param row - Start position row.
     * @param column - Start position column.
     */
    public void setEndPosition(int row, int column) {
        end_position = new Position(row, column);
    }

    /**
     * @return the maze's end Position .
     */
    public Position getGoalPosition() {
        return end_position;

    }

    /**
     * @return the maze's start Position.
     */
    public Position getStartPosition() {
        return start_position;

    }
}


