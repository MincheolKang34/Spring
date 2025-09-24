package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import kr.co.ch08.dto.User3DTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "T_USER3")
public class User3 {
    @Id
    private String userid;
    private String name;
    private String role;
    @CreationTimestamp
    private LocalDateTime regDate;

    public User3DTO toDTO() {
        return User3DTO.builder()
                .userid(userid)
                .name(name)
                .role(role)
                .regDate(regDate.toString())
                .build();
    }
}
