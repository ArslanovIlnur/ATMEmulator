package org.app.service;

import org.app.entities.Card;
import org.app.entities.Cell;

import java.util.Map;

public class Writer {
    public static void writeCells(CellService cellService, Map<Integer, Cell> cellMap){
        System.out.println("================================================");
        System.out.println("                      Ячейки                    ");
        System.out.println("================================================");
        cellService.writeCell(cellMap).stream().forEach(s-> System.out.println(s));
        System.out.println("================================================");
        writeCellsSum(cellService, cellMap);
    }

    public static void writeCellsSum(CellService cellService, Map<Integer, Cell> cellMap){
        System.out.println("Сумма: " + cellService.getSum(cellMap));
        System.out.println();
    }

    public static void writeCards(CardService cardService, Map<Integer, Card> cardMap){
        System.out.println("================================================");
        System.out.println("                      Карты                     ");
        System.out.println("================================================");
        cardService.writeCards(cardMap).stream().forEach(s-> System.out.println(s));
        System.out.println("================================================");
    }
}
