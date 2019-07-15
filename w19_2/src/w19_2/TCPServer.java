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
			System.out.println("�������׽����Ѿ������ɹ�\n"
					+ "�ȴ��ͻ��˵�����");
			while(true) {
				socket = server.accept();		//�ȴ��ͻ��˵�����
				//ʵ����BufferedWriter����
				writer = new PrintWriter(socket.getOutputStream(), true);
				sendMsg("����TCPЭ�鴫�������");
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
