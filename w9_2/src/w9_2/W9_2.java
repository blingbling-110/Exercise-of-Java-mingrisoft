package w9_2;

import java.text.DecimalFormat;

public class W9_2 {
/**
 * 求圆面积的方法，计算结果保留5位小数
 * @param r
 * 		圆半径
 */
	public static void GetArea(double r) {
		double a = Math.PI * Math.pow(r, 2);
		DecimalFormat doFormat = new DecimalFormat("#.#####");
		System.out.println("圆的面积是：" + doFormat.format(a));
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		GetArea(43.58);
	}

}
