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
                    + "Please choose where you are going or what you want to do( " + ConsoleColors.BLUE
                    + "house, temple, shop, monster dungeon, boss dungeon, inventory, quests, stats"
                    + ConsoleColors.RESET
                    + ")");

            String answer = Input.getString().toLowerCase();

            if (answer.equals("shop")) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "You enter the shop...");
                Input.pressEnterToContinue();
                return Locations.TOWN_SHOP;
            } else if (answer.equals("house")) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "Going into the house...");
                Input.pressEnterToContinue();
                return Locations.TOWN_HOUSE;
            } else if (answer.equals("temple")) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                                + "Entering the ancient temple...");
                Input.pressEnterToContinue();
                return Locations.TOWN_TEMPLE;
            } else if (answer.equals("monster dungeon")) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "Entering the dungeon...");
                Input.pressEnterToContinue();
                return Locations.MONSTER_DUNGEON_START;
            } else if (answer.equals("boss dungeon")) {
                System.out
                        .println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RED_BOLD
                                + "PREPARE FOR THE DEATH" + ConsoleColors.RESET);
                Input.pressEnterToContinue();
                return Locations.BOSS_DUNGEON_START;
            } else if (answer.equals("inventory")) {
                Hero.showInventory();
                Input.pressEnterToContinue();
                return Locations.TOWN_START;
            } else if (answer.equals("quests")) {
                Hero.showQuests();
                Input.pressEnterToContinue();
                return Locations.TOWN_START;
            } else if (answer.equals("stats")) {
                Hero.displayStats();
                Input.pressEnterToContinue();
                return Locations.TOWN_START;
            }

            else {
                System.out.println(
                        ConsoleColors.RED_BOLD + "[Error] " + ConsoleColors.RESET + "Please enter the valid response");
                Input.pressEnterToContinue();
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

        System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                + "You walked to the front of the house and unlocked the door");
        Input.pressEnterToContinue();

        do {
            Game.clearScreen();
            System.out.format(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                    + "You can %s the door or go back to %s\n", Game.blue("open"), Game.blue("town"));
            System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                    + "Please choose what you want to do");
            String answer = Input.getString().toLowerCase();

            if (answer.equals("open")) {
                openDoorHouse();
                return Locations.TOWN_START;
            } else if (answer.equals("town")) {
                System.out.println(
                        ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "Heading back to the town...");
                Input.pressEnterToContinue();
                return Locations.TOWN_START;
            } else {
                System.out.println(
                        ConsoleColors.RED_BOLD + "[Error] " + ConsoleColors.RESET + "Please enter the valid response");
                Input.pressEnterToContinue();
            }

        } while (true);

    }

    public static void openDoorHouse() {

        if (Hero.hasQuest(Quest.FIND_THE_WALLET) == true) { // verify they have the quest
            if (Hero.hasCompletedQuest(Quest.FIND_THE_WALLET) == false) { // verify they have not turned in
                if (Hero.hasItem(Item.LOST_WALLET) == false) { // verify the player found the lost necklace
                    System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                            + "You see a man holding the wallet, you killed him, and got the wallet");
                    Item wallet = new Item(Item.LOST_WALLET);
                    wallet.name = "Lost wallet";
                    wallet.description = "This wallet had lost since 1930s and it was from the dungeon master's ancestor";
                    wallet.price = 100;
                    Hero.addItem(wallet);
                    System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                            + "Heading back to the town...");
                    Input.pressEnterToContinue();
                } else {
                    System.out.println(
                            ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                                    + "You have already found the lost wallet, please return it to the Dungeon Master to collect your reward");
                    Input.pressEnterToContinue();

                }
            } else {
                System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                        + "This is where you found the wallet that you returned");

                Input.pressEnterToContinue();

            }
        } else {
            System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET + "Nothing is here");
            Input.pressEnterToContinue();

        }
    }

    // write this using the reference from doInn()
    public static String doMonsterStart() {
        Game.clearScreen();
        System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                + "Welcome to the dungeon... traveler");

        // FIND THE WALLET QUEST
        if (!Hero.hasQuest(Quest.FIND_THE_WALLET) && !Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)) {
            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                    + "Traveler, have you found my lost wallet that my ancestor left them for me?");

            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                    + "The last evidence I found was that it could be in the house near the town.");

            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                    + "I will give you a great reward if you found and handed it to me!");

            Item sword = new Item(Item.SWORD);
            sword.name = "Long sword";
            sword.description = "The beginner sword";
            sword.damage = 10;
            sword.price = 100;

            Quest walletQuest = new Quest(Quest.FIND_THE_WALLET);
            walletQuest.name = "Find the Lost Wallet";
            walletQuest.description = "You must go to the house near the town and return Dungeon Master the lost wallet";
            walletQuest.rewardGold = 10;
            walletQuest.rewardItems.add(sword);
            Hero.addQuest(walletQuest);
            Input.pressEnterToContinue();

        } else if (Hero.hasCompletedQuest(Quest.FIND_THE_WALLET)) {

        } else {
            System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
                    + "Dungeon Master is still waiting for you to return the lost wallet");

            Input.pressEnterToContinue();

        }

        if (Hero.canCompleteQuest(Quest.FIND_THE_WALLET, Item.LOST_WALLET)) {
            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                    + "Finally, I am able to become a millionaire from this wallet! Here is your reward, traveler!");
            Hero.completeQuest(Quest.FIND_THE_WALLET);
            Input.pressEnterToContinue();
        }

        // MONSTER DUNGEON LEVEL ONE
        if (!Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE) && !Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_TWO)
                && !Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_THREE)) {
            Game.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " +
                    ConsoleColors.RESET
                    + "Now you're free to enter the first monster dungeons.");

            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                    + "Each level of the dungeon will have 10 monsters. You must hunt all of them to clear each dungeon.");
            Item monsterDungeonTwoKey = new Item(Item.MONSTER_DUNGEON_TWO_KEY);
            monsterDungeonTwoKey.name = "Monster Dungeon 2 Key";
            monsterDungeonTwoKey.description = "A key to unlock the second monster dungeon. You can get the key after clearing the first monster dungeon";
            monsterDungeonTwoKey.price = 100;

            Quest monsterDungeonOneQuest = new Quest(Quest.MONSTER_DUNGEON_LEVEL_ONE);
            monsterDungeonOneQuest.name = "Hunt 10 zombies in Dungeon One";
            monsterDungeonOneQuest.description = "You must hunt 10 zpmbies in the Dungeon One";
            monsterDungeonOneQuest.rewardGold = 20;
            monsterDungeonOneQuest.rewardItems.add(monsterDungeonTwoKey);
            Hero.addQuest(monsterDungeonOneQuest);
        }

        // MONSTER DUNGEON LEVEL TWO
        if (Hero.hasCompletedQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)
                && Hero.hasItem(Item.MONSTER_DUNGEON_THREE_KEY)
                && !Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_TWO)
                && !Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_THREE)) {

            Game.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "Ah, brave hero! You have conquered the first dungeon and now stand before the entrance of the next. Steel your heart, for greater challenges lie ahead. May fortune favor your endeavors!");
            
            Item monsterDungeonThreeKey = new Item(Item.MONSTER_DUNGEON_THREE_KEY);
            monsterDungeonThreeKey.name = "Monster Dungeon 3 Key";
            monsterDungeonThreeKey.description = "A key to unlock the third monster dungeon. You can get the key after clearing the second monster dungeon";
            monsterDungeonThreeKey.price = 100;

            Quest monsterDungeonTwoQuest = new Quest(Quest.MONSTER_DUNGEON_LEVEL_TWO);
            monsterDungeonTwoQuest.name = "Hunt 10 spiders in Dungeon Two";
            monsterDungeonTwoQuest.description = "You must hunt 10 spiders in the Dungeon Two";
            monsterDungeonTwoQuest.rewardGold = 20;
            monsterDungeonTwoQuest.rewardItems.add(monsterDungeonThreeKey);
            Hero.addQuest(monsterDungeonTwoQuest);
            Input.pressEnterToContinue();
        }

        if(Hero.hasCompletedQuest(Quest.FIND_THE_WALLET)) {
            
            do {
                Game.clearScreen();
                System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
                        ConsoleColors.RESET
                        + "Select where you want to go: ( " + ConsoleColors.BLUE
                        + "Monster Dungeon 1, Monster Dungeon 2, Monster Dungeon 3, back" + ConsoleColors.RESET + " )");
                
                String monsterChoice = Input.getString().toLowerCase();
        
                if (monsterChoice.equals("monster dungeon 1")) {
                    MonsterDungeons.monsterDungeonOne();
                    if(Hero.health <= 0) {
                        return Locations.QUITGAME;
                    }
                    return Locations.TOWN_START;
                } else if (monsterChoice.equals("monster dungeon 2")) {
                    MonsterDungeons.monsterDungeonTwo();
                    if(Hero.health <= 0) {
                        return Locations.QUITGAME;
                    }
                    return Locations.TOWN_START;
                } else if (monsterChoice.equals("monster dungeon 3")) {
                    MonsterDungeons.monsterDungeonThree();
                    if(Hero.health <= 0) {
                        return Locations.QUITGAME;
                    }
                    return Locations.TOWN_START;
                } else if (monsterChoice.equals("back")) {
                    return Locations.TOWN_START;
                } else {

                }
            } while (true);
        
        }


        return Locations.TOWN_START;
    }

    public static String doBossStart() {
        Game.clearScreen();

        // Have Quest Boss Dungeon Level 1 or Has Completed it
        if (Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_ONE) || Hero.hasCompletedQuest(Quest.BOSS_DUNGEON_LEVEL_ONE)) {
            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                    + "Welcome to the dungeon... traveler");
        }

        // Never have the Quest
        if (!Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_ONE)) {
            System.out.println(ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET
                    + "Sorry, traveler. You are not ready to get in this place yet.");
        }

        Input.pressEnterToContinue();
        return Locations.TOWN_START;

    }
}
