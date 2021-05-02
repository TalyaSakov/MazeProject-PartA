package Server;

import IO.SimpleCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.search.*;
import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy {


    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {
//        try{
//            ObjectInputStream FromClient=new ObjectInputStream(inFromClient );
//            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);
//            System.out.println("Apply strategy Server begin");
//
//            Maze mazeSize=(Maze) FromClient.readObject();
//            ISearchingAlgorithm searcher;
//            switch (searchingAlgorithm){
//                case "BreadthFirstSearch":
//                    searcher = new BreadthFirstSearch();
//                    break;
//                case "BestFirstSearch":
//                    searcher = new BestFirstSearch();
//                    break;
//                case "DepthFirstSearch":
//                    searcher = new DepthFirstSearch();
//                    break;
//                default:
//                    searcher = new BestFirstSearch();
//            }
//
//
//
//            toClient.flush();
//            ByteArrayOutputStream out=new ByteArrayOutputStream();//a byte array in the memory we will write the array to
//            SimpleCompressorOutputStream output=new SimpleCompressorOutputStream(out);
//            output.write(my_maze.toByteArray());  //write to the stream the byte maze and then it would compress it
//            toClient.writeObject(out.toByteArray());
//            toClient.flush();
//
//
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

  //  }}
}}
