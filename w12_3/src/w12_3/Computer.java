package w12_3;

public class Computer {
	public static int getGcd(int a, int b) throws MyException {
		if(a < 0 || b < 0) {
			throw new MyException("输入的参数为负");
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
		// TODO 自动生成的方法存根
		try {
			System.out.println(getGcd(320, 1300));
			System.out.println(getGcd(-320, 1300));
		} catch(MyException e) {
			e.printStackTrace();
		}
	}

}
