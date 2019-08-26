package maman16;
 

public class Node {
	private Node leftSon ;
	private Node rightSon ;
	private Node parent ;
	private int studentNo;
	private String studentName;
	/**
	 * constructs a new Node, with the given values
	 * @param leftSon the left son of the Node
	 * @param rightSon the right son of the Node
	 * @param parent the parent of the Node
	 * @param studentNo the Student Number value of the Node
	 * @param studentName  the Student Name value of the Node
	 */
	public Node (Node leftSon, Node rightSon ,Node parent, int studentNo,String studentName)
	{
		this.leftSon = leftSon;
		this.rightSon = rightSon;
		this.parent = parent;
		this.studentNo =studentNo;
		this.studentName =studentName;
	}
	/**
	 * construct a new empty Node
	 * Initiolaize the Student Number to zero
	 * 
	 */
	public Node ()
	{
		leftSon = null;
		rightSon = null;
		parent = null;
		studentNo =0;
		studentName =null;
	}
	/**
	 * returns a pointer to the Left son of the Node
	 * @return the leftSon of the Node
	 * 
	 */
	public Node getLeftSon() {
		return leftSon;
	}
	/**
	 * Set the left son of the Node to a given Node
	 * @param leftSon is the new left son of the Node
	 */
	public void setLeftSon(Node leftSon) {
		this.leftSon = leftSon;
	}
	/**
	 * returns a pointer to the right son of the Node
	 * @return the rightSon
	 */
	public Node getRightSon() {
		return rightSon;
	}
	/**
	 * Set the right son of the Node to a given Node
	 * @param rightSon is the new right son of the Node
	 */
	public void setRightSon(Node rightSon) {
		this.rightSon = rightSon;
	}
	/**
	 * returns a pointer to the parent of the Node
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}
	/**
	 * Set the parent of the Node to a given Node
	 * @param parent is the new parent of the Node
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	/**
	 * @return returns the studentNo
	 */
	public int getStudentNo() {
		return studentNo;
	}
	/**
	 * set the studentNo to a given value
	 * @param studentNo the new value
	 */
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	
	/**
	 * returns the student name of this Node
	 * @return returns the student name of this Node
	 */
	public String getStudentName()
	{
		return studentName;
	}
    /**
     * set the StudentName to a given value
     * @param studentName the new value 
     */
	public void setStudentName (String studentName) 
	{
		this.studentName = studentName;
	}
	
	

/**
 * checks if the left son of a given Node is real or a thread
 * @return returns true if this node has real left son
 */
	
	public boolean hasRealLeftSon ()
	{
		if (leftSon!=null && leftSon.getParent()==this)
					return true;
		else 
			
			return false;
	}
	

	/**
	 * checks if the right son of a given Node is real or a thread
	 * @return returns true if this node has real right son
	 */
	
	public boolean hasRealRightSon ()
	{
		if (rightSon!=null && rightSon.getParent()==this)
					return true;
		else 
			return false;
	}
	
	/**
	 * checks if the given Node is a leaf 
	 * @return returns True if the Node is a leaf and false otherwise
	 */
	
	public boolean isLeaf ()
	{
		if (hasRealLeftSon()==false&&(hasRealRightSon()==false))
					return true;
		else 
			return false;
		
	
	}
/**
 * checks if this Node is a left son
 * @return 	  returns True if the given Node is a right son to its parent
 */
	public boolean isLeftSon ()
	{

		if(this.getParent() != null && this.getParent().getLeftSon()==this)
			return true;
		else 
			return false;
	}
	
	/**
	 * returns the local minimum of the subtree
	 * @return returns the local minimum of the subtree
	 */
	public Node getMinimum ()
	{

	Node check = this;
	while(check.hasRealLeftSon()) 
	{
		check = check.getLeftSon();
	}
    return check;
	}

	
	/**
	 * returns the local maximum of the subtree
	 * @return returns the local maximum of the subtree
	 */
	public Node getMaximum ()
	{
		Node check = this;
		while(check.hasRealRightSon()) 
		{
			check = check.getRightSon();
		}
	    return check;
	}
	
	
}

