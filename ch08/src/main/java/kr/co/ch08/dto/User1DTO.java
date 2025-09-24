package kr.co.ch08.dto;

import kr.co.ch08.entity.User1;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO {
    private String userid;
    private String name;
    private String birth;
    private int age;

    public User1 toEntity() {
        return User1.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}