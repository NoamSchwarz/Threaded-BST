package maman16;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.lang.*;

public class BuildTreeFromInput {
	public static void main(String args[]) throws Exception
	{ 
		
		Scanner sc = new Scanner(System.in);  
		BinarySearchTree tree = new BinarySearchTree();
		
		System.out.println("Welcome to Threaded Binary Tree Build. All Student Numbers must be different.");
		System.out.println("Enter 1 for text file input, 0 for manual input or 2 for examples of input and output");
		
		int decision =sc.nextInt();
		
		if(decision == 1)
		{
			System.out.println("you have chosen input form text. The data in the file must be in the following format:");
			System.out.println("StudentNo, StudentName");
			System.out.println("enter the location and name of your file. Example of location format:");			
			System.out.println("C:/Users/noamn/Desktop/BST.txt");
			
		
			String fileLocation = sc.next(); 
			FileReader file = new FileReader(fileLocation);
			BufferedReader reader = new BufferedReader(file);
			
			String line = reader.readLine();
						
			while(line != null)
			{							
			
				String delimiter = ",";
				String lineArray[] = line.split(delimiter);
				
				int StudentNum = Integer.parseInt(lineArray[0]);
				Node newNode = new Node();
				newNode.setStudentNo(StudentNum);
				newNode.setStudentName(lineArray[1]);
				
				tree.Insert(newNode); 
				
				line = reader.readLine();
		
			}
			System.out.println("the insertion end successfully "+"\n"+"inorder traversal:");
			  tree.printInorder();
		}
		
		if(decision == 0)
		{
			System.out.println("you have chosen manual data entry. ");
			System.out.println("Please enter one Student Number, press enter, enter one Student Name, and press enter for next entry.");
			System.out.println("Repeat this for each student entry.");
			System.out.println("To finish entering, enter the number -1");
			int newStudentNo = 0;
			String newStudentName;	
			
			
			   while(newStudentNo != -1) 
			   {
				   //if there is time, add test for incorrect entries
				   System.out.println("Enter a Student Number:");

	
					  newStudentNo = sc.nextInt();
						
					   if(newStudentNo == -1)
						   break;
					   else
					   {
						   System.out.println("Enter a Student Name:");			   
						   newStudentName=sc.next();  
						   
						   Node newNode = new Node();
						   newNode.setStudentName(newStudentName);
						   newNode.setStudentNo(newStudentNo);
						   
						   tree.Insert(newNode);
						   
					   }
				   }
			   System.out.println("the insertion end successfully "+"\n"+"inorder traversal:");
				  tree.printInorder();		   		
			   }
		  
		if(decision==2)
		{
			 Node node1 = new Node ();
				node1.setStudentNo(1);
				Node node2 = new Node ();
				node2.setStudentNo(2);
				Node node3 = new Node ();
				node3.setStudentNo(3);
				Node node4 = new Node ();
				node4.setStudentNo(4);
				Node node5 = new Node ();
				node5.setStudentNo(5);
				Node node6 = new Node ();
				node6.setStudentNo(6);
				Node node7 = new Node ();
				node7.setStudentNo(7);
				Node node8 = new Node ();
				node8.setStudentNo(8);
				Node node9 = new Node ();
				node9.setStudentNo(9);
				Node node10=new Node ();
				node10.setStudentNo(10);
		    tree.Insert(node2);
			tree.Insert(node5);
			tree.Insert(node8);
			tree.Insert(node3);
			tree.Insert(node7);
			tree.Insert(node1);
			tree.Insert(node4);
			tree.Insert(node9);
			tree.Insert(node6);

			System.out.println("search for node9 "+tree.BWSTsearch(node9).getStudentNo());
			System.out.println(tree.BWSTsearch(node10));
			System.out.println("PostOrder Travers: ");
			tree.printPostorder();
			System.out.println("Inorder Travers: ");
			tree.printInorder();
			System.out.println("Preorder Travers: ");
			tree.printPreorder();
			System.out.println("the median of the tree is: "+tree.getMedian().getStudentNo());
			System.out.println("delete node5");
			tree.Delete(node5);
			System.out.println("the median of the tree is: "+tree.getMedian().getStudentNo());
			System.out.println("delete node3");
			tree.Delete(node3);
			System.out.println("the median of the tree is: "+tree.getMedian().getStudentNo());
			System.out.println("Inorder Travers: ");
			tree.printInorder();
			System.out.println("insert node3 again");
			tree.Insert(node3);
			System.out.println("the maximoum of the tree is: "+tree.treeMaximum().getStudentNo());
			System.out.println("the minimum of the tree is: "+tree.treeMinimum().getStudentNo());
			System.out.println("the successor of node4 is: "+tree.treeSuccessor(node4).getStudentNo());
			System.out.println("the peedecessor of node4 is " +tree.treePredecessor(node4).getStudentNo());
			System.out.println("the median of the tree is: "+tree.getMedian().getStudentNo());
		}
}
}
