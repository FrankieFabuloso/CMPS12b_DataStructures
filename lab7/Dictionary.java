//-----------------------------------------------------------------------------
// Dictionary.java
// Binary Search Tree implementation of the Dictionary ADT
//-----------------------------------------------------------------------------

public class Dictionary implements DictionaryInterface{
  
  // private inner Node class
  private class Node {
    String key;
    String value;
    Node left;
    Node right;
    
    Node(String key, String value){
      this.key = key;
      this.value = value;
      left = null;
      right = null;
    }
  }
  
  // Fields for the Dictionary class
  private Node root;     // reference to first Node in List
  private int numItems;  // number of items in this IntegerList
  
  // IntegerList()
  // constructor for the IntegerList class
  public Dictionary(){
    root = null;
    numItems = 0;
  }
  
  
  
  // findKey()
// returns the Node containing key k in the subtree rooted at R, or returns
// NULL if no such Node exists
  public Node findKey(Node R, String key){
    if(R==null || key.compareTo(R.key)==0)
      return R;
    if(key.compareTo(R.key)<0){
      return findKey(R.left, key);
    }else
      return findKey(R.right, key);
  }
  
  
  
// findParent()
// returns the parent of N in the subtree rooted at R, or returns NULL 
// if N is equal to R. (pre: R != NULL)
  Node findParent(Node N, Node R){
    Node P=null;
    if( N!=R ){
      P = R;
      while( P.left!=N && P.right!=N ){
        if((N.key).compareTo(P.key)<0)
          P = P.left;
        else
          P = P.right;
      }
    }
    return P;
  }
  
  // findLeftmost()
// returns the leftmost Node in the subtree rooted at R, or NULL if R is NULL.
  Node findLeftmost(Node R){
    Node L = R;
    if( L!=null ) for( ; L.left!=null; L=L.left) ;
    return L;
  }
  
// printInOrder()
// prints the (key, value) pairs belonging to the subtree rooted at R in order
// of increasing keys to file pointed to by out.
 void printInOrder(Node R){
    String s;
    if( R!=null ){
      printInOrder(R.left);
      System.out.println(R.key +" " + R.value);
      printInOrder(R.right);
    }
  }
  
  
  // isEmpty()
  // returns true if this Dictionary is empty, false otherwise
  // pre: none
  public boolean isEmpty(){
    return (numItems==0);
  }
  
  // size()
  // returns the number of entries in this Dictionary
  // pre: none
  public int size(){
    return numItems;
  }
  
  // lookup()
  // returns value associated key, or null reference if no such key exists
  // pre: none
  public String lookup(String key){
    Node N = findKey(root, key);
    return ( N==null ? null : N.value );
  }
  
  // insert()
  // inserts new (key,value) pair into this Dictionary
  // pre: lookup(key)==null
  public void insert(String key, String value) throws KeyCollisionException{
    if(findKey(root, key) != null){
      throw new KeyCollisionException(
                                      "Dictionary Error: cannot insert() duplicate key:" + key);
    }
    Node N = new Node(key, value);
    Node B = null;
    Node A = root;
    while( A!=null ){
      B = A;
      if(key.compareTo(A.key)<0 ) A = A.left;
      else A = A.right;
    }
    if( B==null ) root = N;
    else if(key.compareTo(B.key)<0 ) B.left = N;
    else B.right = N;
    numItems++;
  }
  
  
  // delete()
  // deletes pair with the given key
  // pre: lookup(key)!=null
  public void delete(String key) throws KeyNotFoundException{
    if( lookup(key) == null ){  
      throw new KeyNotFoundException("cannot delete non-existent key");
    }
    Node N, P, S;
    N = findKey(root, key);
    if( N.left==null && N.right==null ){
      if( N==root ){
        root = null;
      }else{
        P = findParent(N, root);
        if( P.right==N ) P.right = null;
        else P.left = null;
      }
    }else if( N.right==null ){
      if( N==root ){
        root = N.left;
      }else{
        P = findParent(N, root);
        if( P.right==N ) P.right = N.left;
        else P.left = N.left;
      }
    }else if( N.left==null ){
      if( N==root ){
        root = N.right;
      }else{
        P = findParent(N, root);
        if( P.right==N ) P.right = N.right;
        else P.left = N.right;
      }
    }else{  // N->left!=NULL && N->right!=NULL
      S = findLeftmost(N.right);
      N.key = S.key;
      N.value = S.value;
      P = findParent(S, N);
      if( P.right==S ) P.right = S.right;
      else P.left = S.right;
    }
    numItems--;
  }
  
  
  
  // makeEmpty()
  // pre: none
  public void makeEmpty(){
    root = null;
    numItems = 0;
  }
  
  // toString()
  // returns a String representation of this Dictionary
  // overrides Object's toString() method
  // pre: none
  public String toString(){
    printInOrder(root);
    return " ";
  }
}