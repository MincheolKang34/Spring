package kr.co.ch09.jwt;

import kr.co.ch09.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {
        User user = User.builder()
                .usid("a101")
                .pass("1234")
                .name("김유신")
                .role("ADMIN")
                .age(23)
                .build();
        String token = jwtProvider.createToken(user, 1);

        System.out.println(token);
    }

    @Test
    void getClaims() {
    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {
    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecretKey() {
    }
}