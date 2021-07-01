public class Computer {

    public String leftValue;
    public String rightValue;
    private String prevInput;    // represents the last digit that was typed
    private String prevSolution; // represents the solution to the previous equation
    private CommandOptions command;

    public enum CommandOptions {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    public Computer() {
        this.leftValue = "";
        this.rightValue = "";
        this.prevInput = "";
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
                // quit early if we don't have all the correct inputs
                if (this.leftValue.equals("")||this.prevInput.equals("")||this.command == null)
                {
                    return;
                }
                this.rightValue = this.prevInput;
                this.prevInput = "";
                Calculator.display = "" + compute(Double.parseDouble(leftValue), Double.parseDouble(rightValue), command);
                this.prevSolution = Calculator.display; // this accounts for the possibility that we to use the result for a future operation
                this.command = null;
            }
            else {
                if (this.prevInput.equals(""))
                {
                    this.leftValue = this.prevSolution;
                }
                else {
                    this.leftValue = this.prevInput;
                }
                this.prevInput = "";

                switch(input)
                {
                    case "+":
                        this.command = CommandOptions.ADD;
                        break;
                    case "-":
                        this.command = CommandOptions.SUBTRACT;
                        break;
                    case "x":
                        this.command = CommandOptions.MULTIPLY;
                        break;
                    case "/":
                        this.command = CommandOptions.DIVIDE;
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
