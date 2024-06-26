package org.app.service.implementations;

import org.app.entities.Card;
import org.app.entities.Cell;
import org.app.reposetories.CardRepository;

import java.util.Map;

public class CardRepositoryImpl implements CardRepository {
    @Override
    public Card createCard(int number, int pinCode, float amount) {
        return new Card(number, pinCode, amount);
    }

    @Override
    public Card getCardByNumber(Map<Integer, Card> cardMap, int number) {
        return cardMap.get(number);
    }

    @Override
    public Map<Integer, Card> addMoneyInCard(Map<Integer, Card> cardMap, int number, int addAmount) {
        System.out.println("Добавление денег на карту...");
        System.out.println();

        Card card = getCardByNumber(cardMap, number);
        float amount = card.getAmount() + addAmount;

        cardMap.replace(number, card, new Card(number, card.getPinCode(), amount));
        return cardMap;
    }

    @Override
    public Map<Integer, Card> extendsMoneyFromCard(Map<Integer, Card> cardMap, int number, int extendAmount) {
        Card card = getCardByNumber(cardMap, number);

        if (card.getAmount()<extendAmount){
            throw new RuntimeException("Недостаточно средств на карте");
        }else {
            System.out.println("Вычет с карты...");
            System.out.println();

            float amount = card.getAmount() - extendAmount;

            cardMap.replace(number, card, new Card(number, card.getPinCode(), amount));
            return cardMap;
        }
    }
}
