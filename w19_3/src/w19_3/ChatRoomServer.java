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
				//实例化BufferedReader对象，获取输入流
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				//实例化PrintWriter对象，获取输出流
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
		ta.setEditable(false);								//使文本域不可编辑
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					server = new ServerSocket(PORT);		//实例化ServerSocket对象
					ta.append(String.format("%tF %<tH:%<tM:%<tS%n", new Date())
							+ "服务器套接字已经创建成功\n等待客户端的连接\n");
					while(true) {
						socket = server.accept();			//实例化Socket对象
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
		crs.setTitle("聊天室服务器");
		crs.setIconImage(new ImageIcon(
				"E:\\My Pictures\\壁纸/小兰.jpg").getImage());
		crs.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crs.setSize(344, 576);
		crs.setLocationRelativeTo(null);
		crs.setVisible(true);
	}

}
