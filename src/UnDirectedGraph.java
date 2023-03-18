import java.util.List;

public class UnDirectedGraph extends Graph {

	public UnDirectedGraph(int n) {
		super(n);
	}

	public UnDirectedGraph(int n, int[][] adjMatrix) {
		super(n, adjMatrix);
	}

	@Override
	public void addEdge(int u, int v) {
		this.adjMatrix[u][v]++;
		this.adjMatrix[v][u]++;

		List<Integer> listU = this.adjList.get(u);
		listU.add(v);
		this.adjList.put(u, listU);

		List<Integer> listV = this.adjList.get(v);
		listV.add(u);
		this.adjList.put(v, listV);
	}

	@Override
	public void removeEdge(int u, int v) {
		if (this.adjMatrix[u ][v] != 0 && this.adjMatrix[v][u] != 0) {
			this.adjMatrix[u][v]--;
			this.adjMatrix[v][u]--;
		}

		// List<Integer> listU = this.adjList.get(u);
		// listU.remove(Integer.valueOf(v));
		// this.adjList.put(u, listU);

		// List<Integer> listV = this.adjList.get(v);
		// listV.remove(Integer.valueOf(u));
		// this.adjList.put(v, listV);
	}

	@Override
	public int degree(int v) {
		int sum = 0;
		for(int num : adjMatrix[v])
			sum += num;
		return sum;
	}

	@Override
	public int numberOfEdges() {
		int result = 0;
		for (int i = 0; i < this.adjMatrix.length; i++) {
			for (int j = i; j < this.adjMatrix[i].length; j++)
				result += this.adjMatrix[i][j];
		}
		return result;
	}

	@Override
	public void printEdges() {
		String result = "Cac canh:\n";
		for (int i = 0; i < this.adjMatrix.length; i++)
			for (int j = i; j < this.adjMatrix[i].length; j++)
				if (this.adjMatrix[i][j] != 0)
					result += "(" + (i) + "," + (j) + ") ";
		System.out.println(result);
	}

	@Override
	public boolean isConnected() {
		return this.DFS(0).length == this.adjMatrix.length;
	}

	@Override
	public int connectedComponents() {
		int result = 0;
		boolean[] visited = new boolean[adjMatrix.length];
		for (int i = 0; i < adjMatrix.length; i++) {
			if (!visited[i]) {
				int[] vertexDFSArr = DFS(i);
				for (int vertex : vertexDFSArr)
					visited[vertex] = true;
				result++;
			}
		}
		return result;
	}

	@Override
	public boolean isEulerGraph() {
		if(this.isConnected()) {
			for(int i = 0; i < this.adjMatrix.length; i++)
				if(degree(i) % 2 != 0)
					return false;
			return true;
		}
		return false;
	}

	@Override
	public boolean isHalfEulerGraph() {
		if(isConnected()) {
			int oddDegVertexs = 0;
			for(int i = 0; i < adjMatrix.length; i++) {
				if(degree(i) % 2 != 0)
					oddDegVertexs++;
			}
			return oddDegVertexs == 2;
		}
		return false;
	}

}
