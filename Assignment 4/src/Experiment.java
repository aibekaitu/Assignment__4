public class Experiment {

    public void runTraversals(Graph g) {

        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();

        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();

        System.out.println("BFS Time: " + (endBfs - startBfs) + " ns");
        System.out.println("DFS Time: " + (endDfs - startDfs) + " ns");
    }

    public void printResults() {
        System.out.println("Experiments completed.");
    }
}