package bankingWithFakes;


public class Account {

  private Reporter reporter;

  public Account(Reporter reporter) {
    this.reporter = reporter;
  }

  public Account deposit(int amount) {
    return this;
  }

  public Account withdraw(int amount) {
    throw new UnsupportedOperationException("ko");
  }

  public int balance() {
    return 100;
  }
}
