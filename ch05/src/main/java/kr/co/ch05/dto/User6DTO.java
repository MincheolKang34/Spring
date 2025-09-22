package kr.co.ch05.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User6DTO {
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;
}
