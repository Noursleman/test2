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

public class Print extends Thread{
	private BlockingQueue q;
	
	public Print(BlockingQueue q) {
		this.q=q;
	}
	
	public void run() {
            System.out.println("print queue");
		try {
		for(int i=0;i<100;i++) {
			String s=(String)q.pop()+
                                "\n";
			FileUtils.appendStringToFile("file1.txt", s);
			
		}
		}catch(InterruptedException e) {
                    System.out.println(e.getClass());
			
		}
		catch(IOException e) {
                    System.out.println(e.getClass());
			
		}
	}

}
