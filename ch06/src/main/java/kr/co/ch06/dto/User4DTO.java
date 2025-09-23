package kr.co.ch06.dto;

import kr.co.ch06.entity.User4;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User4DTO {
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User4 toEntity() {
        return User4.builder()
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }
}
