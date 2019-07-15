package w12_3;

public class Computer {
	public static int getGcd(int a, int b) throws MyException {
		if(a < 0 || b < 0) {
			throw new MyException("����Ĳ���Ϊ��");
		}
		int r = Math.min(a, b);
		a = Math.max(a, b);
		b = r;
		r = a % b;
		while(r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			System.out.println(getGcd(320, 1300));
			System.out.println(getGcd(-320, 1300));
		} catch(MyException e) {
			e.printStackTrace();
		}
	}

}
