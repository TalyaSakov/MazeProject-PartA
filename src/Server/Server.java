package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private ThreadPoolExecutor threadPoolExecutor;
//    private final Logger LOG = LogManager.getLogManager(); //Log4j2


    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    }
    public void start() {
        threadPoolExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        new Thread(this::startServer).start();
    }
    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);
//            LOG.info("Starting server at port = " + port);
            System.out.println("Starting server at port = " + port);
            try {
                System.out.println("startClientSocket is started by new thread");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted: " + clientSocket.toString());
                threadPoolExecutor.execute(() -> handleClient(clientSocket));
//                handleClient(clientSocket);
//      LOG.info("Client accepted: " + clientSocket.toString());
            } catch (IOException e) {
                System.out.println("Socket is waiting");;
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
