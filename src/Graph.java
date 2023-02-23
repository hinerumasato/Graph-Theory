import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Graph {
	
	protected int[][] adjMatrix;
	protected Map<Integer, List<Integer>> adjList;
	
	public Graph(int n) {
		this.adjMatrix = new int[n][n];
		this.adjList = new HashMap<Integer, List<Integer>>();
		for(int i = 1; i <= n; i++) {
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

	public String DFS() {
		boolean[] visited = new boolean[this.adjMatrix.length];
		String temp = "";
		String result = DFSSub(0, visited, temp);
		return result;
	}

	private String DFSSub(int v, boolean[] visited, String resultSub) {
		visited[v] = true;
		resultSub += (v+1) + " ";
		for(int i = 0; i < adjMatrix[v].length; i++)
			if(adjMatrix[v][i] != 0 && !visited[i])
				resultSub = DFSSub(i, visited, resultSub);
		return resultSub;
	}

	public String BFS() {
		String result = "";
		boolean[] visited = new boolean[this.adjMatrix.length];

		Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
		int v = 0;
		visited[v] = true;
		queue.add(v);
		result += (v+1) + " ";

		while(!queue.isEmpty()) {
			v = queue.poll();
			for(int i = 0; i < adjMatrix[v].length; i++) {
				if(!visited[i] && adjMatrix[v][i] != 0) {
					visited[i] = true;
					queue.add(i);
					result += (i+1) + " ";
				}
			}
		}
		return result;
	}

	public abstract boolean isConnected();
}
