package Server;


import algorithms.mazeGenerators.Maze;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy{
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {
        try{
            ObjectInputStream FromClient=new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);
            //TODO : Check if the hashcode is working okay.
            SearchableMaze maze = new SearchableMaze((Maze)FromClient.readObject());
            int mazeIdentity = maze.toString().hashCode();
   //         String mazeIdentity = "450237404.solution";
            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
 //           String tempDirectoryPath = "C:\\Users\\Talya\\Desktop\\talya\\";
            boolean exist = new File(tempDirectoryPath + '\\' + mazeIdentity).exists();
//            File mazeFile = new File(tempDirectoryPath + '/' + mazeIdentity);

           ;

            if (!exist){
                ObjectOutputStream outToDirectory = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath + '\\' + mazeIdentity+".solution"));

                System.out.println("Solution doesn't exists");
                BreadthFirstSearch bfs = new BreadthFirstSearch();
                Solution mazeSolution = bfs.solve(maze);
                toClient.writeObject(mazeSolution);
                outToDirectory.writeObject(mazeSolution);
                toClient.flush();
                outToDirectory.flush();
                outToDirectory.close();

            }
            else{

//                File newFile = new File(tempDirectoryPath + '/' + mazeIdentity);
                ObjectInputStream inFromDirectory = new ObjectInputStream(new FileInputStream(tempDirectoryPath +mazeIdentity));

                System.out.println(tempDirectoryPath + mazeIdentity);
                System.out.println("Solution already exists");
                Solution mazeSolution = (Solution) inFromDirectory.readObject();
                toClient.writeObject(mazeSolution);
                toClient.flush();
                inFromDirectory.close();
            }


//            inFromDirectory.close();


            FromClient.close();
            toClient.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}