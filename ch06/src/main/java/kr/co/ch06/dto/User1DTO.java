package kr.co.ch06.dto;

import kr.co.ch06.entity.User1;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User1DTO {
    private String userId;
    private String userName;
    private String birth;
    private int age;

    // Entity 변환 메서드 정의
    // DTO 변환 메서드 정의
    public User1 toEntity() {
        return User1.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
