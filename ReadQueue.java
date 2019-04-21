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
import java.io.IOException;

public class ReadQueue extends Thread{
	BlockingQueue q;
        BlockingQueue outputQ;
	
	public ReadQueue(BlockingQueue q,BlockingQueue outputQ) {
		this.q=q;
		this.outputQ=outputQ;
	}
	
	public void run() {
            System.out.println("staRT READING FROM "
                    + "queue");
		for(int i=0;i<100/8;i++) {
			String s="";
			try {
			s=(String)q.pop();
			String content=FileUtils.readFileAsString(s);
			int numOfLetters=0;
			int numOfDigits=0;
			int numOfOthers=0;
                        System.out.println("calculate numbers");
			for(int j=0;j<content.length();j++) {
				if(Character.isLetter(content.charAt(j)))
						numOfLetters++;
				else if(Character.isDigit(content.charAt(j)))
					numOfDigits++;
				else
					numOfOthers++;
			}
                        System.out.println("writing to the queue");
				String s1=String.format(s+" %d %d %d", numOfLetters,numOfDigits,numOfOthers);
				outputQ.add(s1);
				
			}catch(InterruptedException e) {
				System.out.println(e.getClass());
			}
			catch(IOException e) {
				System.out.println(e.getClass());
			}
			
		}
	}
	

}
