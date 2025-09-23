package kr.co.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User3DTO;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User3")
public class User3 {
    @Id
    private String user_id;
    private String name;
    private String hp;
    private int age;

    public User3DTO toDTO() {
        return User3DTO.builder()
                .user_id(user_id)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}
