import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Graph {

	protected int vertex;
	protected int[][] adjMatrix;
	protected Map<Integer, List<Integer>> adjList;

	public Graph(int n) {
		this.vertex = n;
		this.adjMatrix = new int[n][n];
		this.adjList = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= n; i++) {
			List<Integer> list = new ArrayList<Integer>();
			this.adjList.put(i, list);
		}
	}

	public Graph(int n, int[][] adjMatrix) {
		this.vertex = n;
		this.adjMatrix = adjMatrix;
		this.adjList = matrixToList();
	}

	

	private Map<Integer, List<Integer>> matrixToList() {
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

		for(int i = 0; i < adjMatrix.length; i++) {
			result.put(i, new ArrayList<Integer>());
			for(int j = 0; j < adjMatrix[i].length; j++)
				if(adjMatrix[i][j] != 0) {
					List<Integer> list = result.get(i);
					list.add(j);
				}
		}
		return result;
	} 

	public void printAdjMatrix() {
		for (int i = 0; i < this.adjMatrix.length; i++) {
			for (int j = 0; j < this.adjMatrix[i].length; j++)
				System.out.print(this.adjMatrix[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public void printAdjList() {
		String result = "";
		for (int u : this.adjList.keySet()) {
			result += (u+1) + ": ";
			for (int v : this.adjList.get(u)) {
				result += (v+1) + ", ";
			}
			result = result.substring(0, result.length() - 2);
			result += "\n";
		}
		System.out.println(result);
		System.out.println();
	}

	public String DFS(int v) {
		boolean[] visited = new boolean[this.adjMatrix.length];
		String temp = "";
		String result = DFSSub(v, visited, temp);
		return result.trim();
	}

	private String DFSSub(int v, boolean[] visited, String resultSub) {
		visited[v] = true;
		resultSub += (v + 1) + " ";
		for (int i = 0; i < adjMatrix[v].length; i++)
			if (adjMatrix[v][i] != 0 && !visited[i])
				resultSub = DFSSub(i, visited, resultSub);
		return resultSub;
	}

	public String DFSStack(int v) {
		String result = "";
		boolean[] visited = new boolean[adjMatrix.length];
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(v);
		visited[v] = true;
		result += (v + 1) + " ";

		while (!stack.isEmpty()) {
			v = stack.pop();
			if (!visited[v]) {
				result += (v + 1) + " ";
				visited[v] = true;
			}
			for (int i = adjMatrix.length - 1; i >= 0; i--) {
				if (!visited[i] && adjMatrix[v][i] != 0) {
					stack.push(i);
				}
			}
		}
		return result;
	}

	public String BFS(int v) {
		String result = "";
		boolean[] visited = new boolean[this.adjMatrix.length];

		Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
		visited[v] = true;
		queue.add(v);
		result += (v + 1) + " ";

		while (!queue.isEmpty()) {
			v = queue.poll();
			for (int i = 0; i < adjMatrix[v].length; i++) {
				if (!visited[i] && adjMatrix[v][i] != 0) {
					visited[i] = true;
					queue.add(i);
					result += (i + 1) + " ";
				}
			}
		}
		return result.trim();
	}

	public boolean isSingleGraph() {
		for (int i = 0; i < adjMatrix.length; i++)
			for (int j = 0; j < adjMatrix[i].length; j++)
				if (adjMatrix[i][j] > 1)
					return false;
		return true;
	}

	public boolean isHaveWay(int u, int v) {
		String[] vertexDFSArr = DFS(u).split(" ");
		for (String vertex : vertexDFSArr)
			if (Integer.parseInt(vertex) == v)
				return true;
		return false;
	}

	public abstract void addEdge(int u, int v);
	public abstract void removeEdge(int u, int v);
	public abstract int degree(int v);
	public abstract int numberOfEdges();
	public abstract void printEdges();
	public abstract boolean isConnected();
	public abstract int connectedComponents();

}
