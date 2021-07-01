public class Computer {

    public String leftValue;
    public String rightValue;
    private String prevInput;
    private CommandOptions command;
    private Direction direction; // this represents which value we are in the process of populating. Ex: (left + right)

    private enum Direction {
        LEFT,
        RIGHT
    }

    public static enum CommandOptions {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    public Computer() {
        this.leftValue = "";
        this.rightValue = "";
        this.prevInput = "";
        this.direction = Direction.LEFT;
    }

    public static double compute(double leftValue, double rightValue, CommandOptions command)
    {
        switch (command)
        {
            case ADD: return leftValue + rightValue;
            case SUBTRACT: return leftValue - rightValue;
            case MULTIPLY: return leftValue * rightValue;
            case DIVIDE: return leftValue / rightValue;
        }
        return 0;
    }

    /**
     * When a button is clicked, we send it here to modify the computer variables
     * @param input The string representing what button as pressed.
     */
    public void takeInput(String input)
    {
        if (isNumeric(input))
        {
            this.prevInput += input;
            Calculator.display = this.prevInput;
        }
        else {
            // input is a command
            if (input.equals("="))
            {
                this.rightValue = this.prevInput;
                this.prevInput = "";
                Calculator.display = "" + compute(Double.parseDouble(leftValue), Double.parseDouble(rightValue), command);
                this.leftValue = Calculator.display; // this accounts for the possibility that we to use the result for something
            }
            else {
                this.leftValue = this.prevInput;
                this.prevInput = "";
                switch(input)
                {
                    case "+":
                        command = CommandOptions.ADD;
                        break;
                    case "-":
                        command = CommandOptions.SUBTRACT;
                        break;
                    case "*":
                        command = CommandOptions.MULTIPLY;
                        break;

                    case "/":
                        command = CommandOptions.DIVIDE;
                        break;
                }
            }
        }
    }

    public static boolean isNumeric(String str)
    {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
}
