**Maze Project**

In this project we built a maze game.
The maze uses 3 creation algorithms and 3 search algorithms in order to solve it (BFS,DFS,Best First Search).

By using client-server architecture we allowed multiple clients to operate in parallel (using threads), send requests and receive responses from the servers that create mazes and solve mazes, by sending compressed mazes.

In this phase we focused on GUI designing (using JavaFX), and adding many features such as choosing the generating & solving algorithms, choosing game-soundtrack, save & load old mazes, etc.
The program designed according to the MVVM architecture.
We used Log4j2 to save logs of various operations performed on the system.
