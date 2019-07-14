
public class w4_2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int i, j;
		String temp = "";
		for(i = 0; i < 9; i++) {
			for(j = 0; j < 9; j++) {
				if(i < 5) {
					if((j < 4 - i)||(j > 4 + i)) {
						temp += " ";
					}else {
						temp += "*";
					}
				}else {
					if((j < i - 4)||(j > 12 - i)) {
						temp += " ";
					}else {
						temp += "*";
					}
				}
			}
			System.out.println(temp);
			temp = "";
		}
	}

}
