package CoffeeMachineSimulator;

import java.util.Scanner;

public class ServicesModule {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int money;
    private int espressoWater;
    private int espressoBeans;
    private int latteWater;
    private int latteMilk;
    private int latteBeans;
    private int cappuccinoWater;
    private int cappuccinoMilk;
    private int cappuccinoBeans;
    private int espressoPrice;
    private int lattePrice;
    private int cappuccinoPrice;
    private int espressoCount;
    private int latteCount;
    private int cappuccinoCount;
    private int totalEarnings;

    public ServicesModule() {
        water = 0;
        milk = 0;
        coffeeBeans = 0;
        money = 0;
        espressoWater = 250;
        espressoBeans = 16;
        latteWater = 350;
        latteMilk = 75;
        latteBeans = 20;
        cappuccinoWater = 200;
        cappuccinoMilk = 100;
        cappuccinoBeans = 12;
        espressoPrice = 4;
        lattePrice = 7;
        cappuccinoPrice = 6;
        espressoCount = 0;
        latteCount = 0;
        cappuccinoCount = 0;
        totalEarnings = 0;
    }

    public void buyCoffee(Scanner scn) {

        System.out.println("Please select any type of coffee:");
        System.out.println("1. Espresso [$" + espressoPrice + "]");
        System.out.println("2. Latte [$" + lattePrice + "]");
        System.out.println("3. Cappuccino [$" + cappuccinoPrice + "]");
        System.out.println("0. Back");
        char coffeeType = scn.next().charAt(0);
        switch (coffeeType) {
            case '1':
                makeCoffee("espresso");
                break;
            case '2':
                makeCoffee("latte");
                break;
            case '3':
                makeCoffee("cappuccino");
                break;
            case '0':
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }

    public void makeCoffee(String coffeeType) {
        if (coffeeType.equals("espresso") && hasEnoughIngredients(espressoWater, 0, espressoBeans)) {
            System.out.println("Providing espresso. within a minute !");
            water -= espressoWater;
            coffeeBeans -= espressoBeans;
            money += espressoPrice;
            espressoCount++;
            totalEarnings += espressoPrice;
        } else if (coffeeType.equals("latte") && hasEnoughIngredients(latteWater, latteMilk, latteBeans)) {
            System.out.println("Providing latte. within a minute!");
            water -= latteWater;
            milk -= latteMilk;
            coffeeBeans -= latteBeans;
            money += lattePrice;
            latteCount++;
            totalEarnings += lattePrice;
        } else if (coffeeType.equals("cappuccino")
                && hasEnoughIngredients(cappuccinoWater, cappuccinoMilk, cappuccinoBeans)) {
            System.out.println("Providing cappuccino. within a minute!");
            water -= cappuccinoWater;
            milk -= cappuccinoMilk;
            coffeeBeans -= cappuccinoBeans;
            money += cappuccinoPrice;
            cappuccinoCount++;
            totalEarnings += cappuccinoPrice;
        } else {
            System.out.println("Insufficient ingredients to make " + coffeeType + "!!!! Please refill the machine.");
        }

        System.out.println("For another Order press enter");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

    }

    public boolean hasEnoughIngredients(int requiredWater, int requiredMilk, int requiredBeans) {
        return water >= requiredWater && milk >= requiredMilk && coffeeBeans >= requiredBeans;
    }

    public void fillIngredients(Scanner sc) {
        System.out.println("Enter the amount of water to add: ");
        int waterToAdd = sc.nextInt();
        System.out.println("Enter the amount of milk to add: ");
        int milkToAdd = sc.nextInt();
        System.out.println("Enter the amount of coffeeBeans to add: ");
        int beansToAdd = sc.nextInt();
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += beansToAdd;

    }

    public void collectMoney() {
        System.out.println("overall Money collected in Machine: $." + money);
        money = 0;
    }

    public void showIngredients() {
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Beans: " + coffeeBeans + " units");
        System.out.println("Money in Coffee Machine: $." + money);
    }

    public void showAnalytics() {
        System.out.println("Espresso sold: " + espressoCount);
        System.out.println("Latte sold: " + latteCount);
        System.out.println("Cappuccino sold: " + cappuccinoCount);
        System.out.println("Total earnings: $" + totalEarnings);
        System.out.println("Total ingredients consumed:");
        System.out.println("Water: "
                + (espressoCount * espressoWater + latteCount * latteWater + cappuccinoCount * cappuccinoWater)
                + " ml");
        System.out.println("Milk: " + (latteCount * latteMilk + cappuccinoCount * cappuccinoMilk) + " ml");
        System.out.println("CoffeeBeans: "
                + (espressoCount * espressoBeans + latteCount * latteBeans + cappuccinoCount * cappuccinoBeans)
                + " units");
    }

}
