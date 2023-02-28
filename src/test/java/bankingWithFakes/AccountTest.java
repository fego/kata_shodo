package bankingWithFakes;

import java.time.LocalDate;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AccountTest {

  @ParameterizedTest
  @ValueSource(ints={50,100,200})
  void whenDepositFirstAmountAndSecondAmount_thenBalanceIsFirstAmountPlusSecondAmount(int firstAmount) {
    // Give,
    Account account = new Account(new FakeReporter());
    final int secondAmount = 100;

    // When
    account = account.deposit(new Amount(firstAmount)).deposit(new Amount(secondAmount));
    // Then
    Assertions.assertThat(account.balance()).isEqualTo(firstAmount + secondAmount);
  }

  @ParameterizedTest
  @ValueSource(ints = {50,100,200})
  void whenWithDrawFirstAmountAndSecondAmount_thenBalanceIsMinusFirstAmountPlusSecondAmount(int firstAmount) {
    // Given
    Account account = new Account(new FakeReporter());
    final int secondAmount = 100;
    // When
    account = account.withdraw(new Amount(firstAmount)).withdraw(new Amount(secondAmount));
    // Then
    Assertions.assertThat(account.balance()).isEqualTo(- (firstAmount + secondAmount));
  }

  @Test
  void whenDeposit_thenOperationDateIsToday() {
    LocalDate today = LocalDate.MIN;

    final Account accountUpdated = new Account(new FakeReporter()).deposit(new Amount(1));

    // contient l'opération avec la date du jour + montant demandé
    accountUpdated.operations();


  }
}