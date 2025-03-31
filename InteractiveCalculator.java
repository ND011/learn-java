import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class InteractiveCalculator extends Frame implements KeyListener, MouseListener {
    private int x, y;
    private final int size = 25; // Pointer size reduced to half
    private final int step = 10;
    private Label label, keyLabel;
    private Button[] buttons;
    private Random random;
    private double num1, num2, result;
    private char operator;
    private boolean isOperatorClicked = false;
    private Label display;
    private String input = "";
    private String expression = "";
    private boolean isResultDisplayed = false;

    public InteractiveCalculator() {
        setTitle("Interactive Calculator");
        setSize(500, 600); // Auto resize window
        setLayout(null);
        setVisible(true);
        random = new Random();

        // Initialize object position
        x = 175; 
        y = 50;

        // Create Label for Moving Object Pointer
        label = new Label("Pointer");
        label.setBounds(x, y, size, size);
        label.setBackground(Color.RED);
        label.setAlignment(Label.CENTER);
        add(label);

        // Create Display Label
        display = new Label("", Label.RIGHT);
        display.setBounds(50, 50, 380, 60);
        display.setBackground(Color.LIGHT_GRAY);
        add(display);

        // Create Label for Key Press Display
        keyLabel = new Label("Key Pressed: ", Label.CENTER);
        keyLabel.setBounds(100, 500, 300, 50);
        keyLabel.setBackground(Color.LIGHT_GRAY);
        add(keyLabel);

        // Calculator Buttons
        String[] buttonLabels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "C", "←"};
        buttons = new Button[buttonLabels.length];
        
        int bx = 50, by = 130, bwidth = 70, bheight = 50;
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new Button(buttonLabels[i]);
            buttons[i].setBounds(bx, by, bwidth, bheight);
            buttons[i].addMouseListener(this);
            add(buttons[i]);

            bx += 90;
            if ((i + 1) % 4 == 0) {
                bx = 50;
                by += 60;
            }
        }

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
            case KeyEvent.VK_ENTER:
                checkButtonPress();
                break;
        }
        label.setLocation(x, y);
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void checkButtonPress() {
        for (Button btn : buttons) {
            Rectangle btnBounds = btn.getBounds();
            Rectangle pointerBounds = label.getBounds();
            if (btnBounds.intersects(pointerBounds)) {
                btn.setBackground(getRandomColor());
                handleButtonClick(btn.getLabel());
                break;
            }
        }
    }

    public void handleButtonClick(String command) {
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            if (isResultDisplayed) {
                input = "";
                expression = "";
                isResultDisplayed = false;
            }
            if (command.equals(".") && input.contains(".")) return;
            input += command;
            expression += command;
            display.setText(expression);
        } else if (command.equals("C")) {
            input = "";
            expression = "";
            num1 = num2 = result = 0;
            operator = ' ';
            display.setText(expression);
        } else if (command.equals("←")) {
            if (!input.isEmpty()) {
                input = input.substring(0, input.length() - 1);
                expression = expression.substring(0, expression.length() - 1);
                display.setText(expression);
            }
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(input);
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num2 != 0 ? num1 / num2 : 0; break;
            }
            expression += " = " + result;
            display.setText(expression);
            input = String.valueOf(result);
            num1 = result;
            isResultDisplayed = true;
        } else {
            if (isResultDisplayed) {
                num1 = result;
                expression = input + " " + command + " ";
            } else {
                num1 = Double.parseDouble(input);
                expression += " " + command + " ";
            }
            operator = command.charAt(0);
            input = "";
            display.setText(expression);
            isResultDisplayed = false;
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        new InteractiveCalculator();
    }
}
