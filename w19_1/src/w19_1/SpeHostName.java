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
	private final JLabel lSpeHostName = new JLabel("指定的主机名：");
	private final JTextField tfSpeHostName = new JTextField();
	private final JLabel lSpeIpAddr = new JLabel("指定的主机地址：");
	private final JTextField tfSpeIpAddr = new JTextField();
	private final JLabel lLocalIpAddr = new JLabel("本机地址：");
	private final JTextField tfLocalIpAddr = new JTextField();
	private final JLabel lInput = new JLabel("请输入主机名：");
	private final JTextField tfInput = new JTextField(8);
	private final JButton bGet = new JButton("获取");
	private String inputHostName;			//主机名
	private Thread tGet;					//用于获取指定信息的线程
	private InetAddress ipAddr;				//声明IP地址对象
	
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
					"未知的主机名，\n请输入正确的主机名。", 
					"输入错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SpeHostName s = new SpeHostName();
		s.setTitle("这是练习一的程序");
		s.setIconImage(new ImageIcon(
				"E:\\My Pictures\\root.jpg").getImage());
		s.setDefaultCloseOperation(EXIT_ON_CLOSE);
		s.setSize(344, 144);
		s.setLocationRelativeTo(null);		//设置窗口在屏幕中间
		s.setVisible(true);
	}

}
