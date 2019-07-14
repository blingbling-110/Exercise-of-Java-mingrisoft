package w6_2;

//import java.util.Arrays;

public class W6_2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int arr[] = new int[] {10, 5, 7, 2, 1};
		W6_2 sorter = new W6_2();
		//Arrays.sort(arr);
		sorter.doBubbleSort(arr);
		//sorter.showArray(arr);
		System.out.println("数组中最小的数是：" + arr[0]);
	}

	public void doBubbleSort(int arr[]) {
		for(int priIdx = arr.length - 1; priIdx > 0; priIdx--) {
			for(int cycIdx = 0; cycIdx < priIdx; cycIdx++) {
				if(arr[cycIdx] > arr[cycIdx + 1]) {
					int temp = arr[cycIdx];
					arr[cycIdx] = arr[cycIdx + 1];
					arr[cycIdx + 1] = temp;
				}
			}
		}
	}
	
	public void showArray(int arr[]) {
		for(int e: arr) {
			System.out.print(e + " ");
		}
		System.out.println("");
	}
}
