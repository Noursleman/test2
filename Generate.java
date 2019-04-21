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
public class Generate extends Thread{

	private BlockingQueue q;
	
	public Generate(BlockingQueue q) {
		this.q=q;
	}
	
	public void run() {
            System.out.println("starting thread 1");
		for(int i=0;i<100;i++) {
			String s=String.format("data/f%d.txt", i);
			try {
			q.add(s);
			}catch(InterruptedException e) {
				System.out.println(e.getClass());
			}
		}
                System.out.println("Ending thread enerate");
	}
	
}
