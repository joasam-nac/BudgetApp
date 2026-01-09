package Uppgiften;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CorrectInputControl {

    public static Object check(Scanner scanner, InputType input, boolean flush){
        switch (input.getType()) {
            case "int" -> {
                int thisInput;

                while (true) {
                    try {
                        thisInput = scanner.nextInt();

                        if(flush) {
                            scanner.nextLine();
                        }

                        break;
                    } catch (InputMismatchException ex) {
                        IO.println("Invalid input, try again!");
                        scanner.nextLine();
                    }
                }
                return thisInput;

            }
            case "double" -> {
                double thisInput;

                while (true) {
                    try {
                        thisInput = scanner.nextDouble();

                        if(flush) {
                            scanner.nextLine();
                        }

                        break;
                    } catch (InputMismatchException ex) {
                        IO.println("Invalid input, try again!");
                        scanner.next();
                    }
                }
                return thisInput;
            }
        }
        return scanner.nextLine();
    }
}
