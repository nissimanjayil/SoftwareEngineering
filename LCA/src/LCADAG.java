
/* references :https://algs4.cs.princeton.edu/42digraph/Digraph.java.html
			   https://algs4.cs.princeton.edu/42digraph/AdjMatrixDigraph.java.html
			   https://www.techiedelight.com/check-given-digraph-dag-directed-acyclic-graph-not
			   https://algs4.cs.princeton.edu/42digraph/DirectedDFS.java.html
			   https://cs.stackexchange.com/questions/90119/how-to-find-lca-in-a-directed-acyclic-graph
*/
public class LCADAG {
	private int V;// # of vertices in graph
	private int E;// # of edges in graph
	private int[][] adj; // adjacency list for vertex v 
	private int[] outdegree;// outdegree of vertex v
	private int[] indegree;  // indegree[v] = indegree of vertex v
	private int[] visited; // vertices that have been visited

	
	//Initialises an empty graph with size V vertices.
	
	public LCADAG(int V) {
		if (V < 0) {
			System.out.println("Number must be greater than zero");
		} else {
			this.V = V;
			this.E = 0;
			indegree = new int[V];
			indegree = new int[V];
			outdegree = new int[V];
			visited = new int[V];
			adj = new int[V][V];
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					adj[i][j] = 0;
				}
			}
		}
	}

	/**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
	
	public int V() {
		return V;
	}

	
	/**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
	public int E() {
		return E;
	}
	
	

	public void validateVertex(int v) {
		if ((v < 0) || (v >= V)) {
			System.out.println(-1);
		}
	}

	/**
     * Adds the directed edge v-w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * 
     */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v][w] = 1;
		indegree[w]++;
		outdegree[v]++;
		E++;
	}

	/**
     * removes the directed edge v-w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * 
     */
	public void removeEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v][w] = 0;
		indegree[w]--;
		outdegree[v]--;
		E--;
	}

	 /**
     * Returns the number of directed edges incident from vertex 
     * @param  v the vertex
     * @return the outdegree of vertex               
     * 
     */
	public int outdegree(int v) {
		validateVertex(v);
		return outdegree[v];
	}

	/**
     * Returns the number of directed edges incident to vertex 
     * @param  v the vertex
     * @return the indegree of vertex               
     * 
     */
	
	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
	}

	
	public int[] adj(int v) {
		validateVertex(v);
		int[] temp = new int[outdegree[v]];
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (adj[v][i] == 1) {
				temp[count] = i;
				count++;
			}
		}
		return temp;
	}

	/*
	 * Checks if the graph has a cycle returns true if it does otherwise it returns false.
	 */

	public boolean hasCycle() {
		boolean hasCycle = false;
		int count = 0;
		for (int i = 0; i < V; i++) {
			visited[count] = i;
			for (int j = 0; j < V; j++) {
				for (int k = 0; k < V; k++) {
					if (visited[k] == j && adj[i][j] == 1) {
						hasCycle = true;
						return hasCycle;
					}
				}
			}
			count++;
		}
		return hasCycle;
	}

	/*
	 * returns the lca
	 */
	public int findLCA(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		hasCycle();
		if (!hasCycle()) {
			return LCAUtil(v, w);
		} else {
			throw new IllegalArgumentException("This graph is not an acyclic graph.");
		}
	}

	/*
	 * calculates the lca
	 */
	
	private int LCAUtil(int v, int w) {
		int[] vArr = new int[E];
		int[] wArr = new int[E];
		boolean[] vMarked = new boolean[V];
		boolean[] wMarked = new boolean[V];
		int vCount = 0;
		int wCount = 0;
		vArr[vCount] = v;
		wArr[wCount] = w;
		for (int j = 0; j < V; j++) {
										
			vMarked[j] = false;
			wMarked[j] = false;
		}
		for (int i = 0; i < V; i++) {
			vMarked[v] = true;
			wMarked[w] = true;
			for (int j = 0; j < V; j++) {
				if (adj[i][j] == 1 && vMarked[i]) {
					vCount++;
					vArr[vCount] = j;
					vMarked[j] = true;
				}
				if (adj[i][j] == 1 && wMarked[i]) {
					wCount++;
					wArr[wCount] = j;
					wMarked[j] = true;
				}
				if (wArr[wCount] == vArr[vCount]) {
					return wArr[wCount];
				}
			}
		}
		return -1;
	}
}
