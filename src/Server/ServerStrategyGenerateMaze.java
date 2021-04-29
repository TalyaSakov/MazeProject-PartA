package Server;
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
            SimpleCompressorOutputStream output=new SimpleCompressorOutputStream(out);
            output.write(my_maze.toByteArray());  //write to the stream the byte maze and then it would compress it
            toClient.writeObject(out.toByteArray());
            toClient.flush();



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }}


