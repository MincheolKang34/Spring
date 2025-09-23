package kr.co.ch06.entity;

import jakarta.persistence.*;
import kr.co.ch06.dto.User6DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User6")
public class User6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User6DTO toDTO() {
        return User6DTO.builder()
                .seq(seq)
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();

    }
}
