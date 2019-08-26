package maman16;

public class BinarySearchTree {
private Node root ;
private Node median;
private int countDef ; //amount of node that bigger than the median minus the amount of nodes that lesser than the median.


/**
 *  constracts an empty BWST(Binary Wired Search Tree)
 *  
 */
public BinarySearchTree() 
{
	super();
	this.root = null;
	median = null;
	countDef = 0;
}
/** 
 * returns a pointer to the root of the tree
 * @return returns a pointer to the root of the tree
 */
public Node getRoot()
{
	return root;
}

/**
 * returns a pointer to the median of the tree
 * @return returns a pointer to the median of the tree
 */
public  Node getMedian() {
	return median;
}



/**
 * set the median according to the countDef value after the insertion or deletion of a Node 
 */
//countDef value is after the insertion setting

private void SetMedian()
{

	if (countDef==2)
	{
		  this.median = this.treeSuccessor(this.median);
          countDef=0;
	}
	else
		if(countDef==-1)
		{
			this.median = this.treePredecessor(this.median);
	          countDef=1;
		}
}


/**
 * returns a pointer to the Minimum of the tree
 * @return returns a pointer to the Minimum of the tree
 */
/*
 * uses the getMimimum method form the root of the tree
 */
public Node treeMinimum ()
{
	Node check = this.root;
	return check.getMinimum();
}

/**
 * returns a pointer to the maximum of the tree
 * @return returns a pointer to the maximum of the tree
 */
/*
 * uses the getmMximum method form the root of the tree
 */
public Node treeMaximum ()
{
	Node check = this.root;
	return check.getMaximum();
}

/**
 * find the successor of given node.
 * @param node the node that we search the successor of
 * @return a pointer to the successor of the given node.
 * returns null if the given node is the maximum
 */
//assume that the argument is not null
public Node treeSuccessor (Node node)
{
	if(!node.hasRealRightSon()&&node.getRightSon()!=null)
	{
		return node.getRightSon(); //there is a wire to it's Successor
	}
	Node check = node;
	if(check.hasRealRightSon())
	      return check.getRightSon().getMinimum();
	else
	{
		Node p = check.getParent();
	   while(p!=null&&p.getRightSon()==check)
	   {
	          check=p;
	          p=p.getParent();
		
	   }
	   
	   return p; //returns null if node is the maximum
	
		
	}
	
}
/**
 * find the predecessor of given node.
 * @param node the node that we search the predecessor of
 * @return a pointer to the predecessor of the given node.
 * returns null if the given node is the minimum
 */
//assume that the argument is not null
public Node treePredecessor (Node node)
{
	if(!node.hasRealLeftSon()&&node.getLeftSon()!=null)
	{
		return node.getLeftSon(); //there is a wire to it's Predecessor
	}
	Node check = node;
	if(check.hasRealLeftSon())
	      return check.getLeftSon().getMaximum();
	else
	{
		Node p = check.getParent();
	   while(p!=null&&p.getLeftSon()==check) //while check is a left son
	{
	          check=p;
	          p=p.getParent();
		
	}
	   return p; //returns null if node is the minimum
		
	}
}
/**
 * searches for a given node in binary threaded search tree
 * @param node the node we looking for.
 * @returns return pointer to node in the tree which have the same key. 
 * return null if the node is'nt in the tree
 */
public Node BWSTsearch (Node node)
{
	Node temp = this.root;
	
	while (!temp.isLeaf())
	{
		if (temp.getStudentNo()==node.getStudentNo())
			return temp;
		else
		{
			if (node.getStudentNo()<temp.getStudentNo())
			{
				if (temp.hasRealLeftSon())
					temp=temp.getLeftSon();
				else 
				{
					System.out.println("the searched node is not in the tree, returns null" );
					return null;
				}			
			}
			if (node.getStudentNo()>temp.getStudentNo())
			{
				if (temp.hasRealRightSon())
					temp=temp.getRightSon();
				else
				{
					System.out.println("the searched node is not in the tree, returns null" );
					return null;
				}
			}
			
	    }	 	
	}//close while
	if (temp.getStudentNo()==node.getStudentNo())
		return temp;
	else
	{
		System.out.println("the searched node is not in the tree, returns null" );
	    return null ; 
	}
	
	
}

	/**
	 * inserts a new node to the threaded binary search tree.
	 * assume the all the keys are different and we do'nt insert null values. 
	 * @param node the node to be inserted.
	 */
	public void Insert (Node node) 
	{
         Node temp = this.root;
        if(root==null)
        {
        	this.root = node;
        	this.median = node;
        	node.setLeftSon(null);
			node.setRightSon(null);
			node.setParent(null);
			this.countDef = 0; 
		   
        }
        	
         else
         {
        	 while (temp.getStudentNo() > node.getStudentNo() && temp.hasRealLeftSon() || temp.getStudentNo() < node.getStudentNo() && temp.hasRealRightSon())
    		 {
    			 if (temp.getStudentNo() > node.getStudentNo())
    			      temp=temp.getLeftSon();

    			   else
    			        if (temp.getStudentNo()< node.getStudentNo())
    			           temp=temp.getRightSon();
    					   
    		 }
         
		 if (node.getStudentNo() > temp.getStudentNo() )
		 {
             temp.setRightSon(node);
             
		 }

			else 
			{
			    temp.setLeftSon(node);

			}
		 
		    node.setParent(temp);
            node.setLeftSon(this.treePredecessor(node));
			node.setRightSon(this.treeSuccessor(node));
			if(node.getStudentNo()>this.median.getStudentNo())
				this.countDef ++;
			else 
				this.countDef--;
			
		    this.SetMedian();
         }  
	}
	/**
	 * deletes a given node from the tree
	 * @param delNode the node to be deleted
	 */
	public void Delete ( Node delNode)
	{
		boolean med=false; 
		/*
		 * median deletion 
		 */
		if(delNode.getStudentNo()==this.getMedian().getStudentNo()) //check if delNode is the median
		{
			med=true;
			if(countDef==1)  //check is delNode is the lower median or there is just one median in the tree.
			{
				this.median=this.treeSuccessor(this.median);
				countDef=0;
			}
			else
			{
				this.median=this.treePredecessor(this.median);
				countDef=1;
			}
				
		}
		
		// key is found in tree. check between 3 cases
		// case 1 : delNode is a leaf
	      if (delNode.isLeaf())
	        { 

	    	  delLeaf(delNode);
			}
	      else 
	      {	  
	    	   //case 2 : delNode  has 2 children 
	    	  if(delNode.hasRealLeftSon() && delNode.hasRealRightSon())
				{
					/*
					 * delete delNode's successor,
					 * and switch delNodes key and data with the key and data of its successor 
					 */
					delParentOfTwo(delNode);
				}
	    	  else 
				{
	    		    //case 3: delNode has just one son.
					delParentOfOne(delNode);
				}
		 					
	      }			
			// median changes
			if(med==false)
			{
				if(delNode.getStudentNo()>this.getMedian().getStudentNo())
					countDef--;
				else
					countDef++;
				SetMedian();
			}
	}
	

	// if to Delete a leaf , change delNodes parent so that his left/right son is his predecessor/successor
	private void delLeaf (Node delNode)
	{
		Node p = delNode.getParent();
		if(delNode.isLeftSon())
		{
			/*
			 * delNode is left son leaf
			 * in this case the successor of delNode is it's parent.
			 * we know that we have wire to the predecessor of delNode (if he exists) so we can get him in O(1) time complexity.
			 * delNode is a leaf so he has'nt left subtree so it's predecessor is the lowest kadmon parent of delNode
			 *  wich it's right son is olso kadmon parent of delNode so we know that 
			 *  the predecessor of delNode has'nt wire to delNode. he has real right son 
			 */
			p.setLeftSon(treePredecessor(delNode)); //O(1) time complexity.
			delNode.setParent(null);			

		}
		else
		{
			/*
			 * delNode is is right son leaf
			 * in this case the predecessor of delNode is it's parent.
			 * we know that we have wire to the Successor of delNode (if he exists) so we can get him in O(1) time complexity.
			 * delNode is a leaf so he has'nt right subtree so it's Successor is the lowest kadmon parent of delNode
			 * wich it's left son is olso kadmon parent of delNode so we know that 
			 * so the Successor of delNode has'nt wire to delNode. he has real left son 
			 */
			p.setRightSon(treeSuccessor(delNode)); //O(1) time complexity.
			delNode.setParent(null);
			
			
		}
		
	}
	
	private void delParentOfOne (Node delNode)
	{
		Node p = delNode.getParent();
		Node temp;
		if (delNode.hasRealRightSon())
		{
		/*
		 * the predecessor of delNode have real right son
		 * therefore there is no node wich have left wire to delNode
		 */
			temp = this.treeSuccessor(delNode);
			if (p!=null)
			{
				if(delNode.isLeftSon())
					p.setLeftSon(delNode.getRightSon());
				else
				p.setRightSon(delNode.getRightSon()); //delNode is right son
			}
			delNode.getRightSon().setParent(p);
			/* notice that the successor of delNode has left wire to delNode
			 * because delNode has real left son so his successor is in it's right subtree 
			 * we will change this wire to delNode's left son wich is the predecessor of delNode.
			 */
            temp.setLeftSon(delNode.getLeftSon());	
		}
		else
		{
			/* in this case delNode has real left son so the successor of delNode has real left son
			 * therefore there is no node wich have right wire to delNode
			 */
			temp = this.treePredecessor(delNode);
			if (p!=null)
			{
				if(delNode.isLeftSon())
					p.setLeftSon(delNode.getLeftSon());
				else
				p.setRightSon(delNode.getLeftSon()); //delNode id right son
			}		
			delNode.getLeftSon().setParent(p);
			/* notice that the predecessor of delNode have right wire to delNode
			 * and he is in the left subtree of delNode because delNode have real left son
			 * we will change this wire to point on delNode's right son wich is the successor of delNode 
			 */
		    temp.setRightSon(delNode.getRightSon());
			
		}
	}
	private void delParentOfTwo(Node delNode)
	{
		/*
		 * Case 2 of deletion:
		 * and switch delNodes key and data with the key and data of its successor 
		 * delete delNodes successor (the successor has'nt left son).
		 */
		Node temp = new Node(); // temp Node to switch between delNode and its successor
		Node succ = treeSuccessor(delNode); 
		temp.setStudentNo(succ.getStudentNo());
		temp.setStudentName(succ.getStudentName()); 
		if(succ.isLeaf()) //if some node have two real child. his successor has'nt left child
			delLeaf(succ);
		else  
			delParentOfOne(succ);
		delNode.setStudentNo(temp.getStudentNo());
		delNode.setStudentName(temp.getStudentName());
	}
	
	
	/**
	 * prints all the students numbers in sorted order according to student number
	 * (inorder traversal)
	 */
	//stop printing after we got to the maximum, the maximum has'nt successor.
	public void printInorder()
    {
		Node temp = this.root.getMinimum();
		while (temp!=null)
		{
			System.out.println("studentNo " + temp.getStudentNo());
			if (temp.hasRealRightSon())
				temp=temp.getRightSon().getMinimum();
			else
				temp=temp.getRightSon();			
		}
       
    }
	/**
	 * 
	 * prints all the keys in postorder traversal
	 */
	public void printPostorder()
    {
		Node temp;
        if (this.root==null)
        {
        	System.out.println("the tree is empty");      	
        }
        else 
        {
        	temp=this.root;
        	this.printPostorder(temp);
        }
        	
        	
        
    }
	
	private void printPostorder(Node node)
	{
		if(node.hasRealLeftSon())
            printPostorder(node.getLeftSon());
		if (node.hasRealRightSon())	
			printPostorder(node.getRightSon());	
		System.out.println("the StudentNo is: "+node.getStudentNo());
		
	}
	
	/**
	 * print the key's in preorder traversal
	 */
	public void printPreorder()
    {
		Node temp;
        if (this.root==null)
        {
        	System.out.println("the tree is empty");      	
        }
        else 
        {
        	temp=this.root;
        	this.printPreorder(temp);
        }
    }
	
	private void printPreorder(Node node)
	{
			System.out.println("the StudentNo is: "+node.getStudentNo());
			if(node.hasRealLeftSon())
                printPreorder(node.getLeftSon());
			if (node.hasRealRightSon())	
				printPreorder(node.getRightSon());	
			
    }
	
}

