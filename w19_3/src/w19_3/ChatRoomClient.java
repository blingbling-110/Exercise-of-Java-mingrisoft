package w19_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.io.*;

public class ChatRoomClient extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PORT = 9110;
	private final JScrollPane sp = new JScrollPane();
	private final JTextArea ta = new JTextArea();
	private final JPanel pInput = new JPanel();
	private final JTextField tf = new JTextField(25);
	private final JButton bSend = new JButton("发送");
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private StringBuilder sendData = new StringBuilder("");
	private StringBuilder receiveData = new StringBuilder("");
	private String userID;
	
	public ChatRoomClient() {
		add(sp, BorderLayout.CENTER);
		sp.setViewportView(ta);
		ta.setEditable(false);									//使文本域不可编辑
		add(pInput, BorderLayout.SOUTH);
		pInput.add(tf, BorderLayout.CENTER);
		tf.addActionListener(this);
		pInput.add(bSend, BorderLayout.EAST);
		bSend.addActionListener(this);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					socket = new Socket("localhost", PORT);		//实例化Socket对象
					//实例化PrintWriter对象，获取输出流
					writer = new PrintWriter(socket.getOutputStream());
					//实例化BufferedReader对象，获取输入流
					reader = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					ta.append(String.format(
							"%tF %<tH:%<tM:%<tS%n", new Date()) 
							+ "服务器已连接\n");
					Pattern pattern = Pattern.compile("U\\$S\\$E\\$R\\$I\\$D:");
					while(true) {
						receiveData.delete(0, receiveData.length());
						receiveData.append(reader.readLine());
						if(pattern.matcher(receiveData.toString()).lookingAt()) {
							userID = receiveData.substring(12);
							ta.append("您的昵称为：" + userID + '\n');
							ChatRoomClient.this.setTitle("聊天室客户端：" + userID);
						}else {
							ta.append(receiveData.toString() + '\n');
							//设置文本插入符的位置，用于自动滚动文本域
							ta.setCaretPosition(ta.getText().length());
						}
						ta.validate();							//验证此容器及其所有子组件
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(ChatRoomClient.this,
							"聊天室服务器连接失败", "套接字错误",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);								//连接失败则退出
				}
			}
		}).start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() == tf) | (e.getSource() == bSend)) {
			if(!tf.getText().equals("")) {
				sendData.delete(0, sendData.length());
				sendData.append('\n' + userID + "  " + String.format(
						"%tF %<tH:%<tM:%<tS%n", new Date()) + tf.getText());
				tf.setText("");
				writer.println(sendData.toString());
				/*
				 *	刷新流，刷新Writers和OutputStreams链中的所有缓冲区
				 *	如果流已经从缓冲区中的各种write()方法保存了任何字符，
				 *	它们将被立即写入到其预期目的地。
				 */
				writer.flush();
			}
		}
	}

	public static void main(String[] args) {
		ChatRoomClient crc = new ChatRoomClient();
		crc.setTitle("聊天室客户端");
		crc.setIconImage(new ImageIcon(
				"E:/My Pictures/root.jpg").getImage());
		crc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crc.setSize(344, 576);
		crc.setLocationRelativeTo(null);
		crc.setVisible(true);
	}

}
