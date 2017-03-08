/**
 * @author Clayton Samson
 * csamso1@lsu.edu
 * CSC 3102 Program 1
 */
package prog1;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Prog1
{
    private char[] heap = new char[255];
    private int size = 0;
    
    //reads through an array of characters
    public Prog1(String args)
    {
        try
        {
            Scanner scan = new Scanner(new File(args));
            size = 0;
            String inputData = scan.next();
            char[] charArray = inputData.toCharArray();
            System.out.println(Arrays.toString(charArray));
            heap[size] = charArray[0];
            size++;
            for(int i = 0; i < charArray.length; i++)
            {
                if(charArray[i] != '!')
                {
                    insert(charArray[i]);
                }
                else
                {
                    System.out.print(heap[0]);
                    remove();
                }
            }
        } catch(FileNotFoundException e)
        {
            System.out.print("File not found.");
        }
    }
    
    /**
     * returns the size of the heap
     * @return the size of this heap
     */
    public int size()
    {
        return size;
    }
    
    /**
     * eliminates all elements and sets the array to size 0
     */
    public void clear()
    {
        if(size > 0)
        {
            for(int i = 0; i < size -1; i++)
            {
                heap[i] = '\0';
            }
            size = 0;
        }
    }
    
    /**
     * appends an element a to the end of the array (regardless of the heap 
     * order property)
     * @param a the character to append
     */
    public void append(char a)
    {
        heap[size - 1] = a;
        size++;
    }
    
    /**
     * confirms that the array satisfies the heap order property and returns 
     * true or false
     * @return true if the array satisfies the heap order property
     */
    public boolean check()
    {
        for(int i = 0; i > size - 1; i++)
        {
            if(heap[i] > heap[(2*i)+1] || heap[i] > heap[(2*i) + 1])
                return false;
        }
        return true;
    }
    
    /**
     * Inserts given character into the heap
     * @param a the character to insert
     */
    public void insert(char a)
    {
        append(a);
        int index = size - 1;
        while (true)
        {
            if(heap[(index - 1) / 2] == '\0')
            {
                break;
            }
            if(heap[index] < heap[(index - 1) / 2])
            {
                int parent = (index - 1) / 2;
                char tmp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = tmp;
            }
            
            else
                break;
        }
    }
    
    /**
     * Removes the highest priority character from the heap
     * @return the char removed
     */
    public char remove()
    {
        char removed = heap[0];
        heap[0] = heap[size - 1];
        int index = 0;
        while(!check())
        {
            char tmp = heap[index];
            if(heap[(index * 2) + 1] < heap[(index * 2) + 2])
            {
                heap[index] = heap[(index * 2) + 1];
                heap[(index * 2) + 1] = tmp;
            }
            else
            {
                heap[index] = heap[(index * 2) + 2];
                heap[(index * 2) + 2] = tmp;
            }

        }
        size--;
        return removed;
    }
    
    
    //Begin Unit Tests
    public static void test1(Prog1 Q)
    {
        Q.clear();
        Q.append('a');
        Q.append('b');
        assert Q.size() == 2;
        assert Q.check() == true;
    }
    
    public static void test2(Prog1 Q)
    {
        Q.clear();
        Q.append('b');
        Q.append('a');
        assert Q.size() == 2;
        assert Q.check() == false;

    }

    public static void test3(Prog1 Q) 
    {
        Q.clear();
        Q.insert('a');
        Q.insert('b');
        assert Q.size() == 2;
        assert Q.check() == true;
        assert Q.remove() == 'a';
        assert Q.size() == 1;
    }

    public static void test4(Prog1 Q)
    {
        Q.clear();
        Q.insert('b');
        Q.insert('a');
        assert Q.size() == 2;
        assert Q.check() == true;
        assert Q.remove() == 'a';
        assert Q.size() == 1;

    }

    public static void main(String[] args) 
    {
        Prog1 Q = new Prog1(args[0]);
        test1(Q);
        test2(Q);
        test3(Q);
        test4(Q);
    }
}