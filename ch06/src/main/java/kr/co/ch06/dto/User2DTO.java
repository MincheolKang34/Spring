package kr.co.ch06.dto;

import kr.co.ch06.entity.User2;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User2DTO {
    private String user_id;
    private String name;
    private String hp;
    private int age;

    public User2 toEntity() {
        return User2.builder()
                .user_id(user_id)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}
