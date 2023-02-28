package bankingWithFakes;


import bankingWithFakes.Operation.OperationType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Account {

  private List<Operation> operations = new ArrayList<>();

  private Reporter reporter;

  public Account(final Reporter reporter) {
    this.reporter = reporter;
  }

  public Account(Reporter reporter, List<Operation> operations) {
    this.reporter = reporter;
    this.operations = operations;
  }

  public Account deposit(final Amount amount) {
    return new Account(reporter,
        Stream.concat(operations.stream(), Stream.of(new Operation(amount, OperationType.CREDIT)))
            .toList());
  }

  public Account withdraw(Amount amount) {
    return new Account(reporter,
        Stream.concat(operations.stream(), Stream.of(new Operation(amount, OperationType.DEBIT)))
            .toList()
    );
  }

  public int balance() {
    return operations.stream().mapToInt(Operation::value).reduce(Integer::sum).orElse(0);
  }
}
