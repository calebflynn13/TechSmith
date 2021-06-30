import java.awt.*;
import javax.swing.JFrame;

/**
 * This class is where we start everything. It creates the JFrame and the shell of the calculator
 */
public class Calculator extends Canvas{

    public static int WIDTH = 500;
    public static int HEIGHT = 800;
    public static int padding = 10;

    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        g.setColor(Color.gray);
        g.fillRoundRect(padding, padding, getWidth() - padding * 2, getHeight() - padding * 2, 10, 10);
    }

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        JFrame frame = new JFrame();
        frame.add(calculator);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}
