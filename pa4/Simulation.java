//-----------------------------------------------------------------------------
// SimulationStub.java
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Simulation{
  
//-----------------------------------------------------------------------------
//
// The following function may be of use in assembling the initial backup and/or
// storage queues.  You may use it as is, alter it as you see fit, or delete it
// altogether.
//
//-----------------------------------------------------------------------------
  
  public static Job getJob(Scanner in) {
    String[] s = in.nextLine().split(" ");
    int a = Integer.parseInt(s[0]);
    int d = Integer.parseInt(s[1]);
    return new Job(a, d);
  }
  
  
//-----------------------------------------------------------------------------
//
// The following stub for function main contains a possible algorithm for this
// project.  Follow it if you like.  Note that there are no instructions below
// which mention writing to either of the output files.  You must intersperse
// those commands as necessary.
//
//-----------------------------------------------------------------------------
  
  public static void main(String[] args) throws IOException{
    
    Scanner in = null; //file being read in
    PrintWriter report=null;
    PrintWriter trace=null;
    int m, n; //variables info on input file - n beign processors
    int time=0;
    int totalWait=0;
    int maxWait=0;
    float avrWait=0;
    String lnBrk = "***********************************************************\n";
    boolean unprocessedJobsRemain = true;
    
    if(args.length < 1){
      System.err.println("Usage: Simulation in");
      System.exit(1);
    }
    
    in = new Scanner(new File(args[0]));
    report = new PrintWriter(new FileWriter(args[0]+".rpt"));
    //read in Jobs from file and store in storage queue
    m= in.nextInt(); in.nextLine(); //m = number of upcoming jobs
    Queue pro = new Queue();
    System.out.println(m);
    /*
     //write to report file Jobs that were found in file
     report.println("Report file: " + (args[0]+".rpt"));
     report.println(bac.length());
     report.println(bac + "\n");
     report.print(lnBrk);
     //used for tracking -> temporary
     System.out.println("Report file: " + (args[0]+".rpt"));
     System.out.println(bac.length() + " Jobs:");
     System.out.println(bac);
     System.out.print(lnBrk);
     */
    
    for(n=1; n<m ; n++){
      Queue bac = new Queue();
      Queue[] processors = new Queue[m-1]; //queue array size grows untill m-1
      for(int i=0; i<m-1; i++){
        processors[i] = new Queue();
      }
      // Job t = ((Job)bac.dequeue());
      //read in jobs from queue
      while(in.hasNextLine()){
        Job x = getJob(in);
        bac.enqueue(x);
        processors[0].enqueue(x);
      }
      
      //write to report file Jobs that were found in file
      report.println("Report file: " + (args[0]+".rpt"));
      report.println(bac.length()+ " Jobs:");
      report.println(bac + "\n");
      report.print(lnBrk);
      //used for tracking -> temporary
      System.out.println("Report file: " + (args[0]+".rpt"));
      System.out.println(bac.length() + " Jobs:");
      System.out.println(bac);
      System.out.print(lnBrk);
      
      System.out.println("Processors length: " + processors.length);    
      
      
      while(unprocessedJobsRemain){ 
        
        Job x = ((Job)processors[0].dequeue());
        Job nextX = ((Job)processors[0].peek());
        processors[0].enqueue(x);
        if(time == 0){
          time = x.getArrival();
        }
        
        
        processors[1].enqueue(x);
        x.computeFinishTime(time);
        System.out.println(processors[1]);
        
        
        
        time= x.getFinish();
        System.out.println(x);
        
        System.out.println(bac);
        System.out.println(processors[1]);
        
        if(nextX.getFinish() != -1)
        unprocessedJobsRemain = false;
      }
      //compute total wait time
      for(n=0; n<m ; n++){
        int calc = ((Job)(bac.dequeue())).getWaitTime();
        if(maxWait <= calc){
          maxWait = calc;
        }
        totalWait = totalWait + calc;
      }
      avrWait = (float)totalWait/m ;
      report.println("Processors: " +"totalWait=" + totalWait + ", maxWait=" + 
                     maxWait + ", averageWait="+ avrWait);
      System.out.println( n +" Processors: " +"totalWait=" + totalWait + ", maxWait=" + 
                         maxWait + ", averageWait="+ avrWait);
      
      
      
//    1.  check command line arguments
//
//    2.  open files for reading and writing
//
//    3.  read in m jobs from input file
//
//    4.  run simulation with n processors for n=1 to n=m-1  {
//
//    5.      declare and initialize an array of n processor Queues and any 
//            necessary storage Queues
//
//    6.      while unprocessed jobs remain  {
//
//    7.          determine the time of the next arrival or finish event and 
//                update time
//
//    8.          complete all processes finishing now
//
//    9.          if there are any jobs arriving now, assign them to a processor 
//                Queue of minimum length and with lowest index in the queue array.
//
//    10.     } end loop
//
//    11.     compute the total wait, maximum wait, and average wait for 
//            all Jobs, then reset finish times
//
//    12. } end loop
//
//    13. close input and output files
    }
    in.close();
    report.close();
  }
}


