package cn.dao.impl;

import cn.dao.CardDao;
import cn.domain.Card;
import cn.untils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CardDaoimpl implements CardDao {
    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
    @Override
    public List<Card> selectCard() throws Exception {
        String sql = "select * from card";
        List<Card> query = qr.query(sql, new BeanListHandler<Card>(Card.class));
        return query;
    }
}
