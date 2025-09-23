package kr.co.ch06.repository;

import kr.co.ch06.entity.User6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User6Repository extends JpaRepository<User6, Integer> {
}
