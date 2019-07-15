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
		b1.setText("��ʼ");
		b2.setText("ֹͣ");
		class MyRun implements Runnable {
			private boolean isStop;
			
			public void run() {
				while(true) {		//������ӡһ�λ�
					System.out.println("������ϰ����ĳ���\n����Java���߳�");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(isStop)
						break;
				}
			}
			
			public void doStop() {		//����isStopΪtrueʹ����ѭ��ֹͣ
				this.isStop = true;
			}

			public void doStart() {		//����isStopΪfalseʹ����ѭ����ʼ
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
		sas.setTitle("������ϰ����ĳ���");
		sas.setDefaultCloseOperation(EXIT_ON_CLOSE);
		sas.setBounds(300, 300, 344, 144);
		sas.setVisible(true);
	}

}
