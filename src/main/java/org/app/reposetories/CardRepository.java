package org.app.reposetories;

import org.app.entities.Card;

import java.util.Map;

public interface CardRepository {
    Card createCard(int number, int pinCode, float amount);
    Card getCardByNumber(Map<Integer, Card> cardMap, int number);
    Map<Integer, Card> addMoneyInCard(Map<Integer, Card> cardMap,int number,  int addAmount);
    Map<Integer, Card> extendsMoneyFromCard(Map<Integer, Card> cardMap,int number,  int addAmount);

}
