package views;

import utils.InputHelper;

public class MainMenuView {

    public void displayMainMenu() {

        System.out.println("=================================");
        System.out.println("   Library Management System");
        System.out.println("=================================");

        System.out.println("1. Book Management");
        System.out.println("2. Member Management");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Reports");
        System.out.println("6. Exit");
    }

    public int getUserChoice() {
        return InputHelper.readInt("Enter Your Choose:  ");
    }
}
