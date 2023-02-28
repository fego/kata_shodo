package bankingWithFakes;

public record Operation(Amount amount, OperationType operationType) {

  public int value() {
    return operationType == OperationType.CREDIT ? amount().value() : -amount.value();
  }

  public enum OperationType {
    DEBIT,CREDIT;
  }
}
