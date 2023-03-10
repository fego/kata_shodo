package bankingWithFakes;

import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BankAccountTest {

  @Test
  void test_feature_account() {
    // Given
    FakeReporter reporter = new FakeReporter();
    Account account = new Account(reporter);

    // When
    Account updatedAccount = account.deposit(new Amount(500)).withdraw(new Amount(100));

    // Then
    Assertions.assertThat(reporter.report()).isEqualTo("""
        Date        Amount  Balance
        24.12.2015   +500      500
        23.8.2016    -100      400""");

  }

}
