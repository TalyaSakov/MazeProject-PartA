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
            System.out.println("Apply S Server");

            int[] mazeParam = (int [])fromClient.readObject();
            Maze maze= new MyMazeGenerator().generate(mazeParam[0],mazeParam[1]);
            byte [] toByte = maze.toByteArray();

//            ByteArrayOutputStream arr=new ByteArrayOutputStream(); //create an input to the stream
//            SimpleCompressorOutputStream arrayToCompress= new SimpleCompressorOutputStream(arr); //sent the arr to the compressor

            //  arrayToCompress.flush();
//            arrayToCompress.write(toByte); //array to write in
//            arrayToCompress.flush();
//            arrayToCompress.close();
////            toClient.writeObject(arr.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
