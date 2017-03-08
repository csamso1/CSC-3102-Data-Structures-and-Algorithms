/**
 * CSC 3102 - Advanced Data Structures and Algorithm Analysis
 * Dr. Kooima
 * Programming Project 2
 * 28 April 2016
 * @author seanmarino
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Graph 
{   
	public Node rootNode;
	public ArrayList nodes=new ArrayList();
	public int[][] adjMatrix;
	int size;
	public void setRootNode(Node n)
	{
		this.rootNode=n;
	}
	
	public Node getRootNode()
	{
		return this.rootNode;
	}
	
	public void addNode(Node n)
	{
		nodes.add(n);
	}
        //Ensure that vertices with label X and Y are present in the graph
        //and add a directed edge from X to Y
	public void addNodes(Node start,Node end)
	{
		if(adjMatrix==null)
		{
			size=nodes.size();
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1;
		adjMatrix[endIndex][startIndex]=1;
	}
        //Removes the edge from X to Y. Don't worry about
        //removing any associated vertices.
        public void removeNodes(Node start, Node end)
        {
                if(adjMatrix==null){
			size=nodes.size();
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
                adjMatrix[endIndex][startIndex]=0;
		adjMatrix[startIndex][endIndex]=0;
        }
	private Node getChildNode(Node n)
	{
		int index=nodes.indexOf(n);
		int j=0;
		while(j<size)
		{
			if(adjMatrix[index][j]==1 && ((Node)nodes.get(j)).visited==false)
			{
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}
        // Breadth First Search Method
        // Prints a breadth-first traversal of the graph beginning
        // at the vertex labeled X.
	public void breadth()
	{
		Queue q=new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited=true;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			while((child=getChildNode(n))!=null)
			{
				child.visited=true;
				printNode(child);
				q.add(child);
			}
		}
		clearNodes();
	}
        // Depth First Search Method
        // Print a depth-first traversal of the graph beginning at
        // the vertex labeled X.
	public void depth()
	{
		Stack s=new Stack();
		s.push(this.rootNode);
		rootNode.visited=true;
		printNode(rootNode);
		while(!s.isEmpty())
		{
			Node n=(Node)s.peek();
			Node child=getChildNode(n);
			if(child!=null)
			{
				child.visited=true;
				printNode(child);
				s.push(child);
			}
			else
			{
				s.pop();
			}
		}
		clearNodes();
	}	
	//Clears visited Nodes
	private void clearNodes()
	{
		int i=0;
		while(i<size)
		{
			Node n=(Node)nodes.get(i);
			n.visited=false;
			i++;
		}
	}
        // Prints the Nodes
	private void printNode(Node n)
	{
		System.out.print(n.character+" ");
	}
	static {
        }
        
    public static void main(String[] args) throws FileNotFoundException
    {
        Graph m = new Graph();
        FileInputStream input = new FileInputStream("input.txt");
        Scanner scan = new Scanner(input);
        
                        while (scan.hasNext())
                        {
                            String line = scan.next();
                            if (line.equals("add"))
                            {
                                String line0 = scan.next();
                                char L = line0.charAt(0);
                                Node nA = new Node(L);
                                m.addNode(nA);
                                String line1 = scan.next();
                                char K = line1.charAt(0);
                                Node nB = new Node(K);
                                m.addNode(nB);
                                System.out.println(nA.character);
                            }
                            else if (line.equals("breadth"))
                            {
                                line = scan.next();
                                char L = line.charAt(0);
                                Node nA = new Node(L);
                                m.setRootNode(nA);
                                m.breadth();
                            }
                            else if (line.equals("depth"))
                            {
                                line = scan.next();
                                char L = line.charAt(0);
                                Node nA = new Node(L);
                                m.setRootNode(nA);
                                m.breadth();
                            }
                        }
            }
}
