package org.app.service;

import org.app.entities.Card;
import org.app.entities.Cell;
import org.app.menu.MainMenu;
import org.app.reposetories.CellRepository;
import org.app.service.implementations.CellRepositoryImpl;

import java.util.Map;

public class ATMMenuService {
    public static Map<Integer, Card> addCards(CardService cardService){
        //Функция для добавления карт для работы
        Map<Integer, Card> cards = cardService.createCards();
        Writer.writeCards(cardService, cards);
        return cards;
    }

    public static Map<Integer, Cell> addCells(CellService cellService){
        //Функция для добавления банкнот в ячейку
        Map<Integer, Cell> cells = cellService.createCells();
        Writer.writeCells(cellService, cells);
        return cells;
    }

    public static void topUpCardFromMenu(Map<Integer, Card> cards, Map<Integer, Cell> cells){
        //Функция для добавления денег на карту
        ATMService.topUpCard(cards, cells);
        MainMenu.mainMenu(cards, cells);
    }

    public static void withdrawFromCardFromMenu(Map<Integer, Card> cards, Map<Integer, Cell> cells){
        //Функция для снятия денег с карты
        ATMService.withdrawFromCard(cards, cells);
        MainMenu.mainMenu(cards, cells);
    }
}
