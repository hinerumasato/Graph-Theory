import java.util.List;

public class UnDirectedGraph extends Graph {

	public UnDirectedGraph(int n) {
		super(n);
	}

	@Override
	public void addEdge(int u, int v) {			
		this.adjMatrix[u-1][v-1]++;
		this.adjMatrix[v-1][u-1]++;
		
		List<Integer> listU = this.adjList.get(u);
		listU.add(v);
		this.adjList.put(u, listU);
		
		List<Integer> listV = this.adjList.get(v);
		listV.add(u);
		this.adjList.put(v, listV);
	}

	@Override
	public void removeEdge(int u, int v) {
		if(this.adjMatrix[u-1][v-1] != 0 && this.adjMatrix[v-1][u-1] != 0) {
			this.adjMatrix[u-1][v-1]--;
			this.adjMatrix[v-1][u-1]--;
		}
		
		List<Integer> listU = this.adjList.get(u);
		listU.remove(Integer.valueOf(v));
		this.adjList.put(u, listU);
		
		List<Integer> listV = this.adjList.get(v);
		listV.remove(Integer.valueOf(u));
		this.adjList.put(v, listV);
	}

	@Override
	public int degree(int v) {
		return this.adjList.get(v).size();
	}

	@Override
	public int numberOfEdges() {
		int result = 0;
		for(int i = 0; i < this.adjMatrix.length; i++) {
			for(int j = i+1; j < this.adjMatrix[i].length; j++)
				result += this.adjMatrix[i][j];
		}
		return result;
	}

	@Override
	public void printEdges() {
		String result = "Cac canh:\n";
		for(int i = 0; i < this.adjMatrix.length; i++)
			for(int j = i+1; j < this.adjMatrix[i].length; j++)
				if(this.adjMatrix[i][j] != 0)
					result += "(" + (i+1) + "," + (j+1) + ") ";
		System.out.println(result);
	}

	@Override
	public boolean isConnected() {
		return this.DFS(0).split(" ").length == this.adjMatrix.length;
	}

	@Override
	public int connectedComponents() {
		int result = 0;
		boolean[] visited = new boolean[adjMatrix.length];
		for(int i = 0; i < adjMatrix.length; i++) {
			if(!visited[i]) {
				String[] vertexDFSArr = DFS(i).split(" ");
				for(String vertex : vertexDFSArr)
					visited[Integer.parseInt(vertex) - 1] = true;
				result++;
			}
		}
		return result;
	}
	
}
