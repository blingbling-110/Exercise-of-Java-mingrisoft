package w9_2;

import java.text.DecimalFormat;

public class W9_2 {
/**
 * ��Բ����ķ���������������5λС��
 * @param r
 * 		Բ�뾶
 */
	public static void GetArea(double r) {
		double a = Math.PI * Math.pow(r, 2);
		DecimalFormat doFormat = new DecimalFormat("#.#####");
		System.out.println("Բ������ǣ�" + doFormat.format(a));
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		GetArea(43.58);
	}

}
