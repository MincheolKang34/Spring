package kr.co.ch04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User1DTO {
    private String userId;
    private String userName;
    private String birth;
    private int age;
}
