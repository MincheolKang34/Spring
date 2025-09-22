package kr.co.ch06.repository;

import kr.co.ch06.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface User2Repository extends JpaRepository<User2,String> {
}
