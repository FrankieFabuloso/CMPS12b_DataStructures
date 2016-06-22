//-----------------------------------------------------------------------------
// ListInterface.java
// interface for the List ADT
//-----------------------------------------------------------------------------

public class List<T> implements ListInterface<T>{
  
// private inner Node class
  private class Node<T> {
    T item;
    Node next;
    
    Node(T i){
      item = i;
      next = null;
    }
  }
  
  
  // Fields for the IntegerList class
  private Node head;     // reference to first Node in List
  private int numItems;  // number of items in this IntegerList
  
  // List()
  // constructor for the IntegerList class
  public List( ){
    head = null;
    numItems = 0;
  }
  
  private Node find(int index){
      Node N = head;
      for(int i=1; i<index; i++) N = N.next;
      return N;
   }
  
  
  // isEmpty
  // pre: none
  // post: returns true if this List is empty, false otherwise
  public boolean isEmpty(){
    return(numItems == 0);
  }
  
  // size
  // pre: none
  // post: returns the number of elements in this List
  public int size(){
    return numItems;
  }
  
  // get
  // pre: 1 <= index <= size()
  // post: returns item at position index
  @SuppressWarnings("unchecked")
  public T get(int index) throws ListIndexOutOfBoundsException{
    if( index<1 || index>numItems ){
      throw new ListIndexOutOfBoundsException("List Error: get() called on invalid index: " + index);
    }
    Node N = find(index);
    return (T)N.item;
    
  }
  
  // add
  // inserts newItem in this List at position index
  // pre: 1 <= index <= size()+1
  // post: !isEmpty(), items to the right of newItem are renumbered
  @SuppressWarnings("unchecked")
  public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
    if( index<1 || index>(numItems+1) ){
      throw new ListIndexOutOfBoundsException("List Error: add() called on invalid index: " + index);
    }
    if(index==1){
      Node N = new Node(newItem);
      N.next = head;
      head = N;
    }else{
      Node P = find(index-1); // at this point index >= 2
      Node C = P.next;
      P.next = new Node(newItem);
      P = P.next;
      P.next = C;
    }
    numItems++;
  }
  
  
  
  // remove
  // deletes item from position index
  // pre: 1 <= index <= size()
  // post: items to the right of deleted item are renumbered
  public void remove(int index) throws ListIndexOutOfBoundsException{
    if( index<1 || index>numItems ){
      throw new ListIndexOutOfBoundsException("List Error: remove() called on invalid index: " + index);
    }
    if(index==1){
      Node N = head;
      head = head.next;
      N.next = null;
    }else{
      Node P = find(index-1);
      Node N = P.next;
      P.next = N.next;
      N.next = null;
    }
    numItems--;
  }
  
  
  // removeAll
  // pre: none
  // post: isEmpty()
  public void removeAll(){
    head = null;
    numItems = 0;
  }
  
   // toString()
   // pre: none
   // post:  prints current state to stdout
   // Overrides Object's toString() method
   public String toString(){
      String s = "";
      for(Node N=head; N!=null; N=N.next){
         s += N.item + " ";
      }
      return s;
   }
  
  
}