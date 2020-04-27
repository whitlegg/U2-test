package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoimpl;
import cn.domain.Some;
import cn.domain.User;
import cn.service.UserService;
import cn.untils.PageBean;

public class UserServiceimpl implements UserService {
    UserDao userDao = new UserDaoimpl();

    @Override
    public PageBean findall(Some some, Integer p) throws Exception {
        PageBean pb = new PageBean();
        pb.setCount(userDao.selectCount(some));
        pb.setP(p);
        pb.setData(userDao.selectUser(some,pb));
        return pb;
    }

    @Override
    public boolean addUser(User user) throws Exception {
        return userDao.insertUser(user)>0?true:false;
    }

    @Override
    public boolean removeUserById(String id) throws Exception {
        return userDao.deleteUser(id)>0?true:false;
    }

    @Override
    public User updataUI(String id) throws Exception {
        return userDao.upUI(id);
    }

    @Override
    public boolean updataUserService(User user) throws Exception {
        return userDao.updataUser(user)>0?true:false;
    }
}
