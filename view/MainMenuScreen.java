package UTSPBO.view;

import UTSPBO.controller.*;
import UTSPBO.model.User;


public class MainMenuScreen {
    public MainMenuScreen() {
        displayMainMenu();
    }


    private void displayMainMenu() {
        int menu = 0;
        do {
            menu = Integer.parseInt(DialogView.showInputDialog("""
                                                               Main Menu: 
                                                               1. Show User Chats 
                                                               2. Change Chat State 
                                                               3. Send Message 
                                                               4. Show Message 
                                                               5. Change User Profile 
                                                               6. Favorite
                                                               0. Keluar """));

            switch (menu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
            }
        } while (menu != 0);
    }
}
