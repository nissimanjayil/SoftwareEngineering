import java.util.ArrayList;
import java.util.List;

//This stores the graphs edges
class Edge{
	int source, dest;
	
	public Edge(int source,int  dest){
		this.source=source;
		this.dest=dest;
	}
}
class Graph{
	List<List<Integer>> adjList = null;
	
	Graph(List<Edge>edges,int N){
		adjList = new ArrayList<>(N);
		
		for(int i=0;i<N;i++){
			adjList.add(i,new ArrayList<>());
		}
		
		for(Edge edge:edges){
			adjList.get(edge.source).add(edge.dest);
		}
	}
}

public class LCADAG {
	

}
