package w9_3;

import java.math.BigDecimal;

public class W9_3 {

	public BigDecimal div(double v1, double v2, int scale) {
		if (scale < 0) {
			System.out.println("lֵ������ڵ���0");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		// ���ó�����������С�������scaleλ������������������������
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_DOWN);
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		W9_3 w = new W9_3();
		System.out.println("����֮�̱���4λС�������������������룺" 
				+ w.div(4.3, -2.7, 4));
	}

}
