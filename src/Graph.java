import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Graph {
	
	protected int[][] adjMatrix;
	protected Map<Integer, List<Integer>> adjList;
	
	public Graph(int n) {
		this.adjMatrix = new int[n][n];
		this.adjList = new HashMap<Integer, List<Integer>>();
		for(int i            = 1; i <= n; i++) {
			List<Integer> list = new ArrayList<Integer>();
			this.adjList.put(i, list);
		}
	}
	
	public abstract void addEdge(int u, int v);
	public abstract void removeEdge(int u, int v);
	public abstract int degree(int v);
	public abstract int numberOfEdges();
	public abstract void printEdges();
	
	public void printAdjMatrix() {
		for(int i = 0; i < this.adjMatrix.length; i++) {
			for(int j = 0; j < this.adjMatrix[i].length; j++)
				System.out.print(this.adjMatrix[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public void printAdjList() {
		String result = "";
		for(int u : this.adjList.keySet()) {
			result += u + ": ";
			for(int v : this.adjList.get(u)) {
				result += v + ", ";
			}
			result = result.substring(0, result.length() - 2);
			result += "\n";
		}
		System.out.println(result);
		System.out.println();
	}
}
