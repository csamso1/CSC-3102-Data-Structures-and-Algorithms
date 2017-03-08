/**
 * @author csamso1
 * csamso1@lsu.edu
 * Prog2 Graph Traversal
 */
package prog2;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class AdjacencyList {
    
    public class Vertex{
        char label;
        LinkedList<Vertex> adjacent;
        boolean visited;
        
        public Vertex(char l){
            label = (char)l;
            adjacent = null;
            visited = false;
        }
    }
    
    LinkedList<Vertex> g;
    
    /**
     * 
     * @param v
     * @return 
     */
    public boolean addVertex(Vertex v){
        if(g.contains(v))
            return false;
        g.add(v);
        return true;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public boolean addEdge(Vertex x, Vertex y){
        if(x.adjacent.contains(y))
            return false;
        x.adjacent.add(y);
        return true;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public boolean removeEdge(Vertex x, Vertex y){
        if(x.adjacent.contains(y))
            return false;
        x.adjacent.remove(y);
        return true;
    }
    
    public void depthTraversal(Vertex v){
        for(int i = 0; i < g.size(); i++){
            g.get(i).visited = false;
        }
        Stack s = new Stack();
        s.add(v);
        while(s.size() > 1){
            System.out.printf("%s", v.label);
            v.visited = true;
            for(int j = 0; j < v.adjacent.size()-1; j++){
                if(g.get(j).visited == false)
                    s.add(j);
            }
        }
    }
    
    public void breadthTraversal(Vertex v){
        for(int i = 0; i < g.size(); i++){
            g.get(i).visited = false;
        }
        Queue q = new LinkedList();
        q.add(v);
        while(q.size() > 1){
            System.out.printf("%s", v.label);
            v.visited = true;
            for(int j = 0; j < v.adjacent.size()-1; j++){
                if(g.get(j).visited == false)
                    q.add(j);
            }
        }
    }
}