package Server;


import algorithms.mazeGenerators.Maze;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.ISearchingAlgorithm;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy{
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient, Configurations configurations) {
        try{
            ObjectInputStream FromClient=new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);
            Maze maze = (Maze)FromClient.readObject();
            SearchableMaze searchableMaze = new SearchableMaze(maze);
            int mazeIdentity = maze.getMazeHashCode();
            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            boolean exist = new File(tempDirectoryPath + '/' + mazeIdentity +".solution").exists();

            if (!exist){
                ObjectOutputStream outToDirectory = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath + '/' + mazeIdentity+".solution"));
                ISearchingAlgorithm iSearchingAlgorithm = configurations.mazeSearchingAlgorithm();
                Solution mazeSolution = iSearchingAlgorithm.solve(searchableMaze);
                toClient.writeObject(mazeSolution);
                outToDirectory.writeObject(mazeSolution);
                toClient.flush();
                outToDirectory.flush();
                outToDirectory.close();
            }
            else{
                ObjectInputStream inFromDirectory = new ObjectInputStream(new FileInputStream(tempDirectoryPath + mazeIdentity+".solution"));
                System.out.println(tempDirectoryPath + mazeIdentity);
                Solution mazeSolution = (Solution) inFromDirectory.readObject();
                toClient.writeObject(mazeSolution);
                toClient.flush();
                inFromDirectory.close();
            }

            FromClient.close();
            toClient.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
