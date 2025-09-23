package kr.co.ch06.repository.board;

import jakarta.transaction.Transactional;
import kr.co.ch06.entity.board.Article;
import kr.co.ch06.entity.board.Comment;
import kr.co.ch06.entity.board.File;
import kr.co.ch06.entity.board.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;

    @Test
    void insertUserTest(){
        User user = User.builder()
                .userId("a101")
                .name("김유신")
                .age(24)
                .build();

        userRepository.save(user);
    }

    @Test
    void insertArticleTest(){
        User user = User.builder()
                .userId("a101")
                .name("김유신")
                .build();

        Article article = Article.builder()
                .title("제목3")
                .content("내용3")
                .user(user)
                .build();
        articleRepository.save(article);
    }

    @Test
    void insertFileTest(){
        Article article = Article.builder()
                .ano(3).build();

        File file = File.builder()
                .oName("매출자료2.xls")
                .sName("asdf-1ldfl-m3392.xls")
                .ano(3)
                .build();

        fileRepository.save(file);
    }

    @Test
    void insertCommentTest(){
        Article article = Article.builder()
                            .ano(3)
                            .build();
        Comment comment = Comment.builder()
                .content("댓글")
                .author("a103")
                .article(article)
                .build();
        commentRepository.save(comment);
    }

    @Test
    @Transactional
    void selectArticleAllTest(){
        List<Article> articles = articleRepository.findAll();

        for(Article article : articles){
            for(Comment comment : article.getCommentList()){
                System.out.println(comment);
            }
        }
    }

    @Test
    @Transactional // Transaction 처리, 엔티티 연관관계에서 한 번 이상의 SQL 처리가 이루어지기 때문에 단일 작업 처리를 위해 트랜젝션 처리, 안하면 no seesion 에러
    void selectArticle(){
        Optional<Article> optArticle = articleRepository.findById(1);
        System.out.println(optArticle);

        if(optArticle.isPresent()){
            Article article = optArticle.get();
            List<Comment> comments = article.getCommentList();

            for(Comment comment : comments){
                System.out.println(comment);
            }

            List<File> fileList = article.getFileList();
            for(File file : fileList){
                System.out.println(file);
            }
        }
    }
}