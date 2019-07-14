package w7_2;

public class W7_2 {

	private double length;
	private double width;

	public W7_2(double x, double y) {
		this.length = x;
		this.width = y;
	}

	public double getArea() {
		return length * width;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		W7_2 rectangle = new W7_2(5.5, 2.2);
		System.out.println(rectangle.getArea());
	}

}
