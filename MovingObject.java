import java.awt.*;
import java.awt.event.*;

public class MovingObject extends Frame implements KeyListener {
    private int x, y;
    private final int size = 50;
    private final int step = 10;
    private Label label, keyLabel;

    public MovingObject() {
        setTitle("Moving Object");
        setSize(400, 400);
        setLayout(null);
        setVisible(true);

        // Initialize object position
        x = 175; // Centering within 400x400
        y = 175;

        // Create Label for Moving Object
        label = new Label("Object");
        label.setBounds(x, y, size, size);
        label.setBackground(Color.CYAN);
        label.setAlignment(Label.CENTER);
        add(label);

        // Create Label for Key Press Display
        keyLabel = new Label("Key Pressed: ", Label.CENTER);
        keyLabel.setBounds(100, 300, 200, 50);
        keyLabel.setBackground(Color.LIGHT_GRAY);
        add(keyLabel);

        addKeyListener(this);
        
        // Window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyLabel.setText("Key Pressed: " + KeyEvent.getKeyText(keyCode));
        
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (y > 0) y -= step;
                break;
            case KeyEvent.VK_DOWN:
                if (y < getHeight() - size - 50) y += step;
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0) x -= step;
                break;
            case KeyEvent.VK_RIGHT:
                if (x < getWidth() - size - 20) x += step;
                break;
        }
        label.setLocation(x, y);
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new MovingObject();
    }
}
