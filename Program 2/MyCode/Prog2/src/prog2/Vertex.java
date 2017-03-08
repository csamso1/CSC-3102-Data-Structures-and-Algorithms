/**
 * @author csamso1
 * csamso1@lsu.edu
 * Prog2 Graph Traversal
 */
package prog2;

import java.util.ArrayList;

public class Vertex {
    public char label;
    public ArrayList<Integer> adjacent = new ArrayList<Integer>();
    public boolean visited = false;
    public int weight;
    public Vertex(char l){
        this.label = l;
    }
    
//    public boolean contains(Vertex v){
////        for(Vertex vertex : v.adjacent){
////            if(v.adjacent.get();)
////        }
//    for (Vertex vertex : this.adjacent) {
//        if (vertex.label == v.label) {
//            return true;
//        }
//    }
//        return false;
//    }
}
