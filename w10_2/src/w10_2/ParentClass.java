package w10_2;

public class ParentClass {

	void firstFcn() {
		System.out.println("父类方法一");
	}

	void secondFcn() {
		System.out.println("父类方法二");
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		ChildClass c = new ChildClass();
		ParentClass p = c;
		p.secondFcn();
	}

}

class ChildClass extends ParentClass {
	
	void secondFcn() {
		System.out.println("子类方法二");
	}
}