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
public class Node 
{
            public char label;
            public int weight;
            public boolean visited=false;
            public Node(char l)
            {
                this.label=l;
            }
}

