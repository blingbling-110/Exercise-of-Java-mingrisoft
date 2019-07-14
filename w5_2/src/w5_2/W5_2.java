package w5_2;

public class W5_2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		StringBuilder str1 = new StringBuilder("Fire the hole");
		StringBuilder str2 = new StringBuilder("SHOW ME THE MONEY");
		if(str1.substring(5, 8).equalsIgnoreCase(str2.substring(8, 11))) {
			System.out.println("两个子串相同");
		}else {
			System.out.println("两个子串并不相同");
		}
	}

}
