package org.app.service;

import org.app.entities.Card;
import org.app.reposetories.CardRepository;
import org.app.service.implementations.CardRepositoryImpl;

import java.util.*;

public class CardService {
    public Map<Integer, Card> createCards(){
        SortedMap<Integer, Card> cards = new TreeMap<>();
        CardRepository cardRepository = new CardRepositoryImpl();

        cards.put(123456789, cardRepository.createCard(123456789, 1234, 50000f));
        cards.put(321654987, cardRepository.createCard(321654987, 1478, 123600f));
        cards.put(220220222, cardRepository.createCard(220220222, 2222, 13568.53f));


        return cards;
    }

    public List<String> writeCards(Map<Integer, Card> cardMap){
        Set<Integer> keys = new HashSet<>();
        List<String> writes = new ArrayList<>();

        cardMap.keySet().forEach(key-> keys.add(key));

        int number = 0;
        float amount = 0;

        for (int i : keys){
            number = cardMap.get(i).getNumber();
            amount = cardMap.get(i).getAmount();
            writes.add("Номер карты: " + number + " | "
                    + "Баланс: " + String.format("%.2f",amount));
        }

        return writes;
    }
}
