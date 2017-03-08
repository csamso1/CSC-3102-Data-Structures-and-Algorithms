/**
 * @author csamso1
 * csamso1@lsu.edu
 * Prog2 Graph Traversal
 */
package prog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import prog2.AdjacencyList.Vertex;

public class Prog2 {
    
//    public class AdjacencyList {
//    
//    public class Vertex{
//        char label;
//        LinkedList<Vertex> adjacent;
//        boolean visited;
//    }
//    
//    LinkedList<Vertex> g;
//    
//    /**
//     * 
//     * @param v
//     * @return 
//     */
//    public boolean addVertex(Vertex v){
//        if(g.contains(v))
//            return false;
//        g.add(v);
//        return true;
//    }
//    
//    /**
//     * 
//     * @param x
//     * @param y
//     * @return 
//     */
//    public boolean addEdge(Vertex x, Vertex y){
//        if(x.adjacent.contains(y))
//            return false;
//        x.adjacent.add(y);
//        return true;
//    }
//    
//    /**
//     * 
//     * @param x
//     * @param y
//     * @return 
//     */
//    public boolean removeEdge(Vertex x, Vertex y){
//        if(x.adjacent.contains(y))
//            return false;
//        x.adjacent.remove(y);
//        return true;
//    }
//    
//    public void depthTraversal(Vertex v){
//        for(int i = 0; i < g.size(); i++){
//            g.get(i).visited = false;
//        }
//        Stack s = new Stack();
//        s.add(v);
//        while(s.size() > 1){
//            System.out.printf("%s", v.label);
//            v.visited = true;
//            for(int j = 0; j < v.adjacent.size()-1; j++){
//                if(g.get(j).visited == false)
//                    s.add(j);
//            }
//        }
//    }
//    
//    public void breadthTraversal(Vertex v){
//        for(int i = 0; i < g.size(); i++){
//            g.get(i).visited = false;
//        }
//        Queue q = new LinkedList();
//        q.add(v);
//        while(q.size() > 1){
//            System.out.printf("%s", v.label);
//            v.visited = true;
//            for(int j = 0; j < v.adjacent.size()-1; j++){
//                if(g.get(j).visited == false)
//                    q.add(j);
//            }
//        }
//    }
//}
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        String command;
        String xString = null;
        String yString = null;
        char x;
        char y;
        AdjacencyList graph = new AdjacencyList();
        
        while(input.hasNextLine()){
            command = input.next();
            if(command.equalsIgnoreCase("add")){
                xString = input.next();
                x = xString.charAt(0);
                yString = input.next();
                y = yString.charAt(0);
                Vertex v1;
                v1 = new Vertex(x);
                v1.label = x;
                Vertex v2 = null;
                v2.label = y;
                graph.addVertex(v1);
                graph.addVertex(v2);
                graph.addEdge(v1, v2);
            }
            if(command.equalsIgnoreCase("remove")){
                xString = input.next();
                x = xString.charAt(0);
                yString = input.next();
                y = yString.charAt(0);
                Vertex v1 = null;
                v1.label = x;
                Vertex v2 = null;
                v2.label = y;
                graph.removeEdge(v1, v2);
            }    
            if(command.equalsIgnoreCase("breadth")){
                xString = input.next();
                x = xString.charAt(0);
                Vertex v1 = null;
                v1.label = x;
                graph.breadthTraversal(v1);
            }
            if(command.equalsIgnoreCase("depth")){
                xString = input.next();
                x = xString.charAt(0);
                Vertex v1 = null;
                v1.label = x;
                graph.depthTraversal(v1);
            }
        }
    }
}