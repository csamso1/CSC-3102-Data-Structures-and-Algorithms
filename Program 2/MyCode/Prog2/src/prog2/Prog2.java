/**
 * @author csamso1
 * csamso1@lsu.edu
 * Prog2 Graph Traversal
 */
package prog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prog2 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        String command;
        String xString;
        String yString;
        char x;
        char y;
        Graph graph = new Graph();
        while(input.hasNextLine()){
            command = input.next();
            if(command.equalsIgnoreCase("add")){
                xString = input.next();
                x = xString.charAt(0);
                yString = input.next();
                y = yString.charAt(0);
                Vertex v1 = new Vertex(x);
                Vertex v2 = new Vertex(y);
                graph.addVertex(v1);
                graph.addVertex(v2);
                graph.addEdge(v1,v2);
            }
            if(command.equalsIgnoreCase("remove")){
                xString = input.next();
                x = xString.charAt(0);
                yString = input.next();
                y = yString.charAt(0);
                Vertex v1 = new Vertex(x);
                Vertex v2 = new Vertex(y);
                graph.removeEdge(v1, v2);
            }    
            if(command.equalsIgnoreCase("breadth")){
                xString = input.next();
                x = xString.charAt(0);
                Vertex v1 = new Vertex(x);
                graph.breadthTraverse(v1);
            }
            if(command.equalsIgnoreCase("depth")){
                xString = input.next();
                x = xString.charAt(0);
                Vertex v1 = new Vertex(x);
                graph.depthTraverse(v1);
            }
        }
    }
}