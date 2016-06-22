//-----------------------------------------------------------------------------
// DictionaryTest.java
// Client module for testing Dictionary ADT
//-----------------------------------------------------------------------------

public class DictionaryTest{
  
  public static void main(String[] args){
    String v;
      Dictionary A = new Dictionary();
      A.insert("1","a");
      A.insert("2","b");
      A.insert("3","c");
      A.insert("4","d");
      A.insert("5","e");
      A.insert("6","f");
      A.insert("7","g");
   
      System.out.println(A);
      v = A.lookup("6");
      System.out.println("key=6 "+(v==null?"not found":("value="+v)));
       v = A.lookup("7");
      System.out.println("key=7 "+(v==null?"not found":("value="+v)));
      
      A.delete("1");
      A.delete("2");
      A.delete("7");
   // A.delete("10");
      
     System.out.println(A.isEmpty());
      
     System.out.println(A);
      
     A.makeEmpty();
     System.out.println(A.isEmpty());
     
     A.insert("7", "j");
      System.out.println(A);
     
      
  }
}