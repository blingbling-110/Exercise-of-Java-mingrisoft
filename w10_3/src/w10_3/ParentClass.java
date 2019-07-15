package w10_3;

public class ParentClass {

	public ParentClass() {		//第一步：调用父类构造方法
		System.out.println("实例化父类");
		//注意：子类已经重写了此方法，故创建子类对象时应调用子类中重写的方法
		printpIndex();
	}

	int pIndex = 1;
	
	void printpIndex() {
		System.out.println("pIndex:" + pIndex);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		new ParentClass();
		new ChildClass();
	}

}

class ChildClass extends ParentClass {
	
	public ChildClass() {		//第三步：调用子类构造方法
		System.out.println("实例化子类");
		printpIndex();
	}
	
	int cIndex = 2;		//第二步：初始化成员变量
	
	//注意：创建子类对象时还未初始化成员变量cIndex
	void printpIndex() {
		System.out.println("cIndex:" + cIndex);
	}
}