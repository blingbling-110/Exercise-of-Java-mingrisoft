package w16_1;

import java.lang.reflect.*;

public class ExpandArrayLength {
	private int[] array = new int[] {1, 2, 3};
	
	public int[] getArray() {
		return this.array;
	}

	public void expand(int[] array, int length) {
		//利用反射创建新的数组对象并向下转型
		int[] newArray = (int[]) Array.newInstance(int.class, array.length + length);
		//复制数组元素
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
