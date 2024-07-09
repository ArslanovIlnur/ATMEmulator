package org.app.service;

import org.app.entities.Card;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceTest {
    private final CardService cardService = new CardService();
    Map<Integer, Card> cardMap = new TreeMap<>();

    @Test
    void createCards() {
        assertEquals(0, cardMap.size());
        cardMap = cardService.createCards();
        assertNotEquals(0, cardMap.size());
    }
}