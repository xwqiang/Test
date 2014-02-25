package test;

import java.util.concurrent.ArrayBlockingQueue;

public class DataCenter {
	private static ArrayBlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10000);
	public static void add(Message msg){
		synchronized(queue){
			if(queue.size()<10000){
				if(queue.add(msg)){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}else{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Message poll(){
		synchronized (queue) {
			Message msg = null;
			msg = queue.poll();
			if(msg == null){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return msg;
		}
	}
}
