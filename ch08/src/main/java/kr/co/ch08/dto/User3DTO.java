package kr.co.ch08.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import kr.co.ch08.entity.User3;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User3DTO {
    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "영문 소문자, 숫자 조합 4~10자 입력")
    private String userid;
    @NotEmpty
    @Pattern(regexp = "^[가-핳]{2,10}$", message = "한글 2~10자 입력")
    private String name;
    @NotNull
    @Pattern(regexp = "^(ADMIN|MANAGER|MEMBER|GUEST)$", message = "ADMIN, MANAGER, MEMBER, GUEST 중 하나 입력")
    private String role;
    private String regDate;

    public User3 toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse(regDate, formatter);
        return User3.builder()
                .userid(userid)
                .name(name)
                .role(role)
                .regDate(dateTime)
                .build();
    }
}
