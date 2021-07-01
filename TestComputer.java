public class TestComputer {
    public static void main(String[] args)
    {
        basicTests();
        chainResults();

        System.out.println("All tests passed :)");
        // ---- IDEAS ----- //
        // TODO: DIVIDE BY ZERO
        // TODO: DIVISION FOR REPEATING DECIMAL LIKE 1/3 = 0.33333. Needs to be rounded off
        // TODO: Better rounding in general
        // TODO: dynamic width/height screen
    }

    public static void basicTests()
    {
        addition();
        subtraction();
        multiplication();
        division();
    }

    /**
     * Take the previous equation as an input to the next equation. Then do a completely new equation and ignore the last result
     */
    public static void chainResults()
    {
        // 3 x 2 = 6 + 1 = 7. 3 + 2 = 5
        Calculator calculator = new Calculator();
        calculator.computer.takeInput("3");
        calculator.computer.takeInput("x");
        calculator.computer.takeInput("2");
        calculator.computer.takeInput("=");
        if (!Calculator.display.equals("6.0")) throw new AssertionError("Chain Result - first operation failed");

        // now add 1 to the previous result of 6.0
        calculator.computer.takeInput("+");
        calculator.computer.takeInput("1");
        calculator.computer.takeInput("=");
        if (!Calculator.display.equals("7.0")) throw new AssertionError("Chain Result - failed to use previous solution with next equation");

        calculator.computer.takeInput("3");
        calculator.computer.takeInput("+");
        calculator.computer.takeInput("2");
        calculator.computer.takeInput("=");
        if (!Calculator.display.equals("5.0")) throw new AssertionError("Chain Result - failed to ignore result of previous solution");
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
        calculator.computer.takeInput("x");
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
}
