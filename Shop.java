import java.util.*;

public class Shop {

    public static ArrayList<Item> itemsForSale = new ArrayList<Item>();

    public static boolean firstTime = true; // track if user has enter shop before

    // the first time the user visits the shop we need to add items for sale
    public static void stockShelf() {

        if (firstTime == true) {
            firstTime = false;

            boolean firstTime = true;

            Item shortsword = new Item(Item.SHORT_SWORD);
            shortsword.name = "Short Sword";
            shortsword.price = 10;
            itemsForSale.add(shortsword);

            Item hppotion = new Item(Item.HEALING_POTION);
            hppotion.name = "Healing Potion";
            hppotion.price = 25;
            itemsForSale.add(hppotion);

            Item shield = new Item(Item.SHIELD);
            shield.name = "Shield";
            shield.price = 25;
            itemsForSale.add(shield);

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