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
        DIVIDE,
        NEGATIVE
    }

    public Computer() {
        this.leftValue = "";
        this.rightValue = "";
        this.prevInput = "";
    }

    public static double compute(double leftValue, double rightValue, CommandOptions command)
    {
        double result = 0;
        switch (command)
        {
            case ADD: result = leftValue + rightValue;
                break;
            case SUBTRACT: result = leftValue - rightValue;
                break;
            case MULTIPLY: result = leftValue * rightValue;
                break;
            case DIVIDE: result = leftValue / rightValue;
                break;
        }

        result *= 100000000;
        result = Math.round(result);
        result /= 100000000;
        return result;
    }

    /**
     * When a button is clicked, we send it here to modify the computer variables
     * @param input The string representing what button as pressed.
     */
    public void takeInput(String input)
    {
        if (isNumeric(input) || input.equals("."))
        {
            if (prevInput.contains(".") && input.equals("."))
            {
                return; // don't allow multiple decimals
            }
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
            else if(input.equals("+/-")) {
                this.prevInput = "" + (Double.parseDouble(this.prevInput) * -1);
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
