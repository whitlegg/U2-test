package cn.service.impl;

import cn.dao.CardDao;
import cn.dao.impl.CardDaoimpl;
import cn.domain.Card;
import cn.service.CardService;

import java.util.List;

public class CardServiceimpl implements CardService {
    CardDao cardDao = new CardDaoimpl();
    @Override
    public List<Card> findCard() throws Exception {
        return cardDao.selectCard();
    }
}
