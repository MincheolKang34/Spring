package kr.co.ch08.entity;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class User3 {
    private String userid;
    private String name;
    private String role;
    private LocalDateTime regDate;
}
