package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiApp {
  private ViewReversePolishCalculator viewReversePolishCalculator =
      new ViewReversePolishCalculator(new NumberController(), new OperationController());
  private ReversePolishCalculator reversePolishCalculator =
      new ReversePolishCalculator(viewReversePolishCalculator);

  public class NumberController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

      String value = actionEvent.getActionCommand();

      if (value == "1") {
        reversePolishCalculator.addStack(1);
      }

      if (value == "2") {
        reversePolishCalculator.addStack(2);
      }

      if (value == "3") {
        reversePolishCalculator.addStack(3);
      }

      if (value == "4") {
        reversePolishCalculator.addStack(4);
      }
    }
  }

  public class OperationController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

      String value = actionEvent.getActionCommand();

      if (value == "+") {
        reversePolishCalculator.adding();
      }

      if (value == "-") {
        reversePolishCalculator.subtracting();
      }
    }
  }

  public static void main(String args[]) {
    new GuiApp();
  }
}
