package w18_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartAndStop extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JButton b1 = new JButton();
	private final JButton b2 = new JButton();
	private Thread tStart;
	
	public StartAndStop() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(b1);
		c.add(b2);
		b1.setText("开始");
		b2.setText("停止");
		class MyRun implements Runnable {
			private boolean isStop;
			
			public void run() {
				while(true) {		//持续打印一段话
					System.out.println("这是练习题二的程序\n关于Java多线程");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(isStop)
						break;
				}
			}
			
			public void doStop() {		//设置isStop为true使无限循环停止
				this.isStop = true;
			}

			public void doStart() {		//设置isStop为false使无限循环开始
				this.isStop = false;
			}
		}
		MyRun mr = new MyRun();
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mr.doStart();
				tStart = new Thread(mr);
				tStart.start();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mr.doStop();
			}
		});
	}

	public static void main(String[] args) {
		StartAndStop sas = new StartAndStop();
		sas.setTitle("这是练习题二的程序");
		sas.setDefaultCloseOperation(EXIT_ON_CLOSE);
		sas.setBounds(300, 300, 344, 144);
		sas.setVisible(true);
	}

}
