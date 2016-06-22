//Project compleated by Francisco Rocha 1272597

// Extrema.java

class Extrema {
  
  // maxArray()
  // returns the largest value in int array A
  public static int maxArray(int[] A, int p, int r){
    
    if(p == r)
      return A[p];
    
    int q = (p + r)/2;
    
    return Math.max(maxArray( A, p, q), maxArray(A, q+1, r));
    
  }
  
  
  
  // minArray()
  // returns the smallest value in int array A
  static int minArray(int[] A, int p, int r){
    if(p == r)
      return A[p];
    
    int q = (p + r)/2;
    
    return Math.min(minArray( A, p, q), minArray(A, q+1, r));
  }
  
  
  // main()
  public static void main(String[] args){
    int[] B = {-1, 2, 6, 3, 9, 2, -3, -2, 11, 5, 7};
    
    System.out.println( "max = " + maxArray(B, 0, B.length-1) );  // output: max = 11
    System.out.println( "min = " + minArray(B, 0, B.length-1) );  // output: min = -3
  }
}
