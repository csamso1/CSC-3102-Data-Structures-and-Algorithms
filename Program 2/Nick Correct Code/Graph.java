/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2;

/**
 *
 * @author Nicholas Dugal
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Hashtable;
import java.util.function.BiConsumer;


public class Graph 
{
                public static Hashtable<Character, LinkedList> nodes = new Hashtable<Character, LinkedList>();
	public void addNode(Node n)
	{
            nodes.put(n.label, new LinkedList<Node>());
                System.out.println(n.label + "added");
	}
        public void add(Node node1, Node node2) {
                nodes.putIfAbsent(node1.label, new LinkedList<Node>());
                nodes.putIfAbsent(node2.label, new LinkedList<Node>());
                connectNode(node1, node2);
        }
        
	
	//This method will be called to make connect two nodes
	public void connectNode(Node start,Node end)
	{
		LinkedList<Node> newList = nodes.get(start.label);
                newList.add(end);
                nodes.replace(start.label, newList);
	}
        
        public void disconnectNode(Node start, Node end)
        {
                LinkedList<Node> newList = nodes.get(start.label);
                newList.remove(end);
                nodes.replace(start.label, newList);
                
        }

	
	private Node getUnvisitedChildNode(Character n)
	{
		LinkedList<Node> children = nodes.get(n);
                for (Node child : children) {
                    if (child.visited == false) {
                        return child;
                    }
                }
                return null;
	}
	
	//BFS traversal of a tree is performed by the bfs() function
	public void bfs(Character key)
	{
		//BFS uses Queue data structure
		Queue q=new LinkedList();
		q.add(key);
		System.out.print(key + " ");
                visited(key);
		while(!q.isEmpty())
		{
			char n = (Character)q.remove();
			Node child=null;
                        LinkedList<Node> weightList = new LinkedList();
			while((child=getUnvisitedChildNode(n))!=null)
			{
				visited(child.label);
				System.out.print(child.label + " ");
				q.add(child.label);
                                weightList.add(child);
			}
                        }
		//Clear visited property of nodes
		clearNodes();
	}
        
	//DFS traversal of a tree is performed by the dfs() function
	public void dfs(Character label)
	{
		//DFS uses Stack data structure
		Stack<Character> s=new Stack();
		s.push(label);
                visited(label);
		while(!s.isEmpty())
		{
			Character n = (Character)s.pop();
                        System.out.print(n + " ");
			Node child = null;
                         while((child = getUnvisitedChildNode(n)) != null)
			{
				visited(child.label);
				//printNode(child);
				s.push(child.label);
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	
	//Utility methods for clearing visited property of node
	private void clearNodes()
	{
            BiConsumer<? super Character,? super LinkedList<Node>> func = (label, connections) -> {
              for (Node node : connections) {
                  node.visited = false;
              }  
            };
            nodes.forEach((BiConsumer<? super Character, ? super LinkedList>) func);
	}
        
        private void visited(Character key) {
            BiConsumer<? super Character,? super LinkedList<Node>> func = (label, connections) -> {
              for (Node child : connections) {
                  if (child.label == key)
                      child.visited = true;
              }  
            };
            nodes.forEach((BiConsumer<? super Character, ? super LinkedList>) func);
        }

}
