package w6_4;

public class W6_4 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		int arr[][] = new int[][] {
			{1, 2, 3}, {4, 5, 6}, {7, 8, 9}
		};
		W6_4 transposer = new W6_4();
		System.out.println("转置前：");
		transposer.showArray(arr);
		transposer.transpose(arr);
		System.out.println("转置后：");
		transposer.showArray(arr);
	}

	public void transpose(int arr[][]) {
		for(int row = 0; row < arr.length; row++) {
			for(int column = row + 1; column < arr[row].length; column++) {
				int temp = arr[row][column];
				arr[row][column] = arr[column][row];
				arr[column][row] = temp;
			}
		}
	}
	
	public void showArray(int arr[][]) {
		for(int subarr[]: arr) {
			for(int e: subarr) {
				System.out.print(e + " ");
			}
			System.out.println("");
		}
	}
}
