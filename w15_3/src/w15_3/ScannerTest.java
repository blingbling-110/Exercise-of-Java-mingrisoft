package w15_3;

import java.io.*;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		String inputStr = "";
		Scanner scanner = new Scanner(System.in);		//����ɨ����
		File file = new File("./�û�����.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter fw = new BufferedWriter(
					new FileWriter(file));
			while(!inputStr.equals("done")) {
				System.out.println("�������û�����");
				inputStr = scanner.next();				//��ȡ�û�����
				if(inputStr.equals("done")) {
					continue;
				}else {
					fw.write("�û�����" + inputStr);
				}
				System.out.println("���������룺");
				inputStr = scanner.next();
				if(inputStr.equals("done")) {
					continue;
				}else {
					fw.write("\t���룺" + inputStr);
					fw.newLine();
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
