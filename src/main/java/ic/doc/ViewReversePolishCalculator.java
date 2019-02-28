package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Stack;

public class ViewReversePolishCalculator implements ActionListener {

  private final JButton one = new JButton("1");
  private final JButton two = new JButton("2");
  private final JButton three = new JButton("3");
  private final JButton four = new JButton("4");
  private final JButton addition = new JButton("+");
  private final JButton subtraction = new JButton("-");
  private final JTextField textField = new JTextField(10);
  private final Stack stack = new Stack();

  public ViewReversePolishCalculator() {

    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(300, 200);
    frame.setVisible(true);

    JPanel panel = new JPanel();
    panel.add(textField);

    panel.add(one);
    panel.add(two);
    panel.add(three);
    panel.add(four);
    panel.add(addition);
    panel.add(subtraction);

    one.addActionListener(this);
    two.addActionListener(this);
    three.addActionListener(this);
    four.addActionListener(this);
    addition.addActionListener(this);
    subtraction.addActionListener(this);

    frame.getContentPane().add(panel);
    frame.setVisible(true);

  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == one) {
    textField.setText("1");
    stack.push(1);
    }

    if(e.getSource() == two) {
      textField.setText("2");
      stack.push(2);
    }

    if(e.getSource() == three) {
      textField.setText("3");
      stack.push(3);
    }

    if(e.getSource() == four) {
      textField.setText("4");
      stack.push(4);
    }

    if(e.getSource() == addition) {
      int first = (int) stack.pop();
      int second = (int) stack.pop();
      int result = first + second;
      stack.empty();
      textField.setText(String.valueOf(result));
    }

    if(e.getSource() == subtraction) {
      int second = (int) stack.pop();
      int first = (int) stack.pop();
      int result = first - second;
      stack.empty();
      textField.setText(String.valueOf(result));
    }

  }

  public static void main(String args[]) {
    ViewReversePolishCalculator viewReversePolishCalculator = new ViewReversePolishCalculator();
  }


}
