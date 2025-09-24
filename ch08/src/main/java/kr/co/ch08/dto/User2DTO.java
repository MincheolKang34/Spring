package kr.co.ch08.dto;

import jakarta.validation.constraints.*;
import kr.co.ch08.entity.User2;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {
    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "알파벳 소문자와 숫자 조합 4~10자 입력")
    private String userid;
    @NotEmpty
    @Pattern(regexp = "^[가-핳]{2,10}$", message = "한글 2~10자 입력")
    private String name;
    @Min(1)
    @Max(100)
    private int age;
    private String address;

    public User2 toEntity() {
        return User2.builder()
                .userid(userid)
                .name(name)
                .age(age)
                .address(address)
                .build();
    }
}
