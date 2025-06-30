import javax.swing.*;
import java.awt.*;

class Windows extends JFrame {
    double firstNumber;
    String operator;

    JPanel panel = new JPanel(new GridLayout(4, 4, 5,5));
    JTextField textField = new JTextField();
    Container container;

    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");
    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    JButton num0 = new JButton("0");

    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton div = new JButton("/");
    JButton mul = new JButton("x");

    JButton equal = new JButton("=");
    JButton clear = new JButton("C");

    public Windows(){
        setSize(300,400);
        setTitle("Simple Basic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(true);
        setLocationRelativeTo(null);
        container = getContentPane();

        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        panel.add(num7); panel.add(num8); panel.add(num9); panel.add(div);
        panel.add(num4); panel.add(num5); panel.add(num6); panel.add(mul);
        panel.add(num1); panel.add(num2); panel.add(num3); panel.add(sub);
        panel.add(num0); panel.add(clear);panel.add(equal);panel.add(add);

        container.add(panel);


        Font btnFont = new Font("Arial", Font.BOLD, 18);
        for (Component c : panel.getComponents()) {
            if (c instanceof JButton) {
                c.setFont(btnFont);
            }
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);

        num1.addActionListener(e -> textField.setText(textField.getText() + "1"));
        num2.addActionListener(e -> textField.setText(textField.getText() + "2"));
        num3.addActionListener(e -> textField.setText(textField.getText() + "3"));
        num4.addActionListener(e -> textField.setText(textField.getText() + "4"));
        num5.addActionListener(e -> textField.setText(textField.getText() + "5"));
        num6.addActionListener(e -> textField.setText(textField.getText() + "6"));
        num7.addActionListener(e -> textField.setText(textField.getText() + "7"));
        num8.addActionListener(e -> textField.setText(textField.getText() + "8"));
        num9.addActionListener(e -> textField.setText(textField.getText() + "9"));
        num0.addActionListener(e -> textField.setText(textField.getText() + "0"));

        add.addActionListener(
                e -> {
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = "+";
                    textField.setText("");
                }
        );

        sub.addActionListener(
                e -> {
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = "-";
                    textField.setText("");
                }
        );

        div.addActionListener(
                e -> {
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = "/";
                    textField.setText("");
                }
        );

        mul.addActionListener(
                e -> {
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = "x";
                    textField.setText("");
                }
        );

        clear.addActionListener(
                e -> {
                    textField.setText("");
                    firstNumber = 0;
                    operator = null;
                });

        equal.addActionListener(
                e -> {
                    double secondNumber = Double.parseDouble(textField.getText()); //Turns 2 into "2.0"
                    double result = 0;

                    switch(operator){
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "x":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            result = firstNumber / secondNumber;
                            break;
                        default:
                            textField.setText( "Wrong Input Value ! ");
                    }

                    textField.setText(String.valueOf(result));

                }
        );
    }
}
public class Main {
    public static void main(String[] args) {
        new Windows();
    }
}
