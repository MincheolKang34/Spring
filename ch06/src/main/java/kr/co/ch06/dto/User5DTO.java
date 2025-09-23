package kr.co.ch06.dto;

import kr.co.ch06.entity.User5;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User5DTO {
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User5 toEntity() {
        return User5.builder()
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }
}
