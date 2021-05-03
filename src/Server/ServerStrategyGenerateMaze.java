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
            ObjectInputStream FromClient=new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);
            System.out.println("Apply strategy Server begin");
            int[] mazeParam=(int[])FromClient.readObject();
            Maze my_maze= new MyMazeGenerator().generate(mazeParam[0],mazeParam[1]);
            toClient.flush();
            SimpleCompressorOutputStream simpleCompressorOutputStream = new SimpleCompressorOutputStream(new ByteArrayOutputStream());
            simpleCompressorOutputStream.write(my_maze.toByteArray());  //write to the stream the byte maze and then it would compress it
            toClient.writeObject(((ByteArrayOutputStream) simpleCompressorOutputStream.outputStream).toByteArray());
            toClient.flush();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
