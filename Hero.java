import java.util.ArrayList;

public class Hero {
  // put your variables here, they should be static
  public static String name;
  public static int level = 1;
  public static int xp;
  public static int attackDamage;
  public static int magicDamage;
  public static int health;
  public static int maxHealth;
  public static int job;
  public static int gold = 100;
  public static int speed;
  public static int monsterDungeonProgress;
  public static ArrayList<Item> inventory = new ArrayList<Item>();
  public static ArrayList<Quest> quests = new ArrayList<Quest>();

  // put your methods here

  public static void generate() {
    // this method generates the Hero

    System.out.println("Enter your name: ");

    Hero.name = Input.getString();
    while (Hero.name.length() < 2 || Hero.name.length() > 10) {
      System.out.println("You need to have more than 2 letters but less than 10 letters");
      Hero.name = Input.getString();
    }

    Game.clearScreen();

    while (true) {
      System.out.println("Choose your job: ");
      System.out.println("1. Knight\n2. Magician\n3. Priest");
      Hero.job = Input.getInt();

      if (job == 1) {
        Hero.maxHealth = 20;
        Hero.health = Hero.maxHealth;
        Hero.attackDamage = 15;
        Hero.magicDamage = 0;
        Hero.speed = 10;
        break;
      } else if (job == 2) {
        Hero.maxHealth = 15;
        Hero.health = Hero.maxHealth;
        Hero.attackDamage = 0;
        Hero.magicDamage = 20;
        Hero.speed = 20;
        break;
      } else if (job == 3) {
        Hero.maxHealth = 15;
        Hero.health = Hero.maxHealth;
        Hero.attackDamage = 10;
        Hero.magicDamage = 5;
        Hero.speed = 15;
        break;
      } else {
        System.out.println("Invalid input");

      }
    }

    Game.clearScreen();

    int initialStatsUpgrade = 10;

    while (initialStatsUpgrade != 0) {
      System.out.format("You are given %d points left to upgrade your initial stats!\n", initialStatsUpgrade);
      System.out.format("1. Attack Damage: %d\n2. Magic Damage: %d\n3. Speed: %d\n4. Max Health: %d\n",
          Hero.attackDamage, Hero.magicDamage, Hero.speed, Hero.maxHealth);
      System.out.println("You're choosing (1/2/3/4): ");

      int chosenNumber = Input.getInt();

      switch (chosenNumber) {
        case 1:
          initialStatsUpgrade--;
          Hero.attackDamage++;

          break;

        case 2:
          initialStatsUpgrade--;
          Hero.magicDamage++;

          break;

        case 3:
          initialStatsUpgrade--;
          Hero.speed++;


          break;

        case 4:
          initialStatsUpgrade--;
          Hero.maxHealth++;
          Hero.health = Hero.maxHealth;

          break;

        default:
          System.out.println("Wrong number. You can choose only 1 to 4");
          break;

      }

      Game.clearScreen();
    }

  }

  public static boolean hasItem(int id) {
    for (Item i : Hero.inventory) {
      if (i.id == id) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasQuest(int id) {
    for (Quest q : Hero.quests) {
      if (q.id == id) {
        return true;
      }
    }
    return false;
  }

  public static void addItem(Item item) {
    Hero.inventory.add(item);

    System.out.println(ConsoleColors.CYAN_BRIGHT);
    System.out.println("You have acquired an item: " + item.name);
    System.out.println(ConsoleColors.RESET);
  }

  public static void addQuest(Quest quest) {
    Hero.quests.add(quest);

    System.out.println(ConsoleColors.GREEN_BRIGHT);
    System.out.println("Quest Accepted: " + quest.name);
    System.out.println(ConsoleColors.RESET);
  }

  public static boolean hasCompletedQuest(int id) {
    for (Quest q : Hero.quests) {
      if (q.id == id && q.isCompleted == true) {
        return true;
      }
    }
    return false;
  }

  // This method checks if the Hero has the quest, it is not completed yet,
  // and checks if they have the item
  public static boolean canCompleteQuest(int questId, int itemId) {
    if (Hero.hasQuest(questId) == true) { // verify they have the quest
      if (Hero.hasCompletedQuest(questId) == false) { // verify they have not turned in
        if (Hero.hasItem(itemId) == true) { // verify the player found the lost necklace
          return true;
        }
      }
    }

    return false;
  }

  public static void completeQuest(int id) {
    for (Quest q : Hero.quests) {
      if (q.id == id) {
        q.isCompleted = true;

        System.out.println(ConsoleColors.GREEN_BRIGHT);

        System.out.println("Quest Complete: " + q.name);
        Hero.gold = Hero.gold + q.rewardGold;
        System.out.format("You gained %d gold\n", q.rewardGold);

        for (Item i : q.rewardItems) {
          System.out.println("Item acquired: " + i.name);
          Hero.inventory.add(i);
        }

        System.out.println(ConsoleColors.RESET);
      }
    }
  }

  public static void showInventory() {
    System.out.println(ConsoleColors.WHITE_UNDERLINED + "YOUR INVENTORY" + ConsoleColors.RESET);
    System.out.println(inventory);
  }

  public static void showQuests() {
    System.out.println("HERO QUESTS!");
    for (Quest q : Hero.quests) {
      System.out.println(q.name + "(ID: " + q.id + " ) " + Hero.hasCompletedQuest(q.id));
    }
  }

  public static void displayStats() {
    // this method displays all info
    Game.clearScreen();

    System.out.println(ConsoleColors.BLUE_BOLD + "Player Stats: \n");
    System.out.print(ConsoleColors.RESET);
    if (job == 1) {
      System.out.println(ConsoleColors.WHITE_BACKGROUND + "Job: " + ConsoleColors.BLACK_BOLD + "Knight");
    }

    if (job == 2) {
      System.out.println(ConsoleColors.WHITE_BACKGROUND + "Job: " + ConsoleColors.BLUE_BOLD + "Magician");
    }

    if (job == 3) {
      System.out.println(ConsoleColors.WHITE_BACKGROUND + "Job: " + ConsoleColors.YELLOW_BOLD + "Priest");
    }
    System.out.print(ConsoleColors.RESET);

    System.out.println(
        ConsoleColors.YELLOW_BOLD + "Health: " + ConsoleColors.GREEN_BOLD + Hero.health + "/" + Hero.maxHealth);
    System.out.println(
        ConsoleColors.YELLOW_BOLD + "Speed: " + ConsoleColors.GREEN_BOLD + Hero.speed);
    System.out.println(ConsoleColors.YELLOW_BOLD + "Level: " + ConsoleColors.GREEN_BOLD + Hero.level);
    System.out.println(
        ConsoleColors.YELLOW_BOLD + "Gold: " + ConsoleColors.GREEN_BOLD + Hero.gold);
    System.out.println(ConsoleColors.YELLOW_BOLD + "Attack Damage: " + ConsoleColors.GREEN_BOLD + Hero.attackDamage);
    System.out.println(ConsoleColors.YELLOW_BOLD + "Magic Damage: " + ConsoleColors.GREEN_BOLD + Hero.magicDamage);
    System.out.println(ConsoleColors.RESET);
  }

  public static void takeDamage(int damage) {
    Hero.health = Hero.health - damage;

    if (Hero.health < 0) {
      Hero.health = 0;
    }

    System.out.println(ConsoleColors.RED);
    System.out.format("\n\nYou took %d damage, %d health remaining.", damage, Hero.health);
    System.out.println(ConsoleColors.RESET);
  }

  public static void attack(Monster enemy) {

    int attack = Game.random.nextInt(Hero.attackDamage) + 1;

    enemy.health = enemy.health - attack;

    System.out.println(ConsoleColors.GREEN_BRIGHT);
    System.out.format("\n%s attacks %s for %d damage! %d health remaining.", Hero.name, enemy.name, attack,
        enemy.health);
    System.out.println(ConsoleColors.RESET);

    Game.sleep(1);
  }

  public static void fight(Monster enemy) {
    Game.clearScreen();

    System.out.println("********COMBAT********");

    boolean fightOver = false;

    do {
      if (Hero.speed >= enemy.speed) { // hero is faster
        Hero.attack(enemy);
        if (enemy.checkDefeat()) {
          fightOver = true;
        } else {
          enemy.attack();
          if (Hero.checkDefeat()) {
            fightOver = true;
          }
        }

      } else { // enemy is faster
        enemy.attack();
        if (Hero.checkDefeat()) {
          fightOver = true;
        } else {

          Hero.attack(enemy);
          if (enemy.checkDefeat()) {
            fightOver = true;
          }

        }
      }
    } while (fightOver == false);

    Input.pressEnterToContinue();
  }

  public static void lootMonster(Monster enemy) {
    System.out.println(ConsoleColors.GREEN_BRIGHT);
    System.out.println("You looted the " + enemy.name);

    Hero.gold += enemy.rewardGold;
    System.out.format("%d gold obtained\n", enemy.rewardGold);

    Hero.xp += enemy.rewardXP;
    System.out.format("%d xp gained\n", enemy.rewardXP);

    System.out.println(ConsoleColors.RESET);
  }

  public static boolean checkDefeat() {
    if (Hero.health > 0) {
      return false;
    } else {
      System.out.println(ConsoleColors.RED);
      System.out.println("You Died.");
      System.out.println(ConsoleColors.RESET);
      return true;
    }
  }

}
