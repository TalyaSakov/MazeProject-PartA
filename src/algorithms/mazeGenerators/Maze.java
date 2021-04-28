package algorithms.mazeGenerators;

import java.util.ArrayList;

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


    public Maze(byte[] bytes) {
        int [] fieldsValue= new int[6];
        String temp="";
        int currField=0;
        int index=0;
        int i;
        for (i=0; i<bytes.length; i++){
            if (currField==6){
                break;
            }
            else {
                for(int j=0;j<10;j++){
                    temp +=bytes[index];
                    index++;
                }

                fieldsValue[currField] = Integer.parseInt(temp, 2); //convert binary string to a decimal int value
                currField++; //continue to the next field
                temp = ""; //init temp
            }
        }
        this.rows=fieldsValue[0];
        this.column=fieldsValue[1];
        setStartPosition(fieldsValue[2],fieldsValue[3]);
        setEndPosition(fieldsValue[4],fieldsValue[5]);

        this.maze = new int[rows][column];
        byteToMatrix(index,bytes);


    }


    public byte[] toByteArray(){
        ArrayList<String> stringList = new ArrayList<>();
       extracted(stringList);
        byte[] bytes = new byte[rows*column + 60];
        int index=0;

        for (String s : stringList) { //running over all 6 field
            for (int i=0;i<10;i++){ //running over each 10 bit field
                bytes[index]= (byte) Character.getNumericValue(s.charAt(i));
                index++;
            }
        }
        matrixToByte(index, bytes);
        return bytes;
    }

    private void matrixToByte(int index, byte[] bytes) {
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < column - 1; j++) {
                bytes[index] = (byte) maze[i][j];
                index++;
            }
        }
    }

    private void byteToMatrix(int index, byte[] bytes) {
        for (int k = 0; k < rows - 1; k++) {
            for (int j = 0; j < column - 1; j++) {
                int tempByte =  bytes[index];
                this.maze[k][j]=tempByte;
                index++;
            }
        }
    }

    private void extracted(ArrayList<String> stringList) {
        stringList.add(to10bit(rows));
        stringList.add(to10bit(column));
        stringList.add(to10bit(start_position.getRowIndex()));
        stringList.add(to10bit(start_position.getColumnIndex()));
        stringList.add(to10bit(end_position.getRowIndex()));
        stringList.add(to10bit(end_position.getColumnIndex()));
    }

    /*
    get a intger value of field, convert it to binary base
    and add zero until we get to lenght of 10 chars
     */
    private String to10bit(int val){
        String str=Integer.toBinaryString(val);
        String temp="";
        int num= 10-str.length();
        for (int i=0;i<num;i++){
            temp+="0";
        }
        temp+=str;

        return temp;
    }

    private int addMazeVariables(String stringInBinary, int index, byte[] bytes) {
        for (int i = 0; i < 10; i++) {
            bytes[index]= (byte) Character.getNumericValue(stringInBinary.charAt(i));
            index++;
        }
        bytes[index] = -1;

        index ++;
        return index;
    }

    /**
     * @return the maze's start Position.
     */
    public Position getStartPosition() {
        return start_position;

    }






}

