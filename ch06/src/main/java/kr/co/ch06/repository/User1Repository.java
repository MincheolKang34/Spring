package kr.co.ch06.repository;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User1Repository extends JpaRepository<User1, String> { // <엔티티, 해당 엔티티의 @ID 속성 자료형>
    // 사용자 쿼리 메서드 정의
    public User1 findUser1ByUserId(String userId);
    public User1 findUser1ByUserName(String userName);
    public List<User1> findUser1ByUserNameNot(String userName);

    public User1 findUser1ByUserIdAndUserName(String userId, String userName);
    public List<User1> findUser1ByUserIdOrUserName(String userId, String userName);

    public List<User1> findUser1ByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByUserNameLike(String userName);
    public List<User1> findUser1ByUserNameContains(String userName);
    public List<User1> findUser1ByUserNameStartsWith(String userName);
    public List<User1> findUser1ByUserNameEndsWith(String userName);

    public List<User1> findUser1ByOrderByUserName();
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByUserId(String userId);
    public int countUser1ByUserName(String userName);

    // JPQL(JPA SQL) 실습
    @Query("SELECT u1 FROM User1 as u1 WHERE u1.age < 30")
    public List<User1> selectUser1UnderAge30();

    @Query("SELECT u1 FROM User1 as u1 WHERE u1.userName = ?1")
    public List<User1> selectUser1WhereName(String userName);

    @Query("SELECT u1 FROM User1 as u1 WHERE u1.birth = :birth")
    public List<User1> selectUser1WhereBirth(@Param("birth") String birth);

    @Query("SELECT u1.userId, u1.userName, u1.age FROM User1 as u1 WHERE u1.userId = :userId")
    public List<Object[]> selectUser1WhereUserId(@Param("userId") String userId);

    @Query("SELECT p, c FROM Parent as p " +
            "JOIN Child as c ON p.pid = c.pid " +
            "WHERE p.pid = :pid")
    public List<Object[]> selectParentJoinChild(@Param("pid") String pid);
}
