package w10_2;

public class ParentClass {

	void firstFcn() {
		System.out.println("���෽��һ");
	}

	void secondFcn() {
		System.out.println("���෽����");
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		ChildClass c = new ChildClass();
		ParentClass p = c;
		p.secondFcn();
	}

}

class ChildClass extends ParentClass {
	
	void secondFcn() {
		System.out.println("���෽����");
	}
}