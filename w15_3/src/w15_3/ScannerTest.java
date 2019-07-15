package w15_3;

import java.io.*;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		String inputStr = "";
		Scanner scanner = new Scanner(System.in);		//创建扫描器
		File file = new File("./用户资料.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter fw = new BufferedWriter(
					new FileWriter(file));
			while(!inputStr.equals("done")) {
				System.out.println("请输入用户名：");
				inputStr = scanner.next();				//获取用户输入
				if(inputStr.equals("done")) {
					continue;
				}else {
					fw.write("用户名：" + inputStr);
				}
				System.out.println("请输入密码：");
				inputStr = scanner.next();
				if(inputStr.equals("done")) {
					continue;
				}else {
					fw.write("\t密码：" + inputStr);
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
