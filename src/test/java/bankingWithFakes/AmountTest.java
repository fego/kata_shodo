package bankingWithFakes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AmountTest {

  /*@Test
  void accountValueCannotBeNegative() {
    Assertions.assertThatThrownBy(() -> new Amount(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }*/

  @Test
  void accountValueShouldBeZeroOrPositive() {
    Assertions.assertThatCode(() -> new Amount(456789)).doesNotThrowAnyException();
  }
}