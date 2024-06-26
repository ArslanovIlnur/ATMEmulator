package org.app.service;

import org.app.entities.Card;
import org.app.entities.Cell;
import org.app.reposetories.CardRepository;
import org.app.reposetories.CellRepository;
import org.app.service.implementations.CardRepositoryImpl;
import org.app.service.implementations.CellRepositoryImpl;

import java.util.*;

public class ATMService {
    public static void topUpCard(Map<Integer, Card> cardMap, Map<Integer, Cell> cellMap){
        CardRepository cardRepository = new CardRepositoryImpl();
        CellRepository cellRepository = new CellRepositoryImpl();

        CellService cellService = new CellService(cellRepository);
        CardService cardService = new CardService();

        List<Integer> denominations = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер карты");

        int number = scanner.nextInt();
        Card card = cardRepository.getCardByNumber(cardMap, number);

        if (card == null){
            throw new RuntimeException("Карта не найдена");
        } else {

            Set<Integer> nominals = cellMap.keySet();

            int sum = 0;

            for (int denomination : nominals) {
                System.out.println("Количество банкнот " + denomination);
                int amount = scanner.nextInt();
                cellRepository.addBanknoteInCell(cellMap, denomination, amount);
                sum = sum + denomination * amount;
            }

            cardRepository.addMoneyInCard(cardMap, card.getNumber(), sum);

            Writer.writeCells(cellService, cellMap);
            Writer.writeCards(cardService, cardMap);
        }
    }

    public static void withdrawFromCard(Map<Integer, Card> cardMap, Map<Integer, Cell> cellMap){
            CardRepository cardRepository = new CardRepositoryImpl();
            CellRepository cellRepository = new CellRepositoryImpl();

            CellService cellService = new CellService(cellRepository);
            CardService cardService = new CardService();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер карты");

            int number = scanner.nextInt();
            Card card = cardRepository.getCardByNumber(cardMap, number);

            System.out.println("Введите пин-код");
            int pinCode = scanner.nextInt();

            if (pinCode != card.getPinCode()) {
                throw new RuntimeException("Неверный пин-код");
            } else {
                System.out.println("Введите нобходимую сумму");

                int exAmount = scanner.nextInt();

                if (exAmount > 150000 || exAmount > cellService.getSum(cellMap)) {
                    throw new RuntimeException("Превышен лимит");
                } else {
                    cardRepository.extendsMoneyFromCard(cardMap, card.getNumber(), exAmount);

                    int remains;
                    int thCount;

                    remains = exAmount % 1000;

                    if (remains != 0) {
                        thCount = exAmount / 1000;
                        System.out.println(thCount + " купюры по 1000");
                        cellRepository.extendsBanknoteFromCell(cellMap, 1000, thCount);
                    }

                    exAmount = remains;
                    remains = exAmount % 500;

                    if (remains != 0) {
                        thCount = exAmount / 500;
                        System.out.println(thCount + " купюры по 500");
                        cellRepository.extendsBanknoteFromCell(cellMap, 500, thCount);

                    }

                    exAmount = remains;
                    remains = exAmount % 100;

                    if (remains != 0) {
                        thCount = exAmount / 100;
                        System.out.println(thCount + " купюры по 100");
                        cellRepository.extendsBanknoteFromCell(cellMap, 100, thCount);

                    }

                    exAmount = remains;
                    remains = exAmount % 50;

                    if (remains != 0) {
                        thCount = exAmount / 50;
                        System.out.println(thCount + " купюры по 50");
                        cellRepository.extendsBanknoteFromCell(cellMap, 50, thCount);

                    }

                    exAmount = remains;

                    if (remains != 0) {
                        thCount = exAmount / 10;
                        System.out.println(thCount + " купюры по 10");
                        cellRepository.extendsBanknoteFromCell(cellMap, 10, thCount);
                    }
                }
                Writer.writeCards(cardService, cardMap);
                Writer.writeCells(cellService, cellMap);
            }
    }
}
