package w6_1;

import java.util.Arrays;

public class w6_1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int arr1[] = new int[]{1, 2, 3, 4, 5};
		int arr2[] = Arrays.copyOfRange(arr1, 0, 4);
		w6_1 sorter = new w6_1();
		System.out.print("arr1:");
		sorter.showArray(arr1);
		System.out.print("\narr2:");
		sorter.showArray(arr2);
		
	}

	public void showArray(int arr[]) {
		for(int e: arr) {
			System.out.print(e + " ");
		}
	}
}
