package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

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

            new Thread(() -> {
                startClientSocket();
            }).start();

    private void startClientSocket(){

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Client accepted: " + clientSocket.toString());
//      LOG.info("Client accepted: " + clientSocket.toString());
        } catch (SocketTimeoutException e){
//      LOG.debug("Socket timeout");
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