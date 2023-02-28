package bankingWithFakes;

public record Amount(int value) {
  public Amount negate() {
    return new Amount(-this.value);
  }
}