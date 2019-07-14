package w9_1;

public class W9_1 {

	public int[] genNum() {
		int arr[] = new int[6];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 2 + (int)(Math.random() * 29);
			if(arr[i] % 2 == 1) {
				arr[i]++;
			}
		}
		return arr;
	}
	
	public int prtSum(int arr[]) {
		int sum = 0;
		for(int e: arr) {
			sum += e;
		}
		return sum;
	}
	
	public void showArr(int arr[]) {
		for(int e: arr) {
			System.out.print(e + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		W9_1 exm = new W9_1();
		int arr1[] = exm.genNum();
		System.out.print("获取2~32之间的6个偶数：");
		exm.showArr(arr1);
		System.out.println("取得它们的和：" 
				+ exm.prtSum(arr1));
	}

}
