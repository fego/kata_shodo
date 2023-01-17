package bankingWithFakes;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void whenDepositIs100_thenBalanceIs100() {
    // Give,
    Account account = new Account(new FakeReporter());
    // When
    account.deposit(100);
    // Then
    Assertions.assertThat(account.balance()).isEqualTo(100);
  }
}