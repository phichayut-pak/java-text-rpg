
public class MonsterDungeons {
	// Zombie Atk: 5, Health: 10, Speed: 10 
	// Spider Atk: 3, Health: 1, Speed: 7 
	// Werewolf Atk: 3, Health: 5, Speed: 10 

	public static void monsterDungeonOne() {
		Game.clearScreen();
		if (!Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)) {
			System.out.println(Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE));
			System.out.println(
					ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "You are not ready, traveler");
			Input.pressEnterToContinue();

			// START FIGHTING HERE
		} else if (Hero.hasQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)) {
			System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLACK_BOLD + "Monster 1");

			for (int i = 0; i < 10; i++) {
				System.out.println(ConsoleColors.GREEN_BOLD + "[Zombie] " + ConsoleColors.RESET + "Mrh? Mrh? Bruhhhh");
				Monster zombie = new Monster("Zombie");
				zombie.attackDamage = 5;
				zombie.health = 10;
				zombie.speed = 10;
				zombie.rewardGold = 10;
				zombie.rewardXP = 100;

				Hero.fight(zombie);

				if (Hero.health > 0) {
					Game.clearScreen();
					Hero.lootMonster(zombie);
					Input.pressEnterToContinue();
					System.out.println(ConsoleColors.RESET);

				} else {
					Game.clearScreen();
					Game.doAfterlife();
				}
			}
			Game.clearScreen();
			Hero.completeQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE);
			Input.pressEnterToContinue();


			

		} else if (Hero.hasCompletedQuest(Quest.MONSTER_DUNGEON_LEVEL_ONE)) {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
					+ "There is nothing in the dungeon since you already cleared them");

			Input.pressEnterToContinue();
		} else {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
					ConsoleColors.RESET
					+ "Dungeon Master is still waiting for you to clear Dungeon One");
			Input.pressEnterToContinue();
		}
	}
}


// can continue with the second monster dungeon