package w19_1;

import java.awt.event.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class SpeHostName extends JFrame implements Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel pNorth = new JPanel(new GridLayout(3, 2));
	private final JPanel pCenter = new JPanel();
	private final JLabel lSpeHostName = new JLabel("ָ������������");
	private final JTextField tfSpeHostName = new JTextField();
	private final JLabel lSpeIpAddr = new JLabel("ָ����������ַ��");
	private final JTextField tfSpeIpAddr = new JTextField();
	private final JLabel lLocalIpAddr = new JLabel("������ַ��");
	private final JTextField tfLocalIpAddr = new JTextField();
	private final JLabel lInput = new JLabel("��������������");
	private final JTextField tfInput = new JTextField(8);
	private final JButton bGet = new JButton("��ȡ");
	private String inputHostName;			//������
	private Thread tGet;					//���ڻ�ȡָ����Ϣ���߳�
	private InetAddress ipAddr;				//����IP��ַ����
	
	public SpeHostName() {
		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		pNorth.add(lSpeHostName);
		pNorth.add(tfSpeHostName);
		pNorth.add(lSpeIpAddr);
		pNorth.add(tfSpeIpAddr);
		pNorth.add(lLocalIpAddr);
		pNorth.add(tfLocalIpAddr);
		pCenter.add(lInput);
		pCenter.add(tfInput);
		pCenter.add(bGet);
		lSpeHostName.setHorizontalAlignment(SwingConstants.CENTER);
		lSpeIpAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lLocalIpAddr.setHorizontalAlignment(SwingConstants.CENTER);
		bGet.addActionListener(this);
		tfInput.addActionListener(this);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() == bGet) || (e.getSource() == tfInput)) {
			tGet = new Thread(this);
			tGet.start();
		}
	}

	@Override
	public void run() {
		inputHostName = tfInput.getText();
		try {
			ipAddr = InetAddress.getByName(inputHostName);
			tfSpeHostName.setText(inputHostName);
			tfSpeIpAddr.setText(ipAddr.getHostAddress());
			ipAddr = InetAddress.getLocalHost();
			tfLocalIpAddr.setText(ipAddr.getHostAddress());
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(this, 
					"δ֪����������\n��������ȷ����������", 
					"�������", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SpeHostName s = new SpeHostName();
		s.setTitle("������ϰһ�ĳ���");
		s.setIconImage(new ImageIcon(
				"E:\\My Pictures\\root.jpg").getImage());
		s.setDefaultCloseOperation(EXIT_ON_CLOSE);
		s.setSize(344, 144);
		s.setLocationRelativeTo(null);		//���ô�������Ļ�м�
		s.setVisible(true);
	}

}
