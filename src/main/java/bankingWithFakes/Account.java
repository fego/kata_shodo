package bankingWithFakes;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Account {

  private List<Integer> amounts = new ArrayList<>();

  private Reporter reporter;

  public Account(Reporter reporter, List<Integer> amounts) {
    this.reporter = reporter;
  }

  public Account deposit(int amount) {
    return new Account(reporter, Stream.concat(amounts.stream(), Stream.of(amount)).toList());
  }

  public Account withdraw(int amount) {
    throw new UnsupportedOperationException("ko");
  }

  public int balance() {return amounts.stream().reduce(Integer::sum).orElse(0);
  }
}
