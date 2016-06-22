//-----------------------------------------------------------------------------
// QueueInterface.java
// interface for the Queue ADT
//-----------------------------------------------------------------------------

public class Queue implements QueueInterface{
  
  
  private class Node{
    Object item;
    Node next;
    Node(Object item){
      this.item = item;
      this.next = null;
    }
  }
  
  Queue(){
    back = null;
    front = null;
    numItems=0;
  }
  
  private Node back;
  private Node front;
  private int numItems;
  
  // isEmpty()
  // pre: none
  // post: returns true if this Queue is empty, false otherwise
  public boolean isEmpty(){
    return(numItems == 0);
  }
  
  // length()
  // pre: none
  // post: returns the length of this Queue.
  public int length(){
    return numItems;
  }
  
  // enqueue()
  // adds newItem to back of this Queue
  // pre: none
  // post: !isEmpty()
  public void enqueue(Object newItem){
    Node N = new Node(newItem);
    N.next = back;
    back = N;
    numItems++;
    
    if(N.next == null){
      front = N;
    }
  }
  
  // dequeue()
  // deletes and returns item from front of this Queue
  // pre: !isEmpty()
  // post: this Queue will have one fewer element
  public Object dequeue() throws QueueEmptyException {
    if( numItems == 0){
      throw new QueueEmptyException("cannot dequeue() empty queue");
    }
    Object temp = null;
    Node curr = back;
    if( curr == front ){
      back = back.next;
      temp = curr.item;
    }else {
      while (curr.next != front){
        curr = curr.next;
      }
      front = curr;
      temp = curr.next.item;
      curr.next = null;
    }
    numItems--;
    return temp;
  }
  
  
  // peek()
  // pre: !isEmpty()
  // post: returns item at front of Queue
  public Object peek() throws QueueEmptyException{
    if( numItems == 0){
      throw new QueueEmptyException("cannot dequeue() empty queue");
    }
    return front.item;
    
  }
  
  // dequeueAll()
  // sets this Queue to the empty state
  // pre: !isEmpty()
  // post: isEmpty()
  public void dequeueAll() throws QueueEmptyException{
    if( numItems == 0){
      throw new QueueEmptyException("cannot dequeue() empty queue");
    }
    back = null;
    front = null;
    numItems = 0;
  }
  
  
  // toString()
  // overrides Object's toString() method
  public String toString(){
    String s = "";
    for(Node N=back; N!=null; N = N.next){
      s = s + N.item + " " ;
    }
    return s;
  }
}