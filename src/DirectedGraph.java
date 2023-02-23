import java.util.ArrayList;
import java.util.List;

public class DirectedGraph extends Graph {

	public DirectedGraph(int n) {
		super(n);
	}

	@Override
	public void addEdge(int u, int v) {
		this.adjMatrix[u-1][v-1]++;
		List<Integer> list = this.adjList.get(u);
		list.add(v);
		this.adjList.put(u, list);
	}

	@Override
	public void removeEdge(int u, int v) {
		if(this.adjMatrix[u-1][v-1] != 0) {
			this.adjMatrix[u-1][v-1]--;
		}
		if(this.adjList.containsKey(u)) {
			List<Integer> list = this.adjList.get(u);
			list.remove(Integer.valueOf(v));
			this.adjList.put(u, list);
		}
		else {
			List<Integer> newList = new ArrayList<Integer>();
			newList.remove(Integer.valueOf(v));
			this.adjList.put(u, newList);
		}
	}

	@Override
	public int degree(int v) {
		return 0;
	}
	
	public int outDegree(int v) {
		return this.adjList.get(v).size();
	}
	
	public int inDegree(int v) {
		int result = 0;
		for(int edge : this.adjList.keySet())
			for(int a : this.adjList.get(edge))
				if(v == a) result++;
		return result;
	}

	@Override
	public int numberOfEdges() {
		int result = 0;
		for(int i = 0; i < this.adjMatrix.length; i++) {
			for(int j = 0; j < this.adjMatrix[i].length; j++)
				result += this.adjMatrix[i][j];
		}
		return result;
	}
	
	@Override
	public void printEdges() {
		String result = "Cac canh:\n";
		for(int i = 0; i < this.adjMatrix.length; i++)
			for(int j = 0; j < this.adjMatrix[i].length; j++)
				if(this.adjMatrix[i][j] != 0)
					result += "(" + (i+1) + "," + (j+1) + ") ";
		System.out.println(result);
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'isConnected'");
	}

}
