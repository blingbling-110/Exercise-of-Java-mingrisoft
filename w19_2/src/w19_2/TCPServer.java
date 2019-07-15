package w19_2;

import java.io.*;
import java.net.*;

public class TCPServer {
	private static final int PORT = 8001;
	private ServerSocket server;
	private Socket socket;
	private PrintWriter writer;
	
	public TCPServer() {
		try {
			server = new ServerSocket(PORT);
			System.out.println("服务器套接字已经创建成功\n"
					+ "等待客户端的连接");
			while(true) {
				socket = server.accept();		//等待客户端的连接
				//实例化BufferedWriter对象
				writer = new PrintWriter(socket.getOutputStream(), true);
				sendMsg("利用TCP协议传输的数据");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendMsg(String msg) {
		try {
			System.out.println(msg);
			writer.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TCPServer();
	}

}
