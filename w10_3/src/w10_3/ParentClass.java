package w10_3;

public class ParentClass {

	public ParentClass() {		//��һ�������ø��๹�췽��
		System.out.println("ʵ��������");
		//ע�⣺�����Ѿ���д�˴˷������ʴ����������ʱӦ������������д�ķ���
		printpIndex();
	}

	int pIndex = 1;
	
	void printpIndex() {
		System.out.println("pIndex:" + pIndex);
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		new ParentClass();
		new ChildClass();
	}

}

class ChildClass extends ParentClass {
	
	public ChildClass() {		//���������������๹�췽��
		System.out.println("ʵ��������");
		printpIndex();
	}
	
	int cIndex = 2;		//�ڶ�������ʼ����Ա����
	
	//ע�⣺�����������ʱ��δ��ʼ����Ա����cIndex
	void printpIndex() {
		System.out.println("cIndex:" + cIndex);
	}
}