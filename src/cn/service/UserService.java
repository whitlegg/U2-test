package cn.service;

import cn.domain.Some;
import cn.domain.User;
import cn.untils.PageBean;

public interface UserService {
    PageBean findall(Some some,Integer p)throws Exception;
    boolean addUser(User user)throws Exception;
    boolean removeUserById(String id)throws Exception;
    User updataUI(String id) throws Exception ;
    boolean updataUserService(User user)throws Exception;
}
