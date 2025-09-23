package kr.co.ch06.repository;

import kr.co.ch06.entity.User7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User7Repository extends JpaRepository<User7, Integer> {
}
