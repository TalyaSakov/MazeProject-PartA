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


public class Configurations {

    private static Configurations single_instance = null;
    private static final Properties properties = new Properties();



    public Configurations() {
        start();
    }

    public static Configurations getInstance()
    {
        if (single_instance == null){
            single_instance = new Configurations();}
        else{
            System.out.println("cant make new instance");}

        return single_instance;
    }

    public static void start(){
        InputStream input = null;
        try {
            input = new FileInputStream("./resources/config.properties");
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


    public IMazeGenerator mazeGeneratingAlgorithm() {
        return switch (properties.getProperty("mazeGenerator")) {
            case "simpleMazeGenerator" -> new SimpleMazeGenerator();
            case "myMazeGenerator" -> new MyMazeGenerator();
            default -> new MyMazeGenerator();
        };
    }

    public ISearchingAlgorithm mazeSearchingAlgorithm() {
        return switch (properties.getProperty("searchingAlgorithm")) {
            case "BreadthFirstSearch" -> new BreadthFirstSearch();
            case "BestFirstSearch" -> new BestFirstSearch();
            case "DepthFirstSearch" -> new DepthFirstSearch();
            default -> new DepthFirstSearch();
        };
    }

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