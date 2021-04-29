package Server;
import IO.SimpleCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;
import java.util.ArrayList;


public class ServerStrategyGenerateMaze implements IServerStrategy {

    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            System.out.println("Apply strategy Server begin");
            int[] mazeParam = (int [])fromClient.readObject();
            Maze maze= new MyMazeGenerator().generate(mazeParam[0],mazeParam[1]);
            byte [] toByte = maze.toByteArray();

//            ByteArrayOutputStream arr = new ByteArrayOutputStream(); //create an input to the stream
            SimpleCompressorOutputStream arrayCompressStream= new SimpleCompressorOutputStream(outToClient); //sent the arr to the compressor
            arrayCompressStream.flush();
            arrayCompressStream.write(toByte);
            System.out.println("Sent maze to client");//array to write in
            arrayCompressStream.flush();
            arrayCompressStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
