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
/*
  public static int[] sort(int[] arr) {
    // Your algorithm goes here!
    int N = arr.length;
    int[] temp = new int[] {};
    
    if(N <= 1){
        return arr;
    } else{
        int mid = N/2;
        int[] left = new int[mid], right = new int[N-(mid)];
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
        
        temp = arr;
        System.out.print(temp);
    }
    
    return temp;
  }*/
  public static void merge(int arr[], int first, int mid, int last){
      //subarray Size
      int n1 = mid - first + 1;
      int n2 = last - mid;
      
      int[] Left = new int[n1];
      int[] Right = new int[n2];
      
      
      for (int Lindex = 0; Lindex < n1; ++Lindex){
          Left[Lindex] = arr[first+Lindex];
      }
      for (int Rindex = 0; Rindex < n2; ++Rindex){
          Right[Rindex] = arr[mid + 1 + Rindex];
      }
      
      int i = 0, j = 0;
      
      int k = first;
      while(i < n1 && j < n2){
          if (Left[i] <= Right [j]){
              arr[k] = Left[i];
              i++;
          }
          else{
              arr[k] = Right[j];
              j++;
          }
          k++;
      }
      
      while (i < n1){
          arr[k] = Left[i];
          i++;
          k++;
      }
      
      while(j < n2){
          arr[k] = Right[j];
          j++;
          k++;
      }
    }
    
    public static int[] sort(int[] arr, int l, int r){
        if (l < r){
            int mid = (l+r)/2;
            
            //sort halves
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            
            merge(arr, l, mid, r);
        }
        
        return arr;
    }
  
  public static void main(String[] args) {
    int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
      31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    
    // Test the sort
    testSort(sort(arr, 0, arr.length - 1));
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
