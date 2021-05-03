package Server;

import IO.SimpleCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.ISearchable;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerStrategySolveSearchProblem implements IServerStrategy{

    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {
        try{
            ObjectInputStream FromClient=new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);

            SearchableMaze maze = new SearchableMaze((Maze)FromClient.readObject());
//            int mazeIdentity = maze.toString().hashCode();
            int mazeIdentity = 1631196173;
//            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            String tempDirectoryPath = "/Users/jonthan.p/Desktop/Test-ATP/";
            boolean exist = new File(tempDirectoryPath + '/' + mazeIdentity).exists();
//            File mazeFile = new File(tempDirectoryPath + '/' + mazeIdentity);

            ObjectOutputStream outToDirectory = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath + '/' + mazeIdentity));

            if (!exist){
                System.out.println("Solution doesn't exists");
                BreadthFirstSearch bfs = new BreadthFirstSearch();
                Solution mazeSolution = bfs.solve(maze);
                toClient.writeObject(mazeSolution);
                outToDirectory.writeObject(mazeSolution);
                toClient.flush();
                outToDirectory.flush();

            }
            else{
                File newFile = new File(tempDirectoryPath + '/' + mazeIdentity);
                ObjectInputStream inFromDirectory = new ObjectInputStream(new FileInputStream(newFile));
                System.out.println("Solution already exists");
                Solution mazeSolution = (Solution) inFromDirectory.readObject();
                toClient.writeObject(mazeSolution);
                toClient.flush();
            }

//            inFromDirectory.close();
            outToDirectory.close();
            FromClient.close();
            toClient.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
