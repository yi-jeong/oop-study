package example;

import org.example.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * 경계조건에 대해 테스트 코드를 작성해야 한다.
**/
public class PasswordValidatorTest {

    @DisplayName("비밀번호는 최소 8자 이상 12자 이하여야 한다.")
    @Test
    void validateTestPassword(){
        assertThatCode(()-> PasswordValidator.validate("merrycute"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = { "merrycutetest", "test"})
    void validateTestPassword2(String password){
        assertThatCode(()-> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자 이상 12자 이하여야 한다.");
    }
}
