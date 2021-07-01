public class TestComputer {
    public static void main(String[] args)
    {
        basicTests();
        // TODO: DIVIDE BY ZERO
        // TODO: DIVISION FOR REPEATING DECIMAL LIKE 1/3 = 0.33333
    }

    public static void basicTests()
    {
        addition();
        subtraction();
        multiplication();
        division();
    }

    private static void division() {
        // 27 / 3 = 9
        Calculator calculator = new Calculator();
        calculator.computer.takeInput("27");
        calculator.computer.takeInput("/");
        calculator.computer.takeInput("3");
        calculator.computer.takeInput("=");
        if (!Calculator.display.equals("9.0")) throw new AssertionError("Division failed");
    }

    private static void multiplication() {
        // 5 * 4 = 20
        Calculator calculator = new Calculator();
        calculator.computer.takeInput("5");
        calculator.computer.takeInput("*");
        calculator.computer.takeInput("4");
        calculator.computer.takeInput("=");
        if (!Calculator.display.equals("20.0")) throw new AssertionError("Multiplication failed");
    }

    private static void subtraction() {
        // 5 - 9 = -4
        Calculator calculator = new Calculator();
        calculator.computer.takeInput("5");
        calculator.computer.takeInput("-");
        calculator.computer.takeInput("9");
        calculator.computer.takeInput("=");
        if (!Calculator.display.equals("-4.0")) throw new AssertionError("Subtraction failed");
    }

    public static void addition()
    {
        // 12 + 3 = 15
        Calculator calculator = new Calculator();
        calculator.computer.takeInput("1");
        calculator.computer.takeInput("2");
        calculator.computer.takeInput("+");
        calculator.computer.takeInput("3");
        calculator.computer.takeInput("=");
        if (!Calculator.display.equals("15.0")) throw new AssertionError("Addition failed");
    }

    public static void randomTest()
    {

    }
}
