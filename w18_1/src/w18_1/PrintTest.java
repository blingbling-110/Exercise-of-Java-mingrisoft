package w18_1;

public class PrintTest extends Thread {
	public void run() {
		while(true) {
			System.out.println("Java∂‡œﬂ≥Ã");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		PrintTest p = new PrintTest();
		p.start();
	}

}
