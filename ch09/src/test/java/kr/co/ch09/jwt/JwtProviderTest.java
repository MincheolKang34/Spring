package kr.co.ch09.jwt;

import io.jsonwebtoken.Claims;
import kr.co.ch09.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

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
        String token = jwtProvider.createToken(user, -1);

        System.out.println(token);
    }

    @Test
    void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtaW5jaGVvbGthbmczNEBnbWFpbC5jb20iLCJpYXQiOjE3NTg3NjI4NTAsImV4cCI6MTc1ODg0OTI1MCwidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.gSSn6fri_P9KKgCW4lDlbqr1BaI-GShYqVMKuvf9s3E";

        Claims claims = jwtProvider.getClaims(token);
        System.out.println(claims);
    }

    @Test
    void getAuthentication() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtaW5jaGVvbGthbmczNEBnbWFpbC5jb20iLCJpYXQiOjE3NTg3NjI4NTAsImV4cCI6MTc1ODg0OTI1MCwidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.gSSn6fri_P9KKgCW4lDlbqr1BaI-GShYqVMKuvf9s3E";

        Authentication authentication = jwtProvider.getAuthentication(token);
        User user =  (User) authentication.getPrincipal();
        System.out.println(user);
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtaW5jaGVvbGthbmczNEBnbWFpbC5jb20iLCJpYXQiOjE3NTg3NjI4NTAsImV4cCI6MTc1ODg0OTI1MCwidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.gSSn6fri_P9KKgCW4lDlbqr1BaI-GShYqVMKuvf9s3E";
        String expiredToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtaW5jaGVvbGthbmczNEBnbWFpbC5jb20iLCJpYXQiOjE3NTg3NjM2MzcsImV4cCI6MTc1ODY3NzIzNywidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.dAeG5oTMmMts7bf26NH0fC7KuyKiG0S5IWbV2H1PvFo";

        try {
            jwtProvider.validateToken(expiredToken);
            System.out.println("토큰 이상 없음");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecretKey() {
    }
}