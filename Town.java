public class Town {
    public static String doStart() {
        do {
            Game.clearScreen();
            System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "Welcome to the town.");

            if (Hero.hasQuest(Quest.FIND_THE_WALLET)) {
                System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "There is a "
                        + ConsoleColors.BLUE + "house " + ConsoleColors.RESET
                        + "that Dungeon Master asked you to find his lost wallet");
            }

            System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                    + "Please choose where you are going ( " + ConsoleColors.BLUE
                    + "shop, house, monster dungeon, boss dungeon " + ConsoleColors.RESET + ")");

            String answer = Input.getString().toLowerCase();

            if (answer.equals("shop")) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "You enter the shop...");
                Input.pressEnterToContinue();
                return Locations.TOWN_SHOP;
            } else if (answer.equals("house") && Hero.hasQuest(Quest.FIND_THE_WALLET)) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "Going into the house...");
                Input.pressEnterToContinue();
                return Locations.TOWN_HOUSE;
            } else if (answer.equals("monster dungeon")) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "Entering the dungeon... heh");
                Input.pressEnterToContinue();
                return Locations.MONSTER_DUNGEON_START;
            } else if (answer.equals("boss dungeon")) {
                System.out
                        .println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RED + "PREPARE FOR THE DEATH");
                Input.pressEnterToContinue();
                return Locations.BOSS_DUNGEON_START;
            } else {
                System.out.println(
                        ConsoleColors.RED_BOLD + "[Error] " + ConsoleColors.RESET + "Please enter the valid response");
            }

        } while (true);

    }

    public static String doShop() {
        Game.clearScreen();
        System.out
                .println(ConsoleColors.YELLOW_BOLD + "[Shop] " + ConsoleColors.RESET + "The shop is currently closed");

        // make it open later
        Input.pressEnterToContinue();
        return Locations.TOWN_START;
    }

    public static String doTemple() {
        Game.clearScreen();
        System.out.println(ConsoleColors.BLUE_BOLD + "[GOD] " + ConsoleColors.RESET
                + "This is the temple, you are now fully healed");
        Hero.health = Hero.maxHealth;
        System.out.format("Health: %d/%d", Hero.health, Hero.maxHealth);
        Input.pressEnterToContinue();
        return Locations.TOWN_START;
    }

    public static String doHouse() {
        Game.clearScreen();

        System.out.println("You approach the door to the house and listen, but hear nothing.");
        Input.pressEnterToContinue();

        do {
            Game.clearScreen();
            System.out.format("You can %s the door or go back to %s.\n", Game.blue("open"), Game.blue("town"));
            System.out.println("What do you want to do?");
            String answer = Input.getString().toLowerCase();

            if (answer.equals("open")) {
                openDoorHouse();
                return Locations.TOWN_START;
            } else if (answer.equals("town")) {
                System.out.println("You decide it is better to head back to town.");
                Input.pressEnterToContinue();
                return Locations.TOWN_START;
            } else {
                System.out.println("Invalid choice");
                Input.pressEnterToContinue();
            }

        } while (true);

    }

    public static void openDoorHouse() {

        if (Hero.hasQuest(Quest.FIND_THE_WALLET) == true) { // verify they have the quest
            if (Hero.hasCompletedQuest(Quest.FIND_THE_WALLET) == false) { // verify they have not turned in
                if (Hero.hasItem(Item.LOST_WALLET) == false) { // verify the player found the lost necklace
                    System.out.println("You see the bandits and slay them, and take the necklace");
                    Item wallet = new Item(Item.LOST_WALLET);
                    wallet.name = "Lost wallet";
                    wallet.description = "This wallet had lost since 1930s and it was from the dungeon master's ancestor";
                    wallet.price = 100;
                    Hero.addItem(wallet);
                    System.out.println("You head back to town.");
                    Input.pressEnterToContinue();

                } else {
                    System.out.println(
                            "The bandits are gone, you should return the necklace to the Innkeeper to collect your reward");
                    Input.pressEnterToContinue();

                }
            } else {
                System.out.println("This is where you defeated the bandits and found the necklace that you returned.");

                Input.pressEnterToContinue();

            }
        } else {
            System.out.println("There is nothing here to see");
            Input.pressEnterToContinue();

        }
    }

    public static String doInn() {
        Game.clearScreen();
        System.out.println("welcome to the inn.");

        if (Hero.hasQuest(Quest.FIND_THE_WALLET) == false) {

            System.out.println(
                    "The innkeeper says there is a reward for anyone that can go to the bandit's house and get back the stolen necklace of his daughter.");

            System.out.println("He will give his sword and some gold as a reward!");

            Item sword = new Item(Item.SWORD);
            sword.name = "Long sword";
            sword.description = "This is a long sword";
            sword.damage = 10;
            sword.price = 100;

            Quest necklaceQuest = new Quest(Quest.FIND_THE_WALLET);
            necklaceQuest.name = "Find the Stolen Necklace";
            necklaceQuest.description = "You must go to the bandit's house and find the Innkeeper's daughter's stolen necklace.";
            necklaceQuest.rewardGold = 10;
            necklaceQuest.rewardItems.add(sword); // add items to the list of rewards
            Hero.addQuest(necklaceQuest);
            Input.pressEnterToContinue();
        } else if (Hero.hasCompletedQuest(Quest.FIND_THE_WALLET) == true) {
            System.out.println("The innkeeper looks happy now that his daughter's necklace has been returned");
            Input.pressEnterToContinue();
        } else {
            System.out.println("The innkeeper is waiting for you to find the necklace");
            Input.pressEnterToContinue();
        }

        if (Hero.canCompleteQuest(Quest.FIND_THE_WALLET, Item.LOST_WALLET)) {
            System.out.println("Wow! You found the necklace! Thank you here is your reward!");
            Hero.completeQuest(Quest.FIND_THE_WALLET); // give the reward and complete quest
            Input.pressEnterToContinue();
        }

        return Locations.TOWN_START;
    }

    // write this using the reference from doInn()
    public static String doMonsterStart() {
        Game.clearScreen();
        System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                + "Welcome to the dungeon... traveler");

        return Locations.TOWN_START;
    }

    public static String doBossStart() {
        System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                + "Please... defeat them and come back");

        return Locations.TOWN_START;

    }
}