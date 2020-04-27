package cn.dao.impl;

import cn.dao.UserDao;
import cn.domain.Some;
import cn.domain.User;
import cn.untils.C3P0Utils;
import cn.untils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

public class UserDaoimpl implements UserDao {
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());


    //查询分页count
    @Override
    public Integer selectCount(Some some) throws Exception {
        String scardId = some.getScardId();
        String suserName = some.getSuserName();
        List<Object> parms = new ArrayList<>();
        String sql = "select count(1) from user where 1=1 ";
        if(scardId!=null&&!scardId.isEmpty()){
            sql +=" and cardsid = ? ";
            parms.add(scardId);
        }
        if(suserName!=null&&!suserName.isEmpty()){
            sql +=" and username = ? ";
            parms.add(suserName);
        }
        Long i = qr.query(sql, new ScalarHandler<Long>(), parms.toArray());
        return i.intValue();
    }

    @Override
    public List<User> selectUser(Some some, PageBean pb) throws Exception {
        String scardId = some.getScardId();
        String suserName = some.getSuserName();
        List<Object> parms = new ArrayList<>();
        String sql = "select u.*,c.cardname from user u,card c where u.cardsid=c.cardid and 1=1";
        if(scardId!=null&&!scardId.isEmpty()){
            sql +=" and cardsid = ? ";
            parms.add(scardId);
        }
        if(suserName!=null&&!suserName.isEmpty()){
            sql +=" and username like ? ";
            parms.add("%"+suserName+"%");
        }
        sql+=" order by u.userid ";
        sql+=" limit ?,? ";
        parms.add((pb.getP()-1)*pb.getPageSize());
        parms.add(pb.getPageSize());
        List<User> query = qr.query(sql, new BeanListHandler<User>(User.class), parms.toArray());

        return query;
    }

    //添加
    @Override
    public Integer insertUser(User user) throws Exception {
        String sql = "insert  into  user value (null,?,?,?,?,?)";
        Object [] parms = new Object[]{
                user.getUsernum(),user.getUsername(),
                user.getUseraddr(),
                user.getCreatedate(),user.getCardsid()
        };
        int i = qr.update(sql, parms);
        return i;
    }

    @Override
    public Integer deleteUser(String id) throws Exception {
        String sql = "delete from user where userid = ? ";
        int i = qr.update(sql, id);
        return i;
    }

    @Override
    public User upUI(String id) throws Exception {
        String sql = "select * from user where userid =?";
        User query = qr.query(sql, new BeanHandler<User>(User.class),id);
        return query;
    }

    @Override
    public Integer updataUser(User user) throws Exception {
        String sql = "update user set usernum = ? , username = ?, useraddr = ?, createdate = ? ,cardsid = ? where userid = ?";
        Object[] parms = new Object[]{
          user.getUsernum(),user.getUsername(),user.getUseraddr(),
          user.getCreatedate(),user.getCardsid(),user.getUserid()
        };
        int i = qr.update(sql, parms);
        return i;
    }
}
