package test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gerator g = new Gerator();
		g.start();
		WriteToFile f = new WriteToFile();
		f.start();

	}

}
