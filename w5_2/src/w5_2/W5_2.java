package w5_2;

public class W5_2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		StringBuilder str1 = new StringBuilder("Fire the hole");
		StringBuilder str2 = new StringBuilder("SHOW ME THE MONEY");
		if(str1.substring(5, 8).equalsIgnoreCase(str2.substring(8, 11))) {
			System.out.println("�����Ӵ���ͬ");
		}else {
			System.out.println("�����Ӵ�������ͬ");
		}
	}

}
