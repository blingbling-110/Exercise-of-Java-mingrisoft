package w19_3;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class ChatRoomServer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PORT = 9110;
	private final JScrollPane sp = new JScrollPane();
	private final JTextArea ta = new JTextArea();
	private ServerSocket server;
	private Socket socket;
	private StringBuilder data = new StringBuilder("");
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	private class Client implements Runnable {
		private BufferedReader reader;
		private PrintWriter writer;

		@Override
		public void run() {
			try {
				//ʵ����BufferedReader���󣬻�ȡ������
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				//ʵ����PrintWriter���󣬻�ȡ�����
				writer = new PrintWriter(socket.getOutputStream());
				while(true) {
					data.delete(0, data.length());
					data.append(reader.readLine());
					ta.append(data.toString() + '\n');
					ta.validate();
					for(Client c: clients) {
						c.writer.println(data.toString());
						c.writer.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ChatRoomServer() {
		add(sp, BorderLayout.CENTER);
		sp.setViewportView(ta);
		ta.setEditable(false);								//ʹ�ı��򲻿ɱ༭
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					server = new ServerSocket(PORT);		//ʵ����ServerSocket����
					ta.append(String.format("%tF %<tH:%<tM:%<tS%n", new Date())
							+ "�������׽����Ѿ������ɹ�\n�ȴ��ͻ��˵�����\n");
					while(true) {
						socket = server.accept();			//ʵ����Socket����
						Client client = new Client();
						clients.add(client);
						new Thread(client).start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		ChatRoomServer crs = new ChatRoomServer();
		crs.setTitle("�����ҷ�����");
		crs.setIconImage(new ImageIcon(
				"E:\\My Pictures\\��ֽ/С��.jpg").getImage());
		crs.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crs.setSize(344, 576);
		crs.setLocationRelativeTo(null);
		crs.setVisible(true);
	}

}
