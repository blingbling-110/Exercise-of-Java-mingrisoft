package w9_3;

import java.math.BigDecimal;

public class W9_3 {

	public BigDecimal div(double v1, double v2, int scale) {
		if (scale < 0) {
			System.out.println("l值必须大于等于0");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		// 调用除法方法，商小数点后保留scale位，并将结果进行四舍五入操作
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_DOWN);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		W9_3 w = new W9_3();
		System.out.println("两数之商保留4位小数并进行向下四舍五入：" 
				+ w.div(4.3, -2.7, 4));
	}

}
