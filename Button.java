import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Button {
    private int x, y, width, height;
    private Color color;
    public String value;

    public static ArrayList<String> ALLOWEDBUTTONS  = new ArrayList<String>(Arrays.asList(
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "/",
            "*",
            "x",
            "-",
            "+",
            "=",
            "."
    ));

    public Button(String strValue)
    {
        if (Computer.isNumeric(strValue))
        {
            buildNumberButton(strValue);
        }
        else {
            switch(strValue)
            {
                case "/":
                    this.buildCommandButton("/", 3, 0);
                    break;
                case "x":
                    this.buildCommandButton("x", 3, 1);
                    break;
                case "-":
                    this.buildCommandButton("-", 3, 2);
                    break;
                case "+":
                    this.buildCommandButton("+", 3, 3);
                    break;
                case "=":
                    this.buildCommandButton("=", 3, 4);
                    break;
                case ".":
                    this.buildCommandButton(".", 2, 4);
                    break;
                case "+/-":
                    this.buildCommandButton("+/-", 2, 0);
                    break;
            }
        }

        this.width = 100;
        this.height = 100;
        this.value = strValue;
    }

    public void buildNumberButton(String strValue)
    {
        this.color = Color.white;
        int value = Integer.parseInt(strValue);
        if (value == 0)
        {
            this.x = this.getX(1);
            this.y = this.getY(4);
        }
        else
        {
            this.x = this.getX((value - 1) % 3);
            this.y = this.getY(((value - 1) / 3) + 1);
        }
    }

    public void buildCommandButton(String strValue, int col, int row)
    {
        this.color = Color.orange;
        this.x = this.getX(col);
        this.y = this.getY(row);
    }

    /**
     * Gets the x coordinate for the button given the column (0-3) on the calculator
     * @param col
     * @return x coordinate for teh button
     */
    private int getX(int col)
    {
        return col * 117 + Calculator.PADDING * 2;
    }

    /**
     * Gets the y coordinate for the button given the column (0-4) on the calculator
     * @param row
     * @return y coordinate for teh button
     */
    private int getY(int row)
    {
        return (Calculator.PADDING * 4 + Calculator.DISPLAY_HEIGHT) + row * 117;
    }

    public void paint(Graphics g)
    {
        int fontSize = 50;
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, fontSize));
        g.drawString(value, x + width / 2 - fontSize / 4, y + height / 2 + fontSize / 4);
    }

    public boolean clicked(Point p)
    {
        return (p.x >= this.x && p.x <= this.x + this.width && p.y >= this.y && p.y <= this.y + height);
    }
}
