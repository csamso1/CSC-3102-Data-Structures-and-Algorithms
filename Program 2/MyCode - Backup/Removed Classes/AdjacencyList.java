/**
 * @author csamso1
 * csamso1@lsu.edu
 * Prog2 Graph Traversal
 */
package prog2;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class AdjacencyList<Vertex> {
    
/** Vector<Vertex> of graph verticies */
//    private LinkedList<Vertex> verticies;
    
//    public AdjacencyList(){
//        LinkedList<Vertex> g = new LinkedList<Vertex>();
//    }
    
    LinkedList<Vertex> g;
    
    /**
     * 
     * @param v
     * @return 
     */
    public boolean addVertex(Vertex v){
        if(g.contains(v) == false)
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
        if(g.contains(x) == false){
            System.out.printf("Error: from vertex is not in the graph. %n");
            return false;
        }
        
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
            g.(i).visited = false;
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
        for(int i = 0; i < verticies.size(); i++){
            verticies.get(i).visited = false;
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