
public class CalculatorFactory {
	Calculator execute(String operator) {
		if (operator.equalsIgnoreCase("ADD")) {
			return new Add();
		} else if (operator.equalsIgnoreCase("SUBTRACT")) {
			return new Subtract();
		} else if (operator.equalsIgnoreCase("MULTIPLY")) {
			return new Multiply();
		} else {
			return new Divide();
		}
	}
}
