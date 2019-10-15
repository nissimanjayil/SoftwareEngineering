import static org.junit.Assert.*;

import org.junit.Test;

public class LCADAGTEST {

	
	
	//Test for lca dag constructor
	@Test
	public void testLCADAGConstructor() {
		LCADAG graph = new LCADAG(-1);
		
		assertFalse("Number must be greater than zero",false);
	}
	
	
	//test for v() function
	@Test
	public void testV(){
		LCADAG graph =new LCADAG(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		assertEquals(3,graph.V());	
	}
	
	//test for e() function
	@Test
	public void testE(){
		LCADAG graph =new LCADAG(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		assertEquals(2,graph.E());
	}
	
	
	//Test to see if a vertex is valid
	@Test
	public void testValidVertex(){
		LCADAG graph =new LCADAG(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		assertTrue(true);
		
		LCADAG graph2 = new LCADAG(-1);
		assertEquals(0,graph2.E());
	}
	
	@Test
	public void testAddEdge(){
		LCADAG graph =new LCADAG(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		assertEquals(2,graph.E());
		
		graph.addEdge(3, 2);
		//added another edge so the count of edges increased
		assertEquals(3,graph.E());
	}
	
	@Test
	public void testRemoveEdge(){
		LCADAG graph =new LCADAG(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		assertEquals(2,graph.E());
		
		graph.removeEdge(1, 2);
		
		//removed the edge so there is only one edge left that is 0-1
		assertEquals(1,graph.E());
	}
	
	@Test
	public void testoutDegree(){
		LCADAG graph =new LCADAG(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		assertEquals(1,graph.outdegree(0));
		
		LCADAG graph2 =new LCADAG(7);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(0, 3);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 1);
		
		assertEquals(3,graph2.outdegree(0));
		assertEquals(1,graph2.outdegree(3));
	}
	
	@Test
	public void testINDegree(){
		LCADAG graph =new LCADAG(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		assertEquals(1,graph.indegree(1));
		
		LCADAG graph2 =new LCADAG(7);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(0, 3);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 1);
		
		assertEquals(1,graph2.indegree(2));
		assertEquals(0,graph2.indegree(0));
	}
	
	
	@Test
	public void testHasCycle(){
		LCADAG graph =new LCADAG(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		assertEquals(false,graph.hasCycle());
		
		LCADAG graph2 =new LCADAG(7);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(0, 3);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 1);
		assertEquals(true,graph.hasCycle());
	}
	
	
	public void testFindLCA(){
		LCADAG graph =new LCADAG(9);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		
		//This graph contains no cycle
		assertEquals(false,graph.hasCycle());
		assertEquals(3,graph.findLCA(2, 3));
		
		
		//This graph contains cycle
		LCADAG graph2 =new LCADAG(9);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 4);
		graph2.addEdge(4, 1);
		graph2.addEdge(4, 0);
		
		assertEquals(true,graph.hasCycle());
		
		//returns -1
		assertEquals(-1,graph.findLCA(2, 3));
	}

	
}