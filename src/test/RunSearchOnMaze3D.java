package test;
import algorithms.maze3D.IMazeGenerator3D;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.maze3D.SearchableMaze3D;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.*;

import java.util.ArrayList;

public class RunSearchOnMaze3D {

    public static void main(String[] args) {
        IMazeGenerator3D mg = new MyMaze3DGenerator();
<<<<<<< HEAD
        Maze3D maze3D = mg.generate(400,400,400);
||||||| 45004d8
        Maze3D maze3D = mg.generate(500,500,500 );
=======
        Maze3D maze3D = mg.generate(10,10,10 );

>>>>>>> 1505b297b9630f60bf9c7ba2cbf95785e99d6f00
        maze3D.print();
        System.out.println("The maze is finished");
        System.out.println(maze3D.getStartPosition());
        System.out.println(maze3D.getGoalPosition());
        SearchableMaze3D searchable3DMaze = new SearchableMaze3D(maze3D);
        solveProblem(searchable3DMaze, new BreadthFirstSearch());
//        solveProblem(searchable3DMaze, new DepthFirstSearch());
//        solveProblem(searchable3DMaze, new BestFirstSearch());
    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm
            searcher) {
        //Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
        //Printing Solution Path
        System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }
    }
}
