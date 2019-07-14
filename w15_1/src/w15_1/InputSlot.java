package w15_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class InputSlot extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container = null;			//��������
	private JScrollPane textPanel = null;		//�����ı����
	private JTextArea textArea = null;			//�ı���
	private JPanel buttonPanel = null;			//��ť���
	private JButton inputButton = null;			//���밴ť

	public InputSlot() {
		super();
		initialize();
	}

	/**
	 * 	��ʼ������
	 */
	private void initialize() {
		if(container  == null) {
			container = this.getContentPane();
			container.setLayout(new BorderLayout());
			container.add(getTextPanel(), BorderLayout.CENTER);
			container.add(getbuttonPanel(), BorderLayout.SOUTH);
		}
		getContentPane();
	}

	private JPanel getbuttonPanel() {
		if(buttonPanel == null) {
			buttonPanel = new JPanel(new FlowLayout());
			buttonPanel.add(getInputButton());
		}
		return buttonPanel ;
	}

	private JButton getInputButton() {
		if(inputButton == null) {
			inputButton = new JButton("�����ļ�");
			inputButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					File file = new File("../c15_7/hello/hello1.txt");
					try {
						ProgressMonitorInputStream pmis = 
								new ProgressMonitorInputStream(container, 
										"���ڶ�ȡ" + file.getName(), 
										new FileInputStream(file));
						byte[] tmpByte = new byte[2];
						while(pmis.read(tmpByte) != -1) {
							textArea.append(new String(tmpByte));
							Thread.sleep(500);
						}
						pmis.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return inputButton;
	}

	private JScrollPane getTextPanel() {
		if(textPanel == null) {
			textPanel = new JScrollPane(getTextArea());
		}
		return textPanel;
	}

	private JTextArea getTextArea() {
		if(textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	public static void main(String[] args) {
		InputSlot o = new InputSlot();
		o.setTitle("�����ȡ������");
		o.setBounds(300, 300, 384, 216);
		o.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		o.setVisible(true);
	}

}
