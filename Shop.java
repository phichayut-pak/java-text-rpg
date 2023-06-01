import java.util.*;

public class Shop {

    public static ArrayList<Item> itemsForSale = new ArrayList<Item>();

    public static boolean firstTime = true; // track if user has enter shop before

    // the first time the user visits the shop we need to add items for sale
    public static void stockShelf() {

        if (firstTime == true) {
            firstTime = false;

            boolean firstTime = true;

            // SMALL EMBLEMS
            Item smallHealthEmblem = new Item(Item.SMALL_HEALTH_EMBLEM);
            smallHealthEmblem.name = "Small Health Emblem";
            smallHealthEmblem.price = 100;
            itemsForSale.add(smallHealthEmblem);

            if(Hero.job != 2) { // if not magician
                Item smallAttackEmblem = new Item(Item.SMALL_ATTACK_EMBLEM);
                smallAttackEmblem.name = "Small Attack Emblem";
                smallAttackEmblem.price = 100;
                itemsForSale.add(smallAttackEmblem);
            }

            if(Hero.job != 1) { // if not knight
                Item smallMagicEmblem = new Item(Item.SMALL_MAGIC_EMBLEM);
                smallMagicEmblem.name = "Small Magic Emblem";
                smallMagicEmblem.price = 100;
                itemsForSale.add(smallMagicEmblem);
            }

            Item smallSpeedEmblem = new Item(Item.SMALL_SPEED_EMBLEM);
            smallSpeedEmblem.name = "Small Speed Emblem";
            smallSpeedEmblem.price = 100;
            itemsForSale.add(smallSpeedEmblem);

            // MEDIUM EMBLEMS
            Item mediumHealthEmblem = new Item(Item.MEDIUM_HEALTH_EMBLEM);
            mediumHealthEmblem.name = "Medium Health Emblem";
            mediumHealthEmblem.price = 300;
            itemsForSale.add(mediumHealthEmblem);

            if(Hero.job != 2) {
                Item mediumAttackEmblem = new Item(Item.MEDIUM_ATTACK_EMBLEM);
                mediumAttackEmblem.name = "Medium Attack Emblem";
                mediumAttackEmblem.price = 300;
                itemsForSale.add(mediumAttackEmblem);
            }

            if(Hero.job != 1) {
                Item mediumMagicEmblem = new Item(Item.MEDIUM_MAGIC_EMBLEM);
                mediumMagicEmblem.name = "Medium Magic Emblem";
                mediumMagicEmblem.price = 300;
                itemsForSale.add(mediumMagicEmblem);
            }

            Item mediumSpeedEmblem = new Item(Item.MEDIUM_SPEED_EMBLEM);
            mediumSpeedEmblem.name = "Medium Speed Emblem";
            mediumSpeedEmblem.price = 300;
            itemsForSale.add(mediumSpeedEmblem);

            // LARGE EMBLEMS
            Item largeHealthEmblem = new Item(Item.LARGE_HEALTH_EMBLEM);
            largeHealthEmblem.name = "Large Health Emblem";
            largeHealthEmblem.price = 500;
            itemsForSale.add(largeHealthEmblem);

            if(Hero.job != 2) {
                Item largeAttackEmblem = new Item(Item.LARGE_ATTACK_EMBLEM);
                largeAttackEmblem.name = "Large Attack Emblem";
                largeAttackEmblem.price = 500;
                itemsForSale.add(largeAttackEmblem);
            }

            if(Hero.job != 1) {
                Item largeMagicEmblem = new Item(Item.LARGE_MAGIC_EMBLEM);
                largeMagicEmblem.name = "Large Magic Emblem";
                largeMagicEmblem.price = 500;
                itemsForSale.add(largeMagicEmblem);
            }

            Item largeSpeedEmblem = new Item(Item.LARGE_SPEED_EMBLEM);
            largeSpeedEmblem.name = "Large Speed Emblem";
            largeSpeedEmblem.price = 500;
            itemsForSale.add(largeSpeedEmblem);

        }
    }

    public static void doShop() {
        Shop.stockShelf();
        boolean shoppingComplete = false;

        do {
            Game.clearScreen();
            System.out.println("Here is what I have for sale: \n");
            int i = 1;

            for (Item item : itemsForSale) {
                System.out.format("%d. %s (%d gold)\n", i++, item.name, item.price);
            }

            System.out.format("\nYou have %d gold.\n\n", Hero.gold);

            Hero.showInventory();

            System.out.format("\n\nChoose the item %s or %s the shop.\n", Game.keyword("number"),
                    Game.keyword("leave"));

            // User typed in an integer
            if (Input.scan.hasNextInt()) {

                int choice = Input.getInt() - 1;

                if (choice < itemsForSale.size() && choice >= 0) {
                    Item item = itemsForSale.get(choice);

                    if (Hero.gold >= item.price) {

                        Hero.gold -= item.price;

                        Hero.addItem(itemsForSale.remove(choice));

                        Shop.stockShelf();
                        Input.pressEnterToContinue();

                    } else {
                        System.out.format("\nSorry you cannot afford to buy the %s\n", item.name);
                        Input.pressEnterToContinue();
                    }
                } else {
                    System.out.println("Sorry that is not a valid choice");
                    Input.pressEnterToContinue();
                }

                // User typed in words or letters
            } else {
                String selection = Input.getString();

                if (selection.equalsIgnoreCase("leave")) {
                    shoppingComplete = true;
                } else {
                    System.out.println("Sorry that is not a valid choice");
                    Input.pressEnterToContinue();
                }
            }
        } while (shoppingComplete == false);

    }
}