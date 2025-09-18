package kr.co.ch04.mapper;

import kr.co.ch04.dto.User1DTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1MapperTest {

    @Autowired
    private User1Mapper user1Mapper;

    private String userid = "abc2002";

    @Test
    void insert() {
        // Given - 테스트를 실행하기 위한 준비 단계
        User1DTO user1DTO = User1DTO.builder()
                                    .userId(userid)
                                    .userName("김유신")
                                    .birth("1992-01-03")
                                    .age(21)
                                    .build();

        // When - 테스트 수행
        user1Mapper.insert(user1DTO);

        // Then - 테스트 결과를 검증
        User1DTO savedUser = user1Mapper.select(user1DTO.getUserId());
        assertEquals(user1DTO.getUserId(), savedUser.getUserId());
    }

    @Test
    void select() {
        // Given
//        String userId = "abc11";

        // When
        User1DTO findUser = user1Mapper.select(userid);

        // Then
        System.out.println(findUser);
        assertEquals(userid, findUser.getUserId());
    }

    @Test
    void selectAll() {
        // Given
        // When
        List<User1DTO> dtoList = user1Mapper.selectAll();

        System.out.println(dtoList);

        // Then
//        assertTrue(dtoList.isEmpty()); // 테스트 실패로 출력
        assertFalse(dtoList.isEmpty()); // 테스트 성공으로 출력
    }

    @Test
    void update() {
        // Given
        User1DTO user1DTO = User1DTO.builder()
                .userId(userid)
                .userName("홍길동")
                .birth("1992-07-03")
                .age(29)
                .build();

        // When
        user1Mapper.update(user1DTO);

        // Then
        User1DTO modifiedUser = user1Mapper.select(user1DTO.getUserId());
        assertEquals(user1DTO, modifiedUser); // 객체 비교 DTO에 @Data 어노테이션 선언
    }

    @Test
    void delete() {
        // Given
//        String userId = "abc11";

        // When
        user1Mapper.delete(userid);

        // Then
        User1DTO removedUser = user1Mapper.select(userid);
        assertNull(removedUser);
    }
}