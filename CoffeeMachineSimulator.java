package CoffeeMachineSimulator;

import java.util.Scanner;

public class CoffeeMachineSimulator {

    public static void main(String[] args) {
        ServicesModule servicesModule = new ServicesModule();

            Scanner scn = new Scanner(System.in);
            char option;
            do {
                System.out.println("1. Buy Coffee");
                System.out.println("2. Fill Ingredients");
                System.out.println("3. Collect Money");
                System.out.println("4. Show Ingredients and Money in Machine");
                System.out.println("5. Analytics");
                System.out.println("0. Exit");
                System.out.println("Please select any option above:");

                option = scn.next().charAt(0);
                switch (option) {
                    case '1':
                        servicesModule.buyCoffee(scn);
                        break;
                    case '2':
                        servicesModule.fillIngredients(scn);
                        break;
                    case '3':
                        servicesModule.collectMoney();
                        break;
                    case '4':
                        servicesModule.showIngredients();
                        break;
                    case '5':
                        servicesModule.showAnalytics();
                        break;
                    case '0':
                        System.out.println("Exiting .....");
                        break;
                    default:
                        System.out.println("Invalid option.... Please try again.");
                }
            } while (option != '0');
            scn.close();

    }
}
