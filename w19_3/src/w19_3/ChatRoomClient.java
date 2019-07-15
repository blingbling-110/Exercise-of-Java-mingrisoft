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
	private final JButton bSend = new JButton("����");
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private StringBuilder sendData = new StringBuilder("");
	private StringBuilder receiveData = new StringBuilder("");
	private String userID;
	
	public ChatRoomClient() {
		add(sp, BorderLayout.CENTER);
		sp.setViewportView(ta);
		ta.setEditable(false);									//ʹ�ı��򲻿ɱ༭
		add(pInput, BorderLayout.SOUTH);
		pInput.add(tf, BorderLayout.CENTER);
		tf.addActionListener(this);
		pInput.add(bSend, BorderLayout.EAST);
		bSend.addActionListener(this);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					socket = new Socket("localhost", PORT);		//ʵ����Socket����
					//ʵ����PrintWriter���󣬻�ȡ�����
					writer = new PrintWriter(socket.getOutputStream());
					//ʵ����BufferedReader���󣬻�ȡ������
					reader = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					ta.append(String.format(
							"%tF %<tH:%<tM:%<tS%n", new Date()) 
							+ "������������\n");
					Pattern pattern = Pattern.compile("U\\$S\\$E\\$R\\$I\\$D:");
					while(true) {
						receiveData.delete(0, receiveData.length());
						receiveData.append(reader.readLine());
						if(pattern.matcher(receiveData.toString()).lookingAt()) {
							userID = receiveData.substring(12);
							ta.append("�����ǳ�Ϊ��" + userID + '\n');
							ChatRoomClient.this.setTitle("�����ҿͻ��ˣ�" + userID);
						}else {
							ta.append(receiveData.toString() + '\n');
							//�����ı��������λ�ã������Զ������ı���
							ta.setCaretPosition(ta.getText().length());
						}
						ta.validate();							//��֤�������������������
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(ChatRoomClient.this,
							"�����ҷ���������ʧ��", "�׽��ִ���",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);								//����ʧ�����˳�
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
				 *	ˢ������ˢ��Writers��OutputStreams���е����л�����
				 *	������Ѿ��ӻ������еĸ���write()�����������κ��ַ���
				 *	���ǽ�������д�뵽��Ԥ��Ŀ�ĵء�
				 */
				writer.flush();
			}
		}
	}

	public static void main(String[] args) {
		ChatRoomClient crc = new ChatRoomClient();
		crc.setTitle("�����ҿͻ���");
		crc.setIconImage(new ImageIcon(
				"E:/My Pictures/root.jpg").getImage());
		crc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		crc.setSize(344, 576);
		crc.setLocationRelativeTo(null);
		crc.setVisible(true);
	}

}
