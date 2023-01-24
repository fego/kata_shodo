package bankingWithFakes;

public record Amount(int value) {

  public Amount {
    if (value < 0) {
      throw new IllegalArgumentException("< 0");
    }
  }
}