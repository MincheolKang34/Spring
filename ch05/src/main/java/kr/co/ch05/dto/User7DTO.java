package kr.co.ch05.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User7DTO {
    private int id;
    private String name;
    private int age;
    private String email;
}
