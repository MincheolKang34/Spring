package kr.co.ch05.mapper;

import kr.co.ch05.dto.User6DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User6Mapper {
    public void insertUser6(User6DTO user6DTO);
    public User6DTO selectUser6BySeq(int seq);
    public List<User6DTO> selectAllUser6();
    public void updateUser6(User6DTO user6DTO);
    public void deleteUser6BySeq(int seq);
}
