
public class App {
	public static void main(String[] args) {
		Graph unGraph = new UnDirectedGraph(5);
		
		unGraph.addEdge(1, 2);
		unGraph.addEdge(1, 3);
		unGraph.addEdge(2, 3);
		unGraph.addEdge(2, 5);
		unGraph.addEdge(4, 5);
		
		unGraph.printAdjList();
		unGraph.printAdjMatrix();
		
		System.out.println(unGraph.numberOfEdges());
		unGraph.printEdges();
		
		DirectedGraph diGraph = new DirectedGraph(5);
		
		diGraph.addEdge(1, 2);
		diGraph.addEdge(1, 3);
		diGraph.addEdge(2, 1);
		diGraph.addEdge(2, 3);
		diGraph.addEdge(2, 5);
		diGraph.addEdge(4, 5);
		
		diGraph.printAdjList();
		diGraph.printAdjMatrix();
		
		System.out.println(diGraph.numberOfEdges());
		diGraph.printEdges();
	}
}
