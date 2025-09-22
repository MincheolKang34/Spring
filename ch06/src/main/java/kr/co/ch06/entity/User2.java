package kr.co.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User2DTO;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "User2")
public class User2 {
    @Id
    private String user_id;
    @Column(name = "name")
    private String name;
    private String hp;
    private int age;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .user_id(user_id)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}
