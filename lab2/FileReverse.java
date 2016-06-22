// Lab 2
// FileReverse.java 
// Completed by Francisco Rocha (forcha@ucsc.edu)
// takes in a file and reverses the order of the letters in every word.
import java.io.*;
import java.util.Scanner;


class FileReverse{
  public static int num=0;
  public static String bkword="";
  
  // stringReverse
  // takes in a string and and int and uses them to reverse the word using substring
  public static String stringReverse(String s, int n){
    if(n>0){
      bkword = bkword + (s.substring(n-1, n));
      stringReverse(s, n-1); 
    }
    return bkword;  
  }
  
  public static void main(String[] args) throws IOException{
    Scanner in = null;
    PrintWriter out = null;
    String line = null;
    String[] token = null;
    int i, n, lineNumber = 0;
    
    if(args.length < 2){
      System.out.println("Usage: FileIO infile outfile");
      System.exit(1);
    }
    
    in = new Scanner(new File(args[0]));
    out = new PrintWriter(new FileWriter(args[1]));
    
    in.useDelimiter("\n");
    while( in.hasNext() ){
      lineNumber++;
      line = in.next() + " "; // add space so split works on blank lines
      token = line.split("\\s+"); // split line around white space
      n = token.length;
      for(i=0; i<n; i++){
        out.println(stringReverse(token[i], token[i].length())); // where the "magic" happens.
        bkword=""; //used to clean glocal variable for next string concatanization.
      }
    }    
    in.close();
    out.close();
  }
}