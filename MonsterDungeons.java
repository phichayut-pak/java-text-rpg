
public class MonsterDungeons {
	// Zombie Atk: 5, Health: 10, Speed: 10
	// Spider Atk: 3, Health: 1, Speed: 7
	// Werewolf Atk: 3, Health: 5, Speed: 10

	public static void monsterDungeonOne() {
		Game.clearScreen();
		if (!Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)) {

			System.out.println(
					ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "You are not ready, traveler");
			Input.pressEnterToContinue();

			// START FIGHTING HERE
		} else if (Hero.hasCompletedQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)) {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
					+ "There is nothing in the dungeon since you already cleared them");

			Input.pressEnterToContinue();
		} else if (Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)) {
			System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLACK_BOLD + "Monster 1");

			for (int i = 0; i < 10; i++) {
				System.out.println(ConsoleColors.GREEN_BOLD + "[Zombie] " + ConsoleColors.RESET + "Mrh? Mrh? Bruhhhh");
				Monster zombie = new Monster("Zombie");
				zombie.attackDamage = 4; // 4
				zombie.health = 10;
				zombie.speed = 10;
				zombie.rewardGold = 10;
				zombie.rewardXP = 100;

				Hero.fight(zombie);

				if (Hero.health <= 0) {
					Game.clearScreen();
					Game.doAfterlife();
					break;

				} else {
					Game.clearScreen();
					Hero.lootMonster(zombie);
					Input.pressEnterToContinue();
					System.out.println(ConsoleColors.RESET);
				}
			}

			if (Hero.health > 0) {
				Game.clearScreen();
				Hero.completeQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE);
				Input.pressEnterToContinue();
			}

		} else {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
					ConsoleColors.RESET
					+ "Dungeon Master is still waiting for you to clear Dungeon One");
			Input.pressEnterToContinue();
		}
	}

	public static void monsterDungeonTwo() {
		Game.clearScreen();
		if (!Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_TWO)) {
			System.out.println(
					ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "You are not ready, traveler");
			Input.pressEnterToContinue();

			// START FIGHTING HERE
		} else if (Hero.hasCompletedQuest(Quest.MONSTER_DUNGEON_LEVEL_TWO)) {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
					+ "There is nothing in the dungeon since you already cleared them");

			Input.pressEnterToContinue();
		} else if (Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_TWO)) {
			System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLACK_BOLD + "Monster 2");

			for (int i = 0; i < 10; i++) {
				System.out.println(ConsoleColors.GREEN_BOLD + "[Spider] " + ConsoleColors.RESET + "Sssss Tssss");
				Monster spider = new Monster("Spider");
				spider.attackDamage = 1; // 8
				spider.health = 6;
				spider.speed = 12;
				spider.rewardGold = 15;
				spider.rewardXP = 150;

				Hero.fight(spider);

				if (Hero.health <= 0) {
					Game.clearScreen();
					Game.doAfterlife();
					break;

				} else {
					Game.clearScreen();
					Hero.lootMonster(spider);
					Input.pressEnterToContinue();
					System.out.println(ConsoleColors.RESET);
				}
			}

			if (Hero.health > 0) {
				Game.clearScreen();
				Hero.completeQuest(Quest.MONSTER_DUNGEON_LEVEL_TWO);
				Input.pressEnterToContinue();
			}

		} else {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
					ConsoleColors.RESET
					+ "Dungeon Master is still waiting for you to clear Dungeon Two");

			Input.pressEnterToContinue();
		}
	}

	public static void monsterDungeonThree() {
		Game.clearScreen();
		if (!Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_THREE)) {
			System.out.println(
					ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "You are not ready, traveler");
			Input.pressEnterToContinue();

			// START FIGHTING HERE
		} else if (Hero.hasCompletedQuest(Quest.MONSTER_DUNGEON_LEVEL_THREE)) {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
					+ "There is nothing in the dungeon since you already cleared them");

			Input.pressEnterToContinue();
		} else if (Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_THREE)) {
			System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLACK_BOLD + "Monster 3");

			for (int i = 0; i < 10; i++) {
				System.out.println(ConsoleColors.GRAY_BOLD + "[Werewolf] " + ConsoleColors.RESET + "Awoooo!");
				Monster werewolf = new Monster("Werewolf");
				werewolf.attackDamage = 3; // 3
				werewolf.health = 10;
				werewolf.speed = 15;
				werewolf.rewardGold = 20;
				werewolf.rewardXP = 200;

				Hero.fight(werewolf);

				if (Hero.health <= 0) {
					Game.clearScreen();
					Game.doAfterlife();
					break;

				} else {
					Game.clearScreen();
					Hero.lootMonster(werewolf);
					Input.pressEnterToContinue();
					System.out.println(ConsoleColors.RESET);
				}
			}

			if (Hero.health > 0) {
				Game.clearScreen();
				Hero.completeQuest(Quest.MONSTER_DUNGEON_LEVEL_THREE);
				Input.pressEnterToContinue();
			}

		} else {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
					ConsoleColors.RESET
					+ "Dungeon Master is still waiting for you to clear Dungeon Three");
			Input.pressEnterToContinue();
		}
	}
}

// can continue with the second monster dungeon