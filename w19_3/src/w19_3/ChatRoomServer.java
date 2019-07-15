package w19_3;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.*;
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
	private HashMap<String, Client> clients = new HashMap<>();
	private int clientCount;
	
	private class Client implements Runnable {
		private BufferedReader reader;
		private PrintWriter writer;
		private String userID;

		@Override
		public void run() {
			try {
				//实例化BufferedReader对象，获取输入流
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				//实例化PrintWriter对象，获取输出流
				writer = new PrintWriter(socket.getOutputStream());
				writer.println("U$S$E$R$I$D:" + userID);
				/*
				 *	刷新流，刷新Writers和OutputStreams链中的所有缓冲区
				 *	如果流已经从缓冲区中的各种write()方法保存了任何字符，
				 *	它们将被立即写入到其预期目的地。
				 */
				writer.flush();
				ta.append(String.format("%n%tF %<tH:%<tM:%<tS%n", new Date())
						+ userID + "已建立连接\n");
				//设置文本插入符的位置，用于自动滚动文本域
				ta.setCaretPosition(ta.getText().length());
				ta.validate();								//验证此容器及其所有子组件
				while(true) {
					data.delete(0, data.length());
					data.append(reader.readLine());
					ta.append(data.toString() + '\n');
					ta.setCaretPosition(ta.getText().length());
					ta.validate();
					Set<String> userIDSet = clients.keySet();
					Iterator<String> i = userIDSet.iterator();
					while(i.hasNext()) {
						Client c = clients.get(i.next());
						c.writer.println(data.toString());
						c.writer.flush();
					}
				}
			} catch (IOException e) {
				clients.remove(this.userID);
				ta.append(String.format("%n%tF %<tH:%<tM:%<tS%n", new Date())
						+ this.userID + "已断开连接\n");
				ta.setCaretPosition(ta.getText().length());
				ta.validate();
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
						client.userID = "用户" + ++clientCount;
						clients.put(client.userID, client);
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
				"E:/My Pictures/root.jpg").getImage());
		crs.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crs.setSize(344, 576);
		crs.setLocationRelativeTo(null);
		crs.setVisible(true);
	}

}
