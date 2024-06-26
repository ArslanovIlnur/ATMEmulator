package org.app;

import org.app.menu.MainMenu;
import org.app.reposetories.CellRepository;
import org.app.service.CardService;
import org.app.service.CellService;
import org.app.service.implementations.CellRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        CellRepository cellRepository = new CellRepositoryImpl();

        CellService cellService = new CellService(cellRepository);
        CardService cardService = new CardService();

        MainMenu.mainMenu(cardService.createCards(), cellService.createCells());
    }
}
