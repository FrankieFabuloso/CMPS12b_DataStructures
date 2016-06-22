//FileSearch.java compleated by Francisco Rocha (frocha@ucsc.edu)
//Assignment: Pa2(Program 2)
//
/*Description: Program scans in a File as well as specified words user is looking for in file.
 * Program returns either the word and on what line it was found or informs user word is not
 * in the file being searched */



import java.io.*;
import java.util.Scanner;

public class FileSearch {
  
  
  public static String binarySearch(String[] word, int[] nums, int p, int r,  String target){
    // pre: wordrray word[p..r] is sorted
    
    int q;
    
    if(p > r) {
      return "Target not found.";
    }else{
      q = (p+r)/2;
      if(target.compareTo(word[q])==0){
        return  word[q] + " found" + " on line " + nums[q];
      }else if(target.compareTo(word[q]) < 0){
        return binarySearch(word, nums, p, q-1, target);
      }else{ // target > word[q]
        return binarySearch(word, nums, q+1, r, target);
      }
    }
  }
  
  
  
  public static void mergeSort(String[] word, int[] nums, int p, int r){
    int q;
    if(p < r) {
      q = (p+r)/2;
      mergeSort(word, nums, p, q);
      mergeSort(word, nums, q+1, r);
      merge(word, nums, p, q, r);
    }
  }
  
  public static void merge(String[] word, int[] nums, int p, int q, int r){
    int n1 = q-p+1;
    int n2 = r-q;
    String[] L = new String[n1];
    int[] M = new int[n1];
    
    String[] R = new String[n2];
    int[] N = new int[n2];
    int i, j, k;
    
    for(i=0; i<n1; i++){
      L[i] = word[p+i];
      M[i] = nums[p+i];
    }
    for(j=0; j<n2; j++) {
      R[j] = word[q+j+1];
      N[j] = nums[q+j+1];
    }
    i = 0; j = 0;
    for(k=p; k<=r; k++){
      if( i<n1 && j<n2 ){
        if( L[i].compareTo(R[j])<0 ){
          word[k] = L[i];
          nums[k] = M[i];
          i++;
        }else{
          word[k] = R[j];
          nums[k] = N[j];
          j++;
        }
      }else if( i<n1 ){
        word[k] = L[i];
        nums[k] = M[i];
        i++;
      }else{ // j<n2
        word[k] = R[j];
        nums[k] = N[j];
        j++;
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    
    Scanner fileIn = null; //file being read in
    Scanner in = null;
    String target = null; // target being read in 
    int k = 0;
    int p = 1;
    
    if(args.length < 0){
      System.err.println("Usage: LineCount File target1 target2 ...");
      System.exit(1);
    }
    
    
    fileIn = new Scanner(new File(args[0]));//creates two new scaners for file input
    in = new Scanner(new File(args[0]));
    target = args[p];
    int lineCount = 0;//used to count ammount of line in File
    while( fileIn.hasNextLine()){//while loop used for counting ammount of lines in File
      fileIn.nextLine();
      lineCount++;
    }
    
    String[] sorted = new String[lineCount];//makes an array to fit each word in File using lineCount
    int[] nums = new int[lineCount];//another array for the original order of word ordering
    
    while(in.hasNextLine()){// this while loop fills in arrays with unsorted words and numbers
      sorted[k] = in.nextLine();
      nums[k] = (k+1);
      k++;      
    }
    
    mergeSort(sorted, nums, 0, sorted.length-1);//mergeSort called to sort words and arange number with sorted words
    while(  p < args.length ){  
      target = args[p];
      System.out.println(binarySearch(sorted, nums, 0, sorted.length-1, target)); 
      p++;
    }
    
    fileIn.close();
    System.out.println();
  }
}



