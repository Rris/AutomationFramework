import get.GetX;

public class Example {
	public static void main(String[] args) {
		GetX getX = new GetX();
		int a = getX.getValue(10);
		int b = getX.getValue(2);
		CalculatorFactory calFactory = new CalculatorFactory();
		Calculator cal1 = calFactory.execute("add");
		System.out.println(cal1.operator(a, b));
		Calculator cal2 = calFactory.execute("Subtract");
		System.out.println(cal2.operator(a, b));
		Calculator cal3 = calFactory.execute("MULTIPLY");
		System.out.println(cal3.operator(a, b));
		Calculator cal4 = calFactory.execute("dIvIdE");
		System.out.println(cal4.operator(a, b));
	}
}
