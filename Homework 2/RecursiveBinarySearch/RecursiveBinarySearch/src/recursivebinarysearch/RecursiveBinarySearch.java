//for testing
package recursivebinarysearch;

import java.util.ArrayList;
/**
 *
 * @author Clayton
 */
public class RecursiveBinarySearch {
    
    public class MyArrayList<E> extends ArrayList<E>{
        public E get(int index){
            return super.get(index -1);
        }
        public void set(int index, E value){
            super.set(index - 1, value);
        }
    }
    
    public static int binarySearch(int[] sortedArray, int first, int end,int key){
        if(end == 1)
            return sortedArray[end];
        else{
            int mid = end / 2;
            if(key < sortedArray[first + mid]){
                System.out.printf("search(A, %d, %d, %d) %n", first, mid, key);
                return binarySearch(sortedArray, first, mid, key);
            }
                
            else{
                System.out.printf("search(A, %d, %d, %d) %n", first + mid, end - mid, key);
                return binarySearch(sortedArray, first + mid, end - mid, key);
            }
                
        }
    }
    
    public static void main(String[] args) {
        int[] A = new int[16];
        int j = 11;
        for(int i = 0; i < A.length; i++){
            A[i] = j++;
        }
        System.out.println("search(A, 1, 16, 13)");
        System.out.println("BinarySearch: " + binarySearch(A,1,16,13));
    }
    
}
