package w12_1;

public class MainClass {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Student s = new Student();
		try {
			s.speak(1995);
		} catch(MyException e) {
			e.printStackTrace();
		}
	}

}
