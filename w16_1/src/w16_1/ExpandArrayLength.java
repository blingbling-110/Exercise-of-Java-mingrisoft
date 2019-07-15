package w16_1;

import java.lang.reflect.*;

public class ExpandArrayLength {
	private int[] array = new int[] {1, 2, 3};
	
	public int[] getArray() {
		return this.array;
	}

	public void expand(int[] array, int length) {
		//���÷��䴴���µ������������ת��
		int[] newArray = (int[]) Array.newInstance(int.class, array.length + length);
		//��������Ԫ��
		System.arraycopy(array, 0, newArray, 0, array.length);
		this.array = newArray;
	}
	
	public static void main(String[] args) {
		ExpandArrayLength eal = new ExpandArrayLength();
		eal.expand(eal.getArray(), 3);
		for(int i: eal.getArray()) {
			System.out.print(i + " ");
		}
	}
}
