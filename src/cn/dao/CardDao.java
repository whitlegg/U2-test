package cn.dao;

import cn.domain.Card;

import java.util.List;

public interface CardDao {
    List<Card> selectCard()throws Exception;
}
