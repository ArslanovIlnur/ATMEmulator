package org.app.menu;

import org.app.entities.Card;
import org.app.entities.Cell;
import org.app.reposetories.CellRepository;
import org.app.service.ATMMenuService;
import org.app.service.CardService;
import org.app.service.CellService;
import org.app.service.implementations.CellRepositoryImpl;

import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    public static void mainMenu(Map<Integer, Card> cards, Map<Integer, Cell> cells){
        CellRepository cellRepository = new CellRepositoryImpl();

        CardService cardService = new CardService();
        CellService cellService = new CellService(cellRepository);

        System.out.println("================================================");
        System.out.println("                Главное меню                    ");
        System.out.println("================================================");
        System.out.println("1. Пополнить");
        System.out.println("2. Снять");
        System.out.println("3. Выйти");
        System.out.println("================================================");

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if (command == 1){
            ATMMenuService.topUpCardFromMenu(cards, cells);
        } else if (command == 2) {
            ATMMenuService.withdrawFromCardFromMenu(cards, cells);
        } else if (command == 3) {
            System.exit(0);
        }
    }
}
