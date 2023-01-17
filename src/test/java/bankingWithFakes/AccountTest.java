package bankingWithFakes;

import jdk.javadoc.doclet.Reporter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void test_feature_account() {
    // Given
    Reporter reporter = new Reporter();
    Account account=new Account(reporter);

    // When
    Account updatedAccount = account.deposit(500).withdraw(100);

    // Then
Assertions.assertThat(reporter)

  }

}
