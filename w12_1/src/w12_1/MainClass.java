package w12_1;

public class MainClass {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Student s = new Student();
		try {
			s.speak(1995);
		} catch(MyException e) {
			e.printStackTrace();
		}
	}

}
