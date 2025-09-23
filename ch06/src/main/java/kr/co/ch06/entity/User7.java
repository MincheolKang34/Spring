package kr.co.ch06.entity;

import jakarta.persistence.*;
import kr.co.ch06.dto.User7DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User7")
public class User7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;

    public User7DTO toDTO() {
        return User7DTO.builder()
                .id(id)
                .name(name)
                .age(age)
                .email(email)
                .build();
    }
}
