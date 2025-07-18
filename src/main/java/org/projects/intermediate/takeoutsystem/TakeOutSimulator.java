package org.projects.intermediate.takeoutsystem;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator() {
        this.customer = new Customer();
        this.menu = new FoodMenu();
        this.input = new Scanner(System.in);
    }

    private <T> T getResponse(String userInputPrompt, UserInputRetriever<T> userInputRetriever) {
        T result;

        while (true) {
            int integerPrompt = input.nextInt();

            if (input.hasNextInt()) {
                System.out.println(userInputPrompt);

                try {
                    return userInputRetriever.produceOutput(integerPrompt);
                } catch (IllegalArgumentException e) {
                    System.out.println(userInputPrompt + " is not a valid input. Try again!");
                    return null;
                }

            } else {
                System.out.println("Input needs to be an `int` type.");
                return null;

            }
        }
    }

    public boolean shouldSimulate() {
        String userPrompt = "Enter 1 to CONTINUE simulation or 0 to EXIT program:";
        UserInputRetriever<String> userInputRetriever;

        String response = getResponse(userPrompt,

                new UserInputRetriever<String>() {
            @Override
            public String produceOutput(int selection) throws IllegalArgumentException {
                return switch (selection) {
                    case 1 -> " 1 You have enough money to buy the lowest cost food item.";
                    case 0 -> " 0 You don't have enough money to buy the lowest cost food item.";
                    default -> throw new IllegalArgumentException();
                };
            }
        });

    }
}
