package ic.doc;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewReversePolishCalculator implements Updatable {

  public final JButton one = new JButton("1");
  public final JButton two = new JButton("2");
  public final JButton three = new JButton("3");
  public final JButton four = new JButton("4");
  public final JButton addition = new JButton("+");
  public final JButton subtraction = new JButton("-");
  public final JTextField textField = new JTextField(10);

  public ViewReversePolishCalculator(
      ActionListener numberController, ActionListener operationController) {

    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(300, 200);

    JPanel panel = new JPanel();
    panel.add(textField);

    panel.add(one);
    panel.add(two);
    panel.add(three);
    panel.add(four);
    panel.add(addition);
    panel.add(subtraction);

    one.addActionListener(numberController);
    two.addActionListener(numberController);
    three.addActionListener(numberController);
    four.addActionListener(numberController);
    addition.addActionListener(operationController);
    subtraction.addActionListener(operationController);

    frame.getContentPane().add(panel);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void updateView(String value) {
    textField.setText(value);
  }
}
