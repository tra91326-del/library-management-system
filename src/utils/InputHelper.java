package utils;

import java.util.Scanner;

public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter number only.");
            }
        }
    }

    public static String readString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static boolean readBoolean(String message){
        System.out.println(message);
        return scanner.nextBoolean();
    }
}
