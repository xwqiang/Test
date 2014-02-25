package test;

public class Gerator extends Thread {
	public void run(){
		for(int i = 0 ; i < 1000 * 20 ; i ++ ){
			DataCenter.add(new Message());
			System.out.println("the msg num:"+i);
		}
		System.out.println("gen 200 * 1000");
	}
}
