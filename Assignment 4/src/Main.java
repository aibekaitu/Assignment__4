public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        for (int i = 0; i < 10; i++) {
            graph.addVertex(new Vertex(i));
        }
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 9);

        graph.printGraph();

        Experiment experiment = new Experiment();

        System.out.println("\nBFS Traversal:");
        graph.bfs(0);

        System.out.println("\nDFS Traversal:");
        graph.dfs(0);

        experiment.runTraversals(graph);
    }
}