package cn.dao;

import cn.domain.Some;
import cn.domain.User;
import cn.untils.PageBean;

import java.util.List;

public interface UserDao {
    Integer selectCount(Some some)throws Exception;
    List<User> selectUser(Some some, PageBean pb)throws Exception;
    Integer insertUser(User user)throws Exception;
    Integer deleteUser(String id)throws Exception;
    User upUI(String id)throws Exception;
    Integer updataUser(User user)throws Exception;
}
