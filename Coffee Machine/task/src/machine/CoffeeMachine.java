package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachineAction running = new CoffeeMachineAction();
        System.out.println("Write action (buy, fill, take, remaining, exit)");

        do {

            String action = scanner.next();
            running.Action(action);
        } while (running.finish);

    }
}
class CoffeeMachineAction {
    Scanner scanner = new Scanner(System.in);
    int money = 550;
    int water = 400;
    int milk = 540;
    int beans = 120;
    int dcups = 9;

    boolean finish = true;

    enum Operations {
        BUY("buy"),
        FILL("fill"),
        TAKE("take"),
        REMAINING("remaining"),
        EXIT("exit");

        String action;

        Operations(String action) {
            this.action = action;
        }

    }

    enum Coffee {
        ESPRESSO("1"),
        LATTE("2"),
        CAPPUCCINO("3"),
        BACK("back");

        String choice;

        Coffee(String choice) {
            this.choice = choice;
        }
    }

    public void Action(String action) {
        if (action.equals(Operations.BUY.action)) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte,\n3 - cappuccino, back — to main menu");
        }
        if (action.equals(Coffee.ESPRESSO.choice)) {
            Conditions(water, milk, beans, dcups, 250, 0, 16);
            if (water - 250 >= 0 & dcups - 1 >= 0 & beans - 16 >= 0) {
                water -= 250;
                beans -= 16;
                dcups -= 1;
                money += 4;
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println("Write action (buy, fill, take, remaining, exit)");

            }
        }
        if (action.equals(Coffee.LATTE.choice)) {
            Conditions(water, milk, beans, dcups, 350, 75, 20);
            if (water - 350 >= 0 & milk - 75 >= 0 & dcups - 1 >= 0 & beans - 20 >= 0) {
                water -= 350;
                milk -= 75;
                beans -= 20;
                dcups -= 1;
                money += 7;
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println("Write action (buy, fill, take, remaining, exit)");
            }
        }
        if (action.equals(Coffee.CAPPUCCINO.choice)) {
            Conditions(water, milk, beans, dcups, 200, 100, 12);
            if (water - 200 >= 0 & milk - 100 >= 0 & dcups - 1 >= 0 & beans - 12 >= 0) {
                water -= 200;
                milk -= 100;
                beans -= 12;
                dcups -= 1;
                money += 6;
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println("Write action (buy, fill, take, remaining, exit)");
            }
        }
        if (action.equals(Coffee.BACK.choice)) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
        }
        if (action.equals(Operations.FILL.action)) {
            System.out.println("Write how many ml of water do you want to add:");
            if (scanner.hasNext()) {
                int addWater = scanner.nextInt();
                water += addWater;
                System.out.println("Write how many ml of milk do you want to add:");
            }
            if (scanner.hasNext()) {
                int addMilk = scanner.nextInt();
                milk += addMilk;
                System.out.println("Write how many grams of coffee beans do you want to add:");
            }
            if (scanner.hasNext()) {
                int addCoffeeBeans = scanner.nextInt();
                beans += addCoffeeBeans;
                System.out.println("Write how many disposable cups of coffee do you want to add:");
            }
            if (scanner.hasNext()) {
                int addCups = scanner.nextInt();
                dcups += addCups;
                System.out.println("Write action (buy, fill, take, remaining, exit)");
            }

        }
        if (action.equals(Operations.TAKE.action)) {
            System.out.printf("I gave you  $%d", (money));
            money = 0;
            System.out.println("\nWrite action (buy, fill, take, remaining, exit)");
        }
        if (action.equals(Operations.REMAINING.action)) {
            Resourses(water, milk, beans, dcups, money);

        }

        if (action.equals(Operations.EXIT.action)) {
            finish = false;
        }
    }

    public static void Resourses(int w, int ml, int c, int d, int m) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water", w);
        System.out.printf("\n%d of milk", ml);
        System.out.printf("\n%d of coffee beans", c);
        System.out.printf("\n%d of disposable cups", d);
        System.out.printf("\n$%d of money", m);
        System.out.println("Write action (buy, fill, take, remaining, exit)");

    }

    public static void Conditions(int w, int ml, int cb, int dc, int waterForOneCup, int milkForOneCup, int BeansForOneCup) {

        if (w - waterForOneCup <= 0) {
            System.out.println("Sorry, not enough water!");
            System.out.println("Write action (buy, fill, take, remaining, exit)");
        }
        if (ml - milkForOneCup <= 0) {
            System.out.println("Sorry, not enough milk!");
            System.out.println("Write action (buy, fill, take, remaining, exit)");
        }

        if (cb - BeansForOneCup <= 0) {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println("Write action (buy, fill, take, remaining, exit)");
        }
        if (dc - 1 <= 0) {
            System.out.println("Sorry, not enough cups!");
            System.out.println("Write action (buy, fill, take, remaining, exit)");
        }

    }
}

