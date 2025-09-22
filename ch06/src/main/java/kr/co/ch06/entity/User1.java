package kr.co.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.dto.User1DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@Setter // Entity는 Setter 불변성을 위해 금지
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User1")
public class User1 {
    @Id // PK 컬럼 선언
    private String userId;

    @Column(name = "userName") // 매핑 컬럼, 일반적으로 생략
    private String userName;
    private String birth;
    private int age;

    // DTO 변환 메서드 정의
    public User1DTO toDTO() {
        return User1DTO.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
