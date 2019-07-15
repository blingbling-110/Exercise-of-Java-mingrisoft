package w19_2;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class TCPClient extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "������ϰ����Ŀͻ���";
	private static final String ICONPATH = "E:/My Pictures/root.jpg";
	private final JScrollPane sp = new JScrollPane();
	private final JTextArea ta = new JTextArea(5, 30);
	private final JButton bRec = new JButton("��ʼ����");
	private Thread tRec;
	private Socket socket;
	private BufferedReader reader;
	private boolean isStartButton = true;
	private boolean isStop;
	
	public TCPClient() {
		setLayout(new FlowLayout());
		add(sp);
		add(bRec);
		sp.setViewportView(ta);
		bRec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isStartButton) {
					isStartButton = false;
					isStop = false;
					bRec.setText("ֹͣ����");
					tRec = new Thread(TCPClient.this);
					tRec.start();
				}else {
					isStartButton = true;
					isStop = true;
					bRec.setText("��ʼ����");
					ta.append("�������ѶϿ�\n");
				}
			}
		});
	}

	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 8001);		//ʵ�����׽��ֶ���
			ta.append("�����������ӣ���ʼ���շ�������Ϣ��\n");
			//ʵ����BufferedReader���󣬻�ȡ������
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while(true) {
				if(isStop)
					break;
				ta.append(reader.readLine() + '\n');
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TCPClient tcp = new TCPClient();
		tcp.setTitle(TITLE);
		tcp.setIconImage(new ImageIcon(ICONPATH).getImage());
		tcp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		tcp.setSize(400, 200);
		tcp.setLocationRelativeTo(null);
		tcp.setVisible(true);
	}

}
