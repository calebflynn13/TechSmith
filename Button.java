import java.awt.*;

public class Button {
    private int x, y, width, height;
    public String value;

    public Button(String strValue, int screenWidth, int screenHeight)
    {
        int value = Integer.parseInt(strValue);
        if (value == 0)
        {
            this.x = ((screenWidth - 150) / 3) + 20;
            this.y = 300 + 120 * 3;
        }
        else
        {
            this.x = ((value - 1) % 3) * ((screenWidth - 150) / 3) + 20;
            this.y = 300 + 120 * ((value - 1) / 3);
        }
        this.width = 100;
        this.height = 100;
        this.value = strValue;
    }

    public void paint(Graphics g)
    {
        int fontSize = 50;
        g.setColor(Color.white);
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
