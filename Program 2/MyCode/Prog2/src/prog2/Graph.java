/**
 * @author csamso1
 * csamso1@lsu.edu
 * Prog2 Graph Traversal
 */
package prog2;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Graph {
    public Vertex rootVertex;
    public ArrayList<Vertex> verticies = new ArrayList();
    public static int weight = 0;
    
    public void addVertex(Vertex v){
        v.weight = weight++;
        verticies.add(v);
//        System.out.println(v.label + " added");
    }
    
    public int findVertex(char c){
        for(Vertex vertex : verticies){
            if(vertex.label == c){
//                System.out.printf("Vertex with char %s found at index %d %n", vertex.label, verticies.indexOf(vertex));
                return verticies.indexOf(vertex);
            }            
        }
        System.out.printf("vertex not found. %n");
        return -1;
    }
    
    public void addEdge(Vertex from, Vertex to){

        int vertexIndex = findVertex(to.label);
        if(vertexIndex > 0){
            from.adjacent.add(vertexIndex);
//            System.out.printf("Edge added from %s to %s %n", from.label, to.label);
        }
//        else
//            System.out.printf("destination vertex does not exsist. %n");
    }
    
    public void removeEdge(Vertex from, Vertex to){
        from.adjacent.remove(findVertex(to.label));
//        System.out.printf("Edge from %s to %s does not exists. %n", from.label, to.label);
    }
    
    public void depthTraverse(Vertex start){
        for(Vertex vertex : verticies){
            vertex.visited = false;
        }
        Stack<Vertex> s = new Stack();
        s.add(start);
        while(!s.isEmpty()){
            Vertex v = s.pop();
            v.visited = true;
            System.out.printf("%s", v.label);
            for(int index : v.adjacent){
                Vertex w = s.pop();
                if(w.visited == false)
                    s.add(w);
            }
        }
    }
    
    public void breadthTraverse(Vertex start){
        for(Vertex vertex : verticies){
            vertex.visited = false;
        }
        Queue<Vertex> q = new LinkedList();
        q.add(start);
        while(!q.isEmpty()){
            Vertex v = q.poll();
            v.visited = true;
            for(int index : v.adjacent){
                Vertex w = q.poll();
                if(w.visited == false)
                    q.add(w);
            }
        }
    }
}