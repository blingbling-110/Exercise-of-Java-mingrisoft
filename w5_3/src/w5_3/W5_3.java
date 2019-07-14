package w5_3;

public class W5_3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		/*	大陆手机号前三位：130、131、132、133、134、135、136、137、138、139、150、151、
		 * 152、153、155、156、157、158、159、180、185、186、187、188、189	*/
		String text = "15477360055";
		String regex = "1(3\\d|5[^4]|8[^1234])\\d{8}";
		System.out.println(text.matches(regex));
	}

}
