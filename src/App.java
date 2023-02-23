
public class App {
	public static void main(String[] args) {
		Graph unGraph = new UnDirectedGraph(10);
		
		unGraph.addEdge(1, 2);
		unGraph.addEdge(1, 3);
		unGraph.addEdge(1, 5);
		unGraph.addEdge(1, 10);
		unGraph.addEdge(2, 4);
		unGraph.addEdge(3, 6);
		unGraph.addEdge(3, 7);
		unGraph.addEdge(3, 9);
		unGraph.addEdge(5, 8);
		unGraph.addEdge(8, 9);
		
		unGraph.printAdjList();
		unGraph.printAdjMatrix();
		
		System.out.println(unGraph.numberOfEdges());
		unGraph.printEdges();
		System.out.println(unGraph.DFS());
		System.out.println(unGraph.BFS());
		System.out.println(unGraph.isConnected());
		
		// DirectedGraph diGraph = new DirectedGraph(5);
		
		// diGraph.addEdge(1, 2);
		// diGraph.addEdge(1, 3);
		// diGraph.addEdge(2, 1);
		// diGraph.addEdge(2, 3);
		// diGraph.addEdge(2, 5);
		// diGraph.addEdge(4, 5);
		
		// diGraph.printAdjList();
		// diGraph.printAdjMatrix();
		
		// System.out.println(diGraph.numberOfEdges());
		// diGraph.printEdges();

		// System.out.println(diGraph.DFS());
	}
}
