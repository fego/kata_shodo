package bankingWithFakes;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Account {

  private List<Amount> amounts = new ArrayList<>();

  private Reporter reporter;

  public Account(Reporter reporter, List<Amount> amounts) {
    this.reporter = reporter;
    this.amounts = amounts;
  }


  public Account deposit(final Amount amount) {
    return new Account(reporter,
        Stream.concat(amounts.stream(), Stream.of(amount)).toList());
  }

  public Account withdraw(Amount amount) {
    return new Account(reporter,
        Stream.concat(amounts.stream(), Stream.of(-amount)).toList());
  }

  public int balance() {
    return amounts.stream().mapToInt().reduce(Integer::sum).orElse(0);
  }
}
