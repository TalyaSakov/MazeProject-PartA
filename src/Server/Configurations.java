package Server;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.BestFirstSearch;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.ISearchingAlgorithm;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  Configuration class
 */
public class Configurations {

    private static Configurations single_instance = null;
    private static final Properties properties = new Properties();



    public Configurations() {
        start();
    }

    /**
     * singleton function - getInstance
     * @return
     */
    public static Configurations getInstance()
    {
        if (single_instance == null){
            single_instance = new Configurations();}
        else{
            System.out.println("cant make new instance");}

        return single_instance;
    }

    /**
     * Connect to the configuration file
     */
    public static void start(){
        InputStream input = null;
        try {
            input = Configurations.class.getResourceAsStream("/config.properties");
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @return the IMazeGenerator instance.
     */
    public IMazeGenerator mazeGeneratingAlgorithm() {
        return switch (properties.getProperty("mazeGenerator")) {
            case "simpleMazeGenerator" -> new SimpleMazeGenerator();
            case "myMazeGenerator" -> new MyMazeGenerator();
            default -> new MyMazeGenerator();
        };
    }

    /**
     * @return the ISearchingAlgorithm instance
     */
    public ISearchingAlgorithm mazeSearchingAlgorithm() {
        return switch (properties.getProperty("searchingAlgorithm")) {
            case "BreadthFirstSearch" -> new BreadthFirstSearch();
            case "BestFirstSearch" -> new BestFirstSearch();
            case "DepthFirstSearch" -> new DepthFirstSearch();
            default -> new DepthFirstSearch();
        };
    }

    /**
     * @return the threadPoolSize
     */
    public int threadPoolSize() {
//            boolean isNum = true;
//            try {
//                Double.parseDouble("threadPoolSize");
//            }
//            catch(NumberFormatException nfe)
//            {
//                isNum = false;
//            }
        return (Integer.parseInt(properties.getProperty("threadPoolSize")));
    }
}