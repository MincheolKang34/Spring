package kr.co.ch06.dto;

import kr.co.ch06.entity.User3;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User3DTO {
    private String user_id;
    private String name;
    private String hp;
    private int age;

    public User3 toEntity() {
        return User3.builder()
                .user_id(user_id)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}
