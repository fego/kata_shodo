package bankingWithFakes;


import java.util.ArrayList;
import java.util.List;

public class Account {

  private List<Integer> amounts = new ArrayList<>();

  private Reporter reporter;

  public Account(Reporter reporter) {
    this.reporter = reporter;
  }

  public Account deposit(int amount) {
    amounts.add(amount);
    return this;
  }

  public Account withdraw(int amount) {
    throw new UnsupportedOperationException("ko");
  }

  public int balance() {
    return amounts.get(0);
  }
}
