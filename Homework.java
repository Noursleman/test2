/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author Domino
 */
public class Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BlockingQueue queue=new BlockingQueue(100);
        Generate g=new Generate(queue);
        
        BlockingQueue out=new BlockingQueue(100);
        ReadQueue []read=new ReadQueue[8];
        for(int i=0;i<8;i++){
            read[i] = new ReadQueue(queue,out);
        }
        Print printQ = new Print(out);
        g.start();
        for(int i=0;i<8;i++){
            read[i].start();
        }
        printQ.start();
        try{
        g.join();
        for(int i=0;i<8;i++){
            read[i].join();
        }
        printQ.join();
        }catch(InterruptedException e){
            System.out.println(e.getClass());
        }
        System.out.println("end");
    }
    
}
