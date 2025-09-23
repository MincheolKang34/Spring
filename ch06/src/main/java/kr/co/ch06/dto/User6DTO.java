package kr.co.ch06.dto;

import kr.co.ch06.entity.User6;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User6DTO {
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User6 toEntity(){
        return User6.builder()
                .seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }
}
