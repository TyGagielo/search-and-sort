package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{
   /**
   * Returns the sorted array
   */
  public static int[] sort(int[] arr) {
    // Your algorithm goes here!
    int N = arr.length;
    
    
    if(N <= 1){
        return arr;
    } else{
        int mid = N/2;
        int[] left = new int[mid], right = new int[N-(mid)];
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int index = 0;
        int rightIndex;
        
        while(index < mid){
            left[index] = arr[index];
            index++;
        }
        
        rightIndex = 0;
        index = mid;
        
        while(index < N){
            right[rightIndex] = arr[index];
            rightIndex++;
            index++;
        }
        
        sort(left);
        sort(right);
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);
    }
    
    
    return arr;
  }
  
  public static void main(String[] args) {
    int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
      31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    
    // Test the sort
    testSort(sort(arr));
  }
  
  public static void testSort(int[] arr) {
    for (int i=0; i<arr.length-1; i++) {
      if (arr[i] > arr[i+1]) {
        System.out.println("FAIL at index "+i);
        System.out.println(Arrays.toString(arr));
        return;
      }
    }
    System.out.println("SUCCESS!");
    System.out.println(Arrays.toString(arr));
  }

}
