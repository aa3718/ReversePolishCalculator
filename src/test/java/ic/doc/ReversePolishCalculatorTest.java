package ic.doc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.jmock.Expectations;
import org.junit.Rule;
import org.junit.Test;
import org.jmock.integration.junit4.JUnitRuleMockery;
import java.util.Stack;

public class ReversePolishCalculatorTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  private final Updatable viewReversePolishCalculator = context.mock(Updatable.class);
  private final ReversePolishCalculator reversePolishCalculator = new ReversePolishCalculator(viewReversePolishCalculator);

  @Test
  public void addAnElementToStack() {
    context.checking(
        new Expectations() {
          {
            exactly(1).of(viewReversePolishCalculator).updateView(String.valueOf(3));
          }
        });
    reversePolishCalculator.addStack(3);
    int val = (int) reversePolishCalculator.stack.peek();
    assertThat(val, is(3));
  }

  @Test
  public void performsAddingFunction() {
    context.checking(
        new Expectations() {
          {
            exactly(2).of(viewReversePolishCalculator).updateView(String.valueOf(3));
            exactly(1).of(viewReversePolishCalculator).updateView(String.valueOf(6));
          }
        });
    reversePolishCalculator.addStack(3);
    reversePolishCalculator.addStack(3);
    reversePolishCalculator.adding();
    assertThat(reversePolishCalculator.stack.empty(), is(true));
  }

  @Test
  public void performsSubtractingFunction() {
    context.checking(
        new Expectations() {
          {
            exactly(2).of(viewReversePolishCalculator).updateView(String.valueOf(3));
            exactly(1).of(viewReversePolishCalculator).updateView(String.valueOf(0));
          }
        });
    reversePolishCalculator.addStack(3);
    reversePolishCalculator.addStack(3);
    reversePolishCalculator.subtracting();
    assertThat(reversePolishCalculator.stack.empty(), is(true));
  }

}
