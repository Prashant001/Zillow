package com.prashant.zillow;



import org.junit.Before;
import org.junit.Test;

public class TrinaryTreeTest 
{
	TrinaryTree tree;
	 
	@Before public void initialize() 
	{
		tree = TrinaryTree.create(); 
		int values[] = {5, 4, 1, 2,9, 5, 7, 2, 2};
		for (int value: values)
		{
			tree.insert(value);
		}
          
     
	}
	/* The tests below are for manual verification only, currenlty no automated
	 * verification is in place
	 */
	@Test public void printTree()
	{
		tree.print(tree.getRootNode());
	}
	
	@Test public void insertNode()
	{
		tree.insert(10);
		tree.print(tree.getRootNode());
	}
	@Test public void deleteNode()
	{
		tree.delete(5);
		tree.delete(9);
		tree.print(tree.getRootNode());
	}
}
