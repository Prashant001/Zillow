package com.prashant.zillow;


public class TrinaryTreeNode<T> 
{
    /** Left Child Node, value is less than node value 
     *  
     */
    private TrinaryTreeNode<T> left;  
   

    /** Middle Child Node, value is equal to node value 
     *  
     */  
    private TrinaryTreeNode<T> middle;  
   

    /** Right Child Node, value is greather than node value 
     *  
     */  
    private TrinaryTreeNode<T> right;  
      
   
	/* Node value
     *   
     */
    private final T value;


    private TrinaryTreeNode<T> parentNode;
    
  
    public TrinaryTreeNode(T value, TrinaryTreeNode<T> parentNode)   
    {  
        this.value = value;  
        this.parentNode = parentNode;
    }
    
   
      
    public TrinaryTreeNode<T> getLeft()
    {
        return left;
    }

    public void setLeft(TrinaryTreeNode<T> left)
    {
        this.left = left;
    }

    public TrinaryTreeNode<T> getMiddle()
    {
        return middle;
    }

    public void setMiddle(TrinaryTreeNode<T> middle) 
    {
        this.middle = middle;
    }
	
    public TrinaryTreeNode<T> getRight()
    {
        return right;
    }

    public void setRight(TrinaryTreeNode<T> right)
    {
        this.right = right;
    }

    public T getValue()
    {
        return value;
    }
	
	
    public TrinaryTreeNode<T> getParentNode() 
    {
        return parentNode;
    }
	
	/**
	 * Clear Child Node from this Node
	 * @param node the node to be removed
	 */
    void clearChildNode(TrinaryTreeNode<T> node)
    {
		
        if (middle != null && middle.getValue() == node.value)
        {
            middle = null;
            return;		
        }
        if (left != null && left.getValue() == node.value)
        {
            left = null;
            return;		
        }
        if (right != null && right.getValue() == node.value)
        {
            right = null;
            return;		
        }
		
    }
}
