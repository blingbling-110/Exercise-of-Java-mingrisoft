package w18_3;

import javax.swing.*;
import java.awt.*;

public class JProgressBarTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JProgressBar pb = new JProgressBar();
	private Thread thread;

	public JProgressBarTest() {
		Container c = getContentPane();
		c.add(pb, BorderLayout.NORTH);
		pb.setStringPainted(true);
		thread = new Thread(new Runnable() {
			private int percent = 0;
			
			@Override
			public void run() {
				
				while(true) {
					pb.setValue(++percent);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(percent == 100)
						break;
				}
			}
		});
		thread.start();
	}
	
	public static void main(String[] args) {
		JProgressBarTest pbt = new JProgressBarTest();
		pbt.setTitle("这是练习题三的程序");
		pbt.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pbt.setBounds(300, 300, 344, 144);
		pbt.setVisible(true);
	}

}
