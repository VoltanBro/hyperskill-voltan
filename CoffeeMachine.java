package HyperSkill;

import java.util.Scanner;
public class CoffeeMachine{
    public static void showInfo(int a, int b, int c, int d, int e) {
        System.out.println("The coffee machine has:\n" +
                a + " of water\n" +
                b + " of milk\n" +
                c + " of coffee beans\n" +
                d + " of disposable cups\n" +
                e + " of money\n");
    }
    public static boolean readyEspresso(int water, int coffeeBeans, int disposableCups) {
        water /= 200;
        coffeeBeans /= 15;
        int min = Math.min(water, coffeeBeans);
        return min >= 1 && disposableCups >= 1;
    }
    public static boolean readyLatte(int water, int coffeeBeans, int milk, int disposableCups) {
        water /= 200;
        coffeeBeans /= 15;
        milk /= 75;
        int min = Math.min(Math.min(water,milk), coffeeBeans);
        return min >= 1 && disposableCups >= 1;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String action;
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int money = 550;
        boolean workMachine = true;

        showInfo(water, milk, coffeeBeans, disposableCups, money);

        while (workMachine) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            switch (action) {
                case "buy":

                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, " +
                            "3 - cappuccino, 4 back - to main menu:");
                    String buyOption = scanner.nextLine();

                    switch (buyOption) {
                        case "1":
                            if(readyLatte(water,coffeeBeans,milk,disposableCups)){
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 250;
                                coffeeBeans -= 16;
                                disposableCups -= 1;
                                money += 4;
                                break;
                            } else System.out.println("havn`t" + Math.min(water,coffeeBeans));
                            break;
                        case "2":
                            if(readyEspresso(water,coffeeBeans,disposableCups)){
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 350;
                                milk -= 75;
                                coffeeBeans -= 20;
                                disposableCups -= 1;
                                money += 7;
                                break;} else System.out.println("havn`t" + Math.min(water,coffeeBeans));
                            break;

                        case "3":
                            water -= 200;
                            milk -= 100;
                            coffeeBeans -= 12;
                            disposableCups -= 1;
                            money += 6;
                            break;

                        case "back":
                            break;

                    }
                    break;



                case "fill":
                    System.out.print("Write how many ml of water do you want to add: ");
                    water += scanner.nextInt();
                    System.out.print("Write how many ml of milk do you want to add: ");
                    milk += scanner.nextInt();
                    System.out.print("Write how many grams of coffee beans do you want to add ");
                    coffeeBeans += scanner.nextInt();
                    System.out.print("Write how many disposable cups of coffee do you want to add ");
                    disposableCups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("\nI gave you $" + money + "\n");
                    money = 0;
                    break;
                case "remaining":
                    showInfo(water, milk, coffeeBeans, disposableCups, money);
                    break;
                case "exit":
                    workMachine = false;
                    break;
                default:
                    break;
            }
        }
        showInfo(water, milk, coffeeBeans, disposableCups, money);
    }
}