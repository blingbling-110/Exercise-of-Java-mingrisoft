
public class w4_3 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		double sum = 0D;
		int i = 1;
		while(i < 21) {
			int j = i++;
			double mul = 1D;
			while(j > 1) {
				mul *= j--;
			}
			sum += 1 / mul;
		}
		System.out.println(sum);
	}

}
