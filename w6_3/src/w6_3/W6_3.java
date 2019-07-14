package w6_3;

import java.util.Arrays;

public class W6_3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String arr[] = new String[] {"1995", "01", "10"};
		W6_3 shower = new W6_3();
		shower.showArray(arr);
		Arrays.fill(arr, 2, 3, "bb");
		shower.showArray(arr);
	}

	public void showArray(String arr[]) {
		for(String e: arr) {
			System.out.print(e + " ");
		}
		System.out.println("");
	}
}
