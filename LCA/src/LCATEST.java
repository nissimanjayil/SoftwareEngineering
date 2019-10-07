import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LCATEST {

	@Test
	//Test to check the node constructor if it pushes the values in correctly.
	public void nodeConstructor() {
		Node tree = new Node(1); 
		tree.left= new Node(2);
		tree.right = new Node(3);
		
		
		assertEquals(2,tree.left.data);
		assertEquals(3,tree.right.data);
		assertEquals(1,tree.data);
		
	}
	
	@Test
	public void findPathTest(){
		//if the root is null returns false
		Node nullTree = new Node(1);
		List<Integer>nullPath = new ArrayList<>();
		LCA nullRoot = new LCA();
		assertEquals(false,nullRoot.findPath(nullTree,2,nullPath));
		
		//returns true
		Node tree = new Node(0);
		tree.left = new Node(1);
		tree.right = new Node(2);
		tree.left.left = new Node(3);
		tree.left.right = new Node(4);
		tree.right.left= new Node(5);
		tree.right.right = new Node(6);
		List<Integer> path = new ArrayList<>();
		LCA root = new LCA();
		assertEquals(true,root.findPath(tree,2,path));
		
		assertEquals(false,root.findPath(tree,9,path));
		
	}
	
	@Test
	//Tests the function findLCA internal
	public void findLCAInternalTest(){
		Node tree = new Node(0);
		tree.left = new Node(1);
		tree.right = new Node(2);
		tree.left.left = new Node(3);
		tree.left.right = new Node(4);
		tree.right.left= new Node(5);
		tree.right.right = new Node(6);
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
		LCA root = new LCA();
		assertEquals("",-1,root.findLCAInternal(tree, 9,8 ));
		assertEquals(0,root.findLCAInternal(tree, 1, 2));
		
	}

	@Test
	public void findLCATestPositive(){
		Node tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.left.left = new Node(4);
		tree.left.right = new Node(5);
		tree.right.left= new Node(6);
		tree.right.right = new Node(7);
		LCA lca = new LCA();
		lca.root = tree;
		assertEquals(2,lca.findLCA(4, 5));
		assertEquals(3,lca.findLCA(6, 7));
		assertEquals(1,lca.findLCA(4, 6));
		assertEquals(1,lca.findLCA(3, 4));
		assertEquals(2,lca.findLCA(2, 4));
	}
	
	@Test
	public void findLCATestNegative(){
		Node tree = new Node(-1);
		tree.left = new Node(-2);
		tree.right = new Node(-3);
		tree.left.left = new Node(-4);
		tree.left.right = new Node(-5);
		tree.right.left= new Node(-6);
		tree.right.right = new Node(-7);
		LCA lca = new LCA();
		lca.root = tree;
		assertEquals(-2,lca.findLCA(-4, -5));
		assertEquals(-3,lca.findLCA(-6, -7));
		assertEquals(-1,lca.findLCA(-4, -6));
		assertEquals(-1,lca.findLCA(-3, -4));
		assertEquals(-2,lca.findLCA(-2, -4));
	}
	
}
