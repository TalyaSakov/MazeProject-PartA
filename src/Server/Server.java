package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Server {
    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
//    private final Logger LOG = LogManager.getLogManager(); //Log4j2


    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
    }

    public void start() {

        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(listeningIntervalMS);
//            LOG.info("Starting server at port = " + port);
        System.out.println("Starting server at port = " + port);

//            while (!stop) {

    }
    private void start2(ServerSocket serverSocket){

     try {
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client accepted: " + clientSocket.toString());
//                    LOG.info("Client accepted: " + clientSocket.toString());

        // This thread will handle the new Client
        new Thread(() -> {
            handleClient(clientSocket);
        }).start();

    } catch (SocketTimeoutException e){
//                    LOG.debug("Socket timeout");
        System.out.println("Socket timeout");
    }
         catch (IOException e) {
//            LOG.error("IOException", e);
                System.out.println("IOException " + e);
                }
    }




    private void handleClient(Socket clientSocket) {
        try {
            strategy.applyStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
//            LOG.info("Done handling client: " + clientSocket.toString());
            System.out.println("Done handling client: " + clientSocket.toString());
            clientSocket.close();
        } catch (IOException e){
//            LOG.error("IOException", e);
            System.out.println("IOException " + e);
        }
    }

    public void stop(){
//        LOG.info("Stopping server...");
        System.out.println("Stopping server...");
        stop = true;
    }
}
