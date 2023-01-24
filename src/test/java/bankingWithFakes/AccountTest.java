package bankingWithFakes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AccountTest {

  @ParameterizedTest
  @ValueSource(ints={50,100,200})
  void whenDepositFirstAmount_thenBalanceIsFirstAmount(int firstAmount) {
    // Give,
    Account account = new Account(new FakeReporter(), Collections.emptyList());
    // When
    account.deposit(firstAmount);
    // Then
    Assertions.assertThat(account.balance()).isEqualTo(firstAmount);
  }

  @ParameterizedTest
  @ValueSource(ints={50,100,200})
  void whenDepositFirstAmountAndSecondAmount_thenBalanceIsFirstAmountPlusSecondAmount(int firstAmount) {
    // Give,
    Account account = new Account(new FakeReporter(), Collections.emptyList());
    final int secondAmount = 100;

    // When
    account.deposit(firstAmount);
    account.deposit(secondAmount);

    // Then
    Assertions.assertThat(account.balance()).isEqualTo(firstAmount + secondAmount);
  }



}