package ic.doc;

import java.util.Stack;

public class ReversePolishCalculator {

  public final Stack stack = new Stack();
  public final Updatable viewReversePolishCalculator;

  public ReversePolishCalculator(Updatable viewReversePolishCalculator) {
    this.viewReversePolishCalculator = viewReversePolishCalculator;
  }

  public void addStack(int number) {
    stack.push(number);
    viewReversePolishCalculator.updateView(String.valueOf(number));
  }

  public void adding() {
    int first = (int) stack.pop();
    int second = (int) stack.pop();
    int result = first + second;
    stack.empty();
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
