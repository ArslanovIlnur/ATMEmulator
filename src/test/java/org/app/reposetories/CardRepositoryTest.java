package org.app.reposetories;

import org.app.entities.Card;
import org.app.service.CardService;
import org.app.service.implementations.CardRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CardRepositoryTest {
    private final CardRepository cardRepository = new CardRepositoryImpl();
    private final CardService cardService = new CardService();

    @Test
    void createCard() {
        Card card = null;
        assertNull(card);

        card = cardRepository.createCard(222333444, 5432, 15000);
        assertNotNull(card);
    }

    @Test
    void getCardByNumber() {
        int[] cardNumbers = {123456789, 321654987, 220220222};
        Map<Integer, Card> cardMap = cardService.createCards();
        Card card;

        for (int cardNumber : cardNumbers) {
            card = cardRepository.getCardByNumber(cardMap, cardNumber);
            assertEquals(cardNumber, card.getNumber());
        }
    }

    @Test
    void addMoneyInCard() {
        Map<Integer, Card> cardMap = cardService.createCards();
        int[] cardNumbers = {123456789, 321654987, 220220222};
        int add = 100;

        for (int cardNumber : cardNumbers) {
            float amountBefore = cardRepository.getCardByNumber(cardMap, cardNumber).getAmount();
            cardRepository.addMoneyInCard(cardMap, cardNumber, add);
            assertEquals(cardRepository.getCardByNumber(cardMap,cardNumber).getAmount(),
                    amountBefore + add);
        }
    }

    @Test
    void extendsMoneyFromCard() {
        Map<Integer, Card> cardMap = cardService.createCards();
        int[] cardNumbers = {123456789, 321654987, 220220222};
        int extend = 100;

        for (int cardNumber : cardNumbers) {
            float amountBefore = cardRepository.getCardByNumber(cardMap, cardNumber).getAmount();
            cardRepository.extendsMoneyFromCard(cardMap, cardNumber, extend);
            assertEquals(cardRepository.getCardByNumber(cardMap,cardNumber).getAmount(),
                    amountBefore - extend);
        }
    }
}