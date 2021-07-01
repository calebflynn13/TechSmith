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
    public static int PADDING = 10;
    public static int DISPLAYHEIGHT=150;
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
                    System.out.println(button.value);
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
        g.fillRoundRect(PADDING, PADDING, getWidth() - PADDING * 2, getHeight() - PADDING * 2, 30, 30);

        // buttons
        if (buttons.isEmpty()) {
            for (int i = 0; i <= 9; i++) {
                buttons.add(new Button("" + i));
            }
            buttons.add(new Button("/"));
            buttons.add(new Button("x"));
            buttons.add(new Button("-"));
            buttons.add(new Button("+"));
            buttons.add(new Button("="));
        }
        for (Button button : buttons) {
            button.paint(g);
        }

        // display
        g.setColor(Color.white);
        g.fillRoundRect(PADDING * 2, PADDING * 2, getWidth() - PADDING * 4, DISPLAYHEIGHT, 30, 30);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.drawString(display, PADDING * 2, DISPLAYHEIGHT - PADDING * 2);
    }
}
