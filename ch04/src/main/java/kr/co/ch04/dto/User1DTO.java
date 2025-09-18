package kr.co.ch04.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User1DTO {
    private String userId;
    private String userName;
    private String birth;
    private int age;
}
