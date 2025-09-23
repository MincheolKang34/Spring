package kr.co.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User4DTO;
import lombok.*;

@Entity
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User4")
public class User4 {
    @Id
    private String name;
    private String gender;
    private int age;
    private String addr;

    public User4DTO toDTO() {
        return User4DTO.builder()
                .name(name)
                .gender(gender)
                .age(age)
                .addr(addr)
                .build();
    }
}
