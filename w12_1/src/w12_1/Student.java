package w12_1;

public class Student {
	public int speak(int m) throws MyException {
		if(m > 1000) {
			throw new MyException("��������1000");
		}
		return m;
	}
}
