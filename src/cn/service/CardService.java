package cn.service;

import cn.domain.Card;

import java.util.List;

public interface CardService {
    List<Card> findCard()throws Exception;
}
