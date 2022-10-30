package example;

import org.example.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @DisplayName("패스워드 초기화 여부 체크")
    @Test
    void userPasswordTest(){
        // given
        User user = new User();

        // when
        user.initPassword(new CorrectFixed());

        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드 요구사항이 맞지 않아 초기화가 되지 않는 경우")
    @Test
    void userPasswordTest2(){
        // given
        User user = new User();

        // when
        user.initPassword(new WrongFixed());

        // then
        assertThat(user.getPassword()).isNull();
    }
}
