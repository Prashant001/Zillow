/**
 * This Class is for Question 2
 * 
 * 
 * @author Prashant Bhartiya
 */
package com.prashant.zillow;

import java.util.Comparator;

public class TrinaryTree<T> 
{
    /**
     * Root Node of the tree
     */
    private  TrinaryTreeNode<T> rootNode;
    /*
     * Comparator for this tree
     */
    private final Comparator<T> comparator;
	 
    /*
     * Factory Method to retuen an instance of Trinary tree
     */
    public static <C extends Comparable<C>> TrinaryTree<C> create()
    {
        return new TrinaryTree<C>(new Comparator<C>() {
				public int compare(C o1, C o2) {
					return o1.compareTo(o2);
				}
			});
    }

	/**
	 * Constructor 
	 *
	 * @param comparator the Comparator to use.
	 */
	public TrinaryTree(Comparator<T> comparator) 
	{
		this.comparator = comparator;
	}
	
    /** Insert a Node in the tree
     * 
     * @param value the value to be inserted
     */
    public void insert(T value)   
    {  
       	if(value == null)
    	{
			throw new IllegalArgumentException("Cannot insert null value");
		}
    	// create root node if it does not exist
    	if (rootNode == null)
    	{
    		rootNode = new TrinaryTreeNode<T>(value,null);
    		return;
    	}
              
        insertNode(rootNode, value);  
  
     }  
    /** Delete a Node from the tree
     * 
     * @param value the value to be deleted
     */
    public void delete(T value) 
    {
    	if(value == null)
    	{
			throw new IllegalArgumentException("Cannot insert null value");
		}
    	
    	if(rootNode == null)
    	{
			throw new IllegalArgumentException("Tree is null");
		}
    	
    	deleteNode(rootNode, value);
	}
    
    public TrinaryTreeNode<T> getRootNode()
    {
    	return rootNode;
    }
  
    private void insertNode(TrinaryTreeNode<T> node, T value)   
    {         
        
    	int comparison = comparator.compare(value, node.getValue());
        if (comparison < 0)   
        {  
            //Left child exist  
            if (node.getLeft() != null)   
            {  
                insertNode(node.getLeft(), value);  
            }   
            // create the left child
            else   
            {  
                node.setLeft(new TrinaryTreeNode<T>(value, node));  
            }  
        }   
        else if (comparison > 0)   
        {  
            if (node.getRight() != null)   
            {  
                insertNode(node.getRight(), value);  
            }   
            // create the right child
            else   
            {  
                node.setRight(new TrinaryTreeNode<T>(value, node));  
            }  
        }  
        else  
        {  
            if (node.getMiddle() != null)   
            {  
                insertNode(node.getMiddle(), value);  
            }   
            // create the middle child
            else   
            {  
                node.setMiddle( new TrinaryTreeNode<T>(value, node));  
            }  
        }  
    }  
  
    private void deleteNode(TrinaryTreeNode<T> node, T value)   
    {         
       int comparison = comparator.compare(value, node.getValue());
        if (comparison < 0)   
        {  
             
            if (node.getLeft() != null)   
            {  
                deleteNode(node.getLeft(), value);  
            }   
            
        }   
         
        else if (comparison > 0)   
        {  
            if (node.getRight() != null)   
            {  
                deleteNode(node.getRight(), value);  
            }   
            
        }  
       
        else  
        {  
            if (node.getMiddle() != null)   
            {  
                deleteNode(node.getMiddle(), value);  
            }   
            else   
            {
            	//delete this node
                clearNode(node);  
            }  
        }  
    }  
    
    private void clearNode(TrinaryTreeNode<T> node)
    {
    	TrinaryTreeNode<T> parentNode = node.getParentNode();
    	TrinaryTreeNode<T> leftNode = node.getLeft();
		TrinaryTreeNode<T> centerNode = node.getMiddle();
		TrinaryTreeNode<T> rightNode = node.getRight();
		// clear this node from the parent node
		if (parentNode != null)
    	{
			parentNode.clearChildNode(node);
    	}
		
		node = null;
		// delete the root node
    	if (parentNode == null)
    	{
    		rootNode = null;
    		return;
    	}
			
		// Add child nodes of this node back to the tree.
		
		
		if(centerNode != null)
		{
			insertNode(parentNode, centerNode.getValue());
		}
		if(leftNode != null) 
		{
			insertNode(parentNode, leftNode.getValue());
		}
		if(rightNode != null) 
		{
			insertNode(parentNode, rightNode.getValue());
		}
    }
    
    /** Print the tree
     * 
     * @param root the node from which to print the tree
     */
    public void print(TrinaryTreeNode<T> root)   
    {  
        if (root != null)   
        {  
            System.out.println("Node value : " + root.getValue());  
            print(root.getLeft());  
            print(root.getMiddle());              
            print(root.getRight());  
        }  
    }


}
