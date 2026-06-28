package views;

import utils.InputHelper;

public class MainMenuView {

    public void displayMainMenu() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("               LIBRARY MANAGEMENT SYSTEM");
        System.out.println("============================================================");
        System.out.println("  1. Book Management");
        System.out.println("  2. Member Management");
        System.out.println("  3. Borrow Book");
        System.out.println("  4. Return Book");
        System.out.println("  5. Reports");
        System.out.println("  6. Exit");
        System.out.println("------------------------------------------------------------");
    }

    public int getUserChoice() {
        return InputHelper.readInt("Enter Your Choice:  ");
    }
}
