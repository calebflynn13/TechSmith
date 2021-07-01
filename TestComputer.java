public class TestComputer {
    public static void main(String[] args)
    {
        addition();
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
