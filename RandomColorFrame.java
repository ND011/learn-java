import java.awt.*;  
import java.awt.event.*;  
import java.util.Random;  

public class RandomColorFrame extends Frame implements ActionListener {  
    Button changeColorButton;  
    Random random;  

    public RandomColorFrame() {  
        // Initialize frame  
        setTitle("Random Color Changer");  
        setSize(400, 300);  
        setLayout(new FlowLayout());  
        setVisible(true);  

        // Initialize random generator  
        random = new Random();  

        // Button to change background color  
        changeColorButton = new Button("Change Color");  
        changeColorButton.addActionListener(this);  
        add(changeColorButton);  

        // Close window on click  
        addWindowListener(new WindowAdapter() {  
            @Override  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
    }  

    // Generate a random color  
    public Color getRandomColor() {  
        int r = random.nextInt(256);  
        int g = random.nextInt(256);  
        int b = random.nextInt(256);  
        return new Color(r, g, b);  
    }  

    // Handle button click event  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        setBackground(getRandomColor());  
    }  

    public static void main(String[] args) {  
        new RandomColorFrame();  
    }  
}
