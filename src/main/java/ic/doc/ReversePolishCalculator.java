package ic.doc;

import java.util.Stack;
import javax.swing.*;

public class ReversePolishCalculator {

  private final Stack stack = new Stack();
  private ViewReversePolishCalculator viewReversePolishCalculator;

  public ReversePolishCalculator(ViewReversePolishCalculator viewReversePolishCalculator) {
    this.viewReversePolishCalculator = viewReversePolishCalculator;
  }

  public void addStack(int number) {
    System.out.println("add");
    stack.push(number);
    viewReversePolishCalculator.updateView(String.valueOf(number));
  }

  public void adding() {
    int first = (int) stack.pop();
    int second = (int) stack.pop();
    int result = first + second;
    stack.empty();
    System.out.println("here");
    viewReversePolishCalculator.updateView(String.valueOf(result));
  }

  public void subtracting() {
    int second = (int) stack.pop();
    int first = (int) stack.pop();
    int result = first - second;
    stack.empty();
    viewReversePolishCalculator.updateView(String.valueOf(result));
  }

}


