public class App {

	public static void customTest() {
		Graph unGraph = new UnDirectedGraph(10);

		unGraph.addEdge(1, 2);
		unGraph.addEdge(2, 3);
		unGraph.addEdge(2, 4);
		unGraph.addEdge(3, 6);
		unGraph.addEdge(3, 7);
		unGraph.addEdge(6, 7);

		unGraph.addEdge(5, 8);
		unGraph.addEdge(9, 8);

		unGraph.printAdjList();
		unGraph.printAdjMatrix();

		System.out.println("So canh: " + unGraph.numberOfEdges());
		unGraph.printEdges();
		System.out.println("DFS: " + unGraph.DFS(0));
		System.out.println("DFS Stack: " + unGraph.DFSStack(0));
		System.out.println("BFS: " + unGraph.BFS(0));
		System.out.println("Lien thong: " + unGraph.isConnected());
		System.out.println("Don do thi: " + unGraph.isSingleGraph());
		System.out.println("Co duong di: " + unGraph.isHaveWay(1, 4));
		System.out.println("So thanh phan lien thong: " + unGraph.connectedComponents());

		// DirectedGraph diGraph = new DirectedGraph(6);
		//
		// diGraph.addEdge(1, 2);
		// diGraph.addEdge(2, 3);
		// diGraph.addEdge(2, 4);
		// diGraph.addEdge(3, 1);
		// diGraph.addEdge(4, 3);
		// diGraph.addEdge(4, 5);
		// diGraph.addEdge(5, 6);
		// diGraph.addEdge(6, 4);
		//
		// diGraph.printAdjList();
		// diGraph.printAdjMatrix();
		//
		// System.out.println("So canh: " + diGraph.numberOfEdges());
		// diGraph.printEdges();
		//
		// System.out.println("DFS: " + diGraph.DFS(0));
		// System.out.println("BFS: " + diGraph.BFS(0));
		// System.out.println("Lien Thong: " + diGraph.isConnected());
		// System.out.println("Co Duong Di: " + diGraph.isHaveWay(1, 4));
		//
		// DirectedGraph tempDiGraph = (DirectedGraph)diGraph;
		// System.out.println("Xet tinh lien thong: " +
		// tempDiGraph.considerConnectivity());
	}

	public static void autoTest() {
		GraphUtils.generateRandomUnDirectedMatrixToFile("./src/Test/matrix.txt", 5);
		Graph graph = GraphUtils.readFromFile("./src/Test/matrix.txt");
		graph.printAdjList();
		graph.printAdjMatrix();
		System.out.println("So canh: " + graph.numberOfEdges());
		graph.printEdges();
		System.out.println("DFS: " + graph.DFS(0));
		System.out.println("DFS Stack: " + graph.DFSStack(0));
		System.out.println("BFS: " + graph.BFS(0));
		System.out.println("Lien thong: " + graph.isConnected());
		System.out.println("Don do thi: " + graph.isSingleGraph());
		System.out.println("Co duong di: " + graph.isHaveWay(1, 4));
		System.out.println("So thanh phan lien thong: " + graph.connectedComponents());
	}

	public static void main(String[] args) {
		autoTest();
	}
}
