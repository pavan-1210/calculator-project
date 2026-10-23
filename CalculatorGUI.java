import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private CalculatorService calc = new CalculatorService();
    private double num1 = 0, num2 = 0;
    private char operator;

    public CalculatorGUI() {
        // Window Setup
        setTitle("Java Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display Field
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Button Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.PLAIN, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            display.setText(display.getText() + cmd);
        } else if (cmd.equals("C")) {
            display.setText("");
        } else if (cmd.equals("=")) {
            calculate();
        } else {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = cmd.charAt(0);
                display.setText("");
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
    }

    private void calculate() {
        try {
            num2 = Double.parseDouble(display.getText());
            double result = switch (operator) {
                case '+' -> calc.add(num1, num2);
                case '-' -> calc.subtract(num1, num2);
                case '*' -> calc.multiply(num1, num2);
                case '/' -> calc.divide(num1, num2);
                default -> 0;
            };
            display.setText(String.format("%.2f", result));
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
