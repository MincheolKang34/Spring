package kr.co.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// Oracle에서는 COMMENT가 예약어이기 때문에 quotation을 붙이고 대소문자 구분을 해줘야함
// 접두어(ex: TBL_Comment)를 붙이는 것을 권장
@Table(name = "\"Comment\"")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREAMENT
    private int cno;
    @ManyToOne(fetch = FetchType.LAZY) // 관계설정
    @JoinColumn(name = "ano")          // FK 이름 설정
    private Article article;
    private String content;
    private String author;
    @CreationTimestamp
    private LocalDateTime wdate;
}