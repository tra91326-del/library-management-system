package utils;

import java.util.Scanner;

public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message){
        System.out.println(message);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
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
