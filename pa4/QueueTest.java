//-----------------------------------------------------------------------------
// IntegerQueueTest.java
// Test Client for the IntegerQueue class
//-----------------------------------------------------------------------------

public class QueueTest {

   public static void main(String[] args){
      Queue A = new Queue();
      
      Queue C = new Queue();
      Queue D = new Queue();
      Job job = new Job(2,4);
      Job job2 = new Job(3,7);
      
      
      
      C.enqueue(job); C.enqueue(job2); C.enqueue(new Job(4,6));
      System.out.println(C);
      job.computeFinishTime(2);
      System.out.println(C);
      System.out.println(job.getFinish());
      A.enqueue("lemon"); A.enqueue(3); A.enqueue(9); A.enqueue(7); A.enqueue(8);
      System.out.println(A);
      System.out.println(A.peek());
       System.out.println(C.dequeue()); A.dequeue(); A.dequeue();
      System.out.println(A.peek());
      System.out.println(A);
      Queue B = new Queue();
      System.out.println(A.isEmpty());
      System.out.println(B.isEmpty());
      B.enqueue(7); B.enqueue(8);
      A.enqueue(12);
      System.out.println(A);
      System.out.println(B);
      System.out.println(B.dequeue()); System.out.println(B.dequeue());
      A.dequeueAll();
      System.out.println(A);
      System.out.println(A.isEmpty());
      
   }
}