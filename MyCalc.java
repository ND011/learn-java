import java.awt.*;
import java.awt.event.*;

class MyCalc extends WindowAdapter implements ActionListener {
    Frame f;
    Label l1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button badd, bsub, bmult, bdiv, bmod, bcalc, bclr, bpts, bneg, bback;
    double num1, num2, result;
    char operator;
    boolean isOperatorClicked = false;

    MyCalc() {
        f = new Frame("MY CALCULATOR");

        // Label
        l1 = new Label(" ", Label.RIGHT);
        l1.setBackground(Color.LIGHT_GRAY);
        l1.setBounds(50, 50, 260, 60);

        // Buttons
        b1 = new Button("1"); b2 = new Button("2"); b3 = new Button("3");
        b4 = new Button("4"); b5 = new Button("5"); b6 = new Button("6");
        b7 = new Button("7"); b8 = new Button("8"); b9 = new Button("9"); b0 = new Button("0");
        
        badd = new Button("+"); bsub = new Button("-"); bmult = new Button("*"); bdiv = new Button("/");
        bmod = new Button("%"); bcalc = new Button("="); bclr = new Button("C");
        bpts = new Button("."); bneg = new Button("±"); bback = new Button("←");
        
        // Positioning buttons
        int x = 50, y = 130, width = 50, height = 50;
        Button[] buttons = {b7, b8, b9, bdiv, b4, b5, b6, bmult, b1, b2, b3, bsub, b0, bpts, bcalc, badd, bclr, bmod, bneg, bback};
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(x, y, width, height);
            buttons[i].addActionListener(this);
            f.add(buttons[i]);

            x += 60;
            if ((i + 1) % 4 == 0) {
                x = 50;
                y += 60;
            }
        }

        // Adding components
        f.add(l1);
        f.setSize(350, 400);
        f.setLayout(null);
        f.setVisible(true);

        // Closing event
        f.addWindowListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            if (isOperatorClicked) {
                l1.setText("" + command);
                isOperatorClicked = false;
            } else {
                l1.setText(l1.getText() + command);
            }
        } else if (command.equals("C")) {
            l1.setText(" ");
            num1 = num2 = result = 0;
            isOperatorClicked = false;
        } else if (command.equals("±")) {
            if (!l1.getText().isEmpty() && !l1.getText().equals(" ")) {
                double value = Double.parseDouble(l1.getText());
                l1.setText("" + (-value));
            }
        } else if (command.equals("←")) {
            String text = l1.getText();
            if (!text.isEmpty()) {
                l1.setText(text.substring(0, text.length() - 1));
            }
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(l1.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
                case '%': result = num1 % num2; break;
            }
            l1.setText(num1 + " " + operator + " " + num2 + " = " + result);
        } else {
            num1 = Double.parseDouble(l1.getText());
            operator = command.charAt(0);
            isOperatorClicked = true;
            l1.setText(num1 + " " + operator);
        }
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public static void main(String[] args) {
        new MyCalc();
    }
}
