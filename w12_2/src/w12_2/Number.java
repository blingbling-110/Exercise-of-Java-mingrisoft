package w12_2;

public class Number {
	public static int count(int a, int b) {
		return a * b;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			System.out.println(count(99999999, 88888888));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
