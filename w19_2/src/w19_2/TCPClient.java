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
	private static final String TITLE = "这是练习题二的客户端";
	private static final String ICONPATH = "E:/My Pictures/root.jpg";
	private final JScrollPane sp = new JScrollPane();
	private final JTextArea ta = new JTextArea(5, 30);
	private final JButton bRec = new JButton("开始接收");
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
					bRec.setText("停止接收");
					tRec = new Thread(TCPClient.this);
					tRec.start();
				}else {
					isStartButton = true;
					isStop = true;
					bRec.setText("开始接收");
					ta.append("服务器已断开\n");
				}
			}
		});
	}

	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 8001);		//实例化套接字对象
			ta.append("服务器已连接，开始接收服务器信息：\n");
			//实例化BufferedReader对象，获取输入流
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
