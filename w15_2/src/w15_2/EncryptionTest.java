package w15_2;

import java.io.*;
import java.util.Arrays;

public class EncryptionTest {

	public static void main(String[] args) {
		EncryptionTest encrypter = new EncryptionTest();
		encrypter.encrypt("����һֻСë¿���Ҵ���Ҳ���", "./Encryption.txt");
		encrypter.decrypt("./Encryption.txt", "./Decryption.txt");
	}

	private void decrypt(String inputPath, String outputPath) {
		try {
			File inputFile = new File(inputPath);
			FileReader fr = new FileReader(inputFile);
			File outputFile = new File(outputPath);
			FileWriter fw = new FileWriter(outputFile);
			int charLength = 0, tmpChar = 0;
			char[] contentChar = new char[1024];
			while((tmpChar = fr.read()) != -1) {
				//���ַ��ͱ������н���
				contentChar[charLength] = (char) (tmpChar - '@');
				charLength++;
			}
			//����Arrays���copyOfRange������ȡ����
			String contentStr = new String(Arrays.copyOfRange(
					contentChar, 0, charLength));
			System.out.println(contentStr);
			fw.write(contentStr);
			fr.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void encrypt(String contentStr, String outputPath) {
		try {
			File outputFile = new File(outputPath);
			FileWriter fw = new FileWriter(outputFile);
			if(!outputFile.exists()) {
				outputFile.createNewFile();
			}
			//���ַ���ת��Ϊ�ַ������Ա����
			char[] contentChar = contentStr.toCharArray();
			for(int i = 0; i < contentChar.length; i++) {
				//���ַ��ͱ������м���
				contentChar[i] = (char) (contentChar[i] + '@');
			}
			String EncStr =new String(contentChar);
			System.out.println(EncStr);
			fw.write(EncStr);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
