package Server;
import IO.MyCompressorOutputStream;
import IO.SimpleCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;
import java.util.ArrayList;


public class ServerStrategyGenerateMaze implements IServerStrategy {

    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {

        try{
            ObjectInputStream FromClient=new ObjectInputStream(inFromClient );
            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);
            System.out.println("Apply strategy Server begin");
            int[] mazeSize=(int[])FromClient.readObject();

            Maze my_maze= new MyMazeGenerator().generate(mazeSize[0],mazeSize[1]);
            toClient.flush();
            ByteArrayOutputStream out=new ByteArrayOutputStream();//a byte array in the memory we will write the array to

            MyCompressorOutputStream output=new MyCompressorOutputStream(out); //creat a new object output that would get out as an input and will writ to it
            output.write(my_maze.toByteArray());  //write to the stream(out) the byte maze and then it would compress it
            System.out.println(my_maze.toString());
            toClient.writeObject(out.toByteArray());//now out object holdes the compressed maze , so we would read it into client

            toClient.flush();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

