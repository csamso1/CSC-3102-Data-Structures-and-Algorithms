/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2;

/**
 *
 * @author nickdugal
 */
import java.util.*;
import java.io.*;

public class Prog2 {

    /**
     * @param args the command line arguments
     */
    public static Graph g = new Graph();
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("input.txt"));
        String input;
        String[] inputAr;
        String inputType;
        LinkedList<Character> added = new LinkedList();
        
      while (in.hasNextLine()) {
          input = in.nextLine();
          inputAr = input.split(" ");
          inputType = inputAr[0];
          int idx1 = 0;
          int idx2 = 0;
          char first = inputAr[1].charAt(0);
          
          if (inputType.equals("add")) {
              char second = inputAr[2].charAt(0);
              if (added.contains(first)) {
                  idx1 = added.indexOf(first);
              } else {
                  g.addNode(new Node(first));
                  added.add(first);
                  idx1 = g.nodes.size()-1;
              }
              if (added.contains(second)) {
                  idx2 = added.indexOf(second);
              } else {
                  g.addNode(new Node(second));
                  added.add(second);
                  idx2 = g.nodes.size()-1;
              }
              g.connectNode(new Node(first), new Node(second));
              System.out.println("Connected " + first + " to " + second);
          }
          if (inputType.equals("breadth")) {
              System.out.println("\nBreadth of " + inputAr[1].charAt(0));
              g.bfs(inputAr[1].charAt(0));

          }
          if (inputType.equals("depth")) {
             System.out.println("\nDepth of " + inputAr[1].charAt(0));
              g.dfs(inputAr[1].charAt(0));
          }
          if (inputType.equals("remove")) {
              char second = inputAr[2].charAt(0);
              g.disconnectNode(new Node(first), new Node(second));
              System.out.println("Removed connection from " + first + " to " + second);
          }
      }
        }

}
