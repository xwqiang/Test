package test;

import java.io.Serializable;

public class Message implements Serializable {
	private int sn;

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}
	
}
