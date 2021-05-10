package Server;


import algorithms.mazeGenerators.Maze;
import algorithms.search.ISearchingAlgorithm;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy{
    /**
     * Solve search problem strategy - Solving a maze got from the client.
     * @param inFromClient input stream - from client.
     * @param outToClient output stream - to client.
     * @param configurations - configuration file.
     */
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient, Configurations configurations) {
        try{
            ObjectInputStream FromClient=new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);
            Maze maze = (Maze)FromClient.readObject();
            SearchableMaze searchableMaze = new SearchableMaze(maze);
            int mazeIdentity = maze.getMazeHashCode();
            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            boolean exist = new File(tempDirectoryPath + '/' + mazeIdentity +".solution").exists();

            /**
             * Check if the solution is already in the directory.
             */
            if (!exist){
                ObjectOutputStream outToDirectory = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath + '/' + mazeIdentity+".solution"));
                ISearchingAlgorithm iSearchingAlgorithm = configurations.mazeSearchingAlgorithm();
                Solution mazeSolution = iSearchingAlgorithm.solve(searchableMaze);
                toClient.writeObject(mazeSolution);
                outToDirectory.writeObject(mazeSolution); //writing the solution to the directory as well.
                toClient.flush();
                outToDirectory.flush();
                outToDirectory.close();
            }
            else{
                // Taking the solution from the directory.
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
