import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * This class is where we start everything. It creates the JFrame and the shell of the calculator
 */
public class Calculator extends Canvas{

    public static int WIDTH = 500;
    public static int HEIGHT = 800;
    public static int padding = 10;
    public static Computer computer = new Computer();

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();

        JFrame frame = new JFrame();
        frame.add(calculator);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        g.setColor(Color.gray);
        g.fillRoundRect(padding, padding, getWidth() - padding * 2, getHeight() - padding * 2, 10, 10);

        // buttons
        ArrayList<Button> buttons = new ArrayList<Button>();
        for (int i = 0; i <= 9; i++)
        {
            buttons.add(new Button("" + i, getWidth(), getHeight()));
        }
        for (Button button : buttons) {
            button.paint(g);
        }
    }
}
