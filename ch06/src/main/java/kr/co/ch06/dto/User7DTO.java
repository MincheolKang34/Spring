package kr.co.ch06.dto;

import kr.co.ch06.entity.User7;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User7DTO {
    private int id;
    private String name;
    private int age;
    private String email;

    public User7 toEntity() {
        return User7.builder()
                .id(id)
                .name(name)
                .age(age)
                .email(email)
                .build();
    }
}
