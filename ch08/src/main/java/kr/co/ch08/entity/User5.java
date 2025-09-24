package kr.co.ch08.entity;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class User5 {
    private int no;
    private String name;
    private int age;
    private String gender; // M, F
    private LocalDateTime regDate;
}
