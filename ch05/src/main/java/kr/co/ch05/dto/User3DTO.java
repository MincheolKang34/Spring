package kr.co.ch05.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User3DTO {
    private String user_id;
    private String name;
    private String hp;
    private int age;
}
