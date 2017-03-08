// Programing Project 0
// Clayton Samson <csamso1@lsu.edu>
package prog0;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Prog0 {

    public static void main(String[] args) throws FileNotFoundException{
        int[] data = new int[20];
        Scanner input = new Scanner(new File("input.txt"));
        int i = 0;
        while (input.hasNextInt()){
            data[i++] = input.nextInt();
        }
        System.out.println("un sorted integers: " + Arrays.toString(data));
        //Sorts an array using insertion sort.
        i = 0;
        for (i= 1; i < data.length; i++)
        {
            int next = data[i];
            int j = i;
            while (j > 0 && data[j - 1] > next)
            {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = next;
        }
        System.out.println("sorted integers: " + Arrays.toString(data));
    }
}