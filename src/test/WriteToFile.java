package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile extends Thread {
	List<Message> list = new ArrayList<Message>();
	public void run(){
		try {
			while(true){
				
				Message msg = DataCenter.poll();
				if(msg != null){
					list.add(msg);
					if(list.size()>=1000){
						writeTofile();
					}
				}else{
					writeTofile();
					Thread.sleep(100);
				}
				
			}
		} catch (Exception e) {
			
		}
	}
	private void writeTofile() {
		try {
			System.err.println("file size "+list.size());
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/testpath/"+System.currentTimeMillis()+".sms")));
			oos.writeObject(list);
			oos.close();
			list.clear();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
