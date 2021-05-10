package Server;
import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;


public class ServerStrategyGenerateMaze implements IServerStrategy {

    @Override
    /**
     * Genarating maze strategy - Solving a maze got from the client.
     * @param inFromClient input stream - from client.
     * @param outToClient output stream - to client.
     * @param configurations - configuration file.
     */
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient, Configurations configurations) {

        try{
            ObjectInputStream FromClient=new ObjectInputStream(inFromClient );
            ObjectOutputStream toClient=new ObjectOutputStream (outToClient);
            System.out.println("Apply strategy Server begin");
            int[] mazeSize=(int[])FromClient.readObject();
            Maze my_maze = configurations.mazeGeneratingAlgorithm().generate(mazeSize[0],mazeSize[1]);
            toClient.flush();
            ByteArrayOutputStream out=new ByteArrayOutputStream(); //a byte array in the memory we will write the array to

            MyCompressorOutputStream output=new MyCompressorOutputStream(out); //create a new object output that would get out as an input and will writ to it
            output.write(my_maze.toByteArray());  //write to the stream(out) the byte maze and then it would compress it
            System.out.println(my_maze.toString());
            toClient.writeObject(out.toByteArray());//now out object holds the compressed maze , so we would read it into client

            toClient.flush();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

