package kr.co.ch05.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User2DTO {
    private String user_id;
    private String name;
    private String hp;
    private int age;
}
