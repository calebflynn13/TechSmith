import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class is where we start everything. It creates the JFrame and the shell of the calculator
 */
public class Calculator extends JPanel {

    public static int WIDTH = 500;
    public static int HEIGHT = 800;
    public static int padding = 10;
    public static int DISPLAYHEIGHT=180;
    public Computer computer = new Computer();
    public static ArrayList<Button> buttons = new ArrayList<Button>();
    public static String display = "";

    public Calculator() {
        addMouseListener(new MouseActions());
    }

    private class MouseActions extends MouseAdapter {
        public void mouseClicked(MouseEvent e){
            Point p = e.getPoint();
            for (Button button : buttons)
            {
                if (button.clicked(p))
                {
                    computer.takeInput(button.value);
                    repaint();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();


        // create the window and setup things
        JFrame frame = new JFrame();
        frame.add(calculator);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        g.setColor(Color.gray);
        g.fillRoundRect(padding, padding, getWidth() - padding * 2, getHeight() - padding * 2, 30, 30);

        // buttons
        if (buttons.isEmpty()) {
            for (int i = 0; i <= 9; i++) {
                buttons.add(new Button("" + i, getWidth(), getHeight()));
            }
        }
        for (Button button : buttons) {
            button.paint(g);
        }

        // display
        g.setColor(Color.white);
        g.fillRoundRect(padding * 2, padding * 2, getWidth() - padding * 4, DISPLAYHEIGHT, 30, 30);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.drawString(display, padding * 2, DISPLAYHEIGHT - padding * 2);
    }
}
