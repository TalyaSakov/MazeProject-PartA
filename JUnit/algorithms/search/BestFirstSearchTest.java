
package algorithms.search;

import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    void getName() {
        BestFirstSearch BestFS= new BestFirstSearch();
        assertEquals("BestFirstSearch",BestFS.getName());
    }

    @Test
    void solve() {

            IMazeGenerator mg = new MyMazeGenerator();
            IMazeGenerator emg = new EmptyMazeGenerator();
            BestFirstSearch BestFS= new BestFirstSearch();
            Maze regularMaze = mg.generate(10,10);
            SearchableMaze searchableMaze = new SearchableMaze(regularMaze);
            Solution solution=BestFS.solve(searchableMaze);
            assertNotEquals(null,solution);
            assertNotEquals(0,solution);
            testTooSmallMaze(mg,1,1,"Maze must be greater then 2X2");
            testTooSmallMaze(emg,-30,-20,"Maze must be greater then 2X2");



        }

    public void testTooSmallMaze(IMazeGenerator mg ,int row,int column, String expected)
    {
        try
        {
            Maze EmptyMaze = mg.generate(row,column);
        }
        catch(RuntimeException re)
        {
            assertEquals(expected, re.getMessage());
        }
    }

    }
