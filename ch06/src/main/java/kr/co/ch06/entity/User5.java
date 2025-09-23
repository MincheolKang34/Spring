package kr.co.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User5DTO;
import lombok.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User5")
public class User5 {
    @Id
    private String name;
    @Column(name = "gender")
    private String gender;
    private int age;
    private String addr;

    public User5DTO toDTO() {
        return User5DTO.builder()
                .name(name)
                .gender(gender)
                .age(age).
                addr(addr)
                .build();
    }
}
