
public class MonsterDungeons {
	private static int monsterDungeonOneCount = 0;
	// Zombie Atk: 1, Health: 5 ( wave 1 - 5)
	// Spider Atk: 3, Health: 1 ( wave 6 - 8 )
	// Werewolf Atk: 3, Health: 5 ( wave 9-10 )

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
			System.out.println(ConsoleColors.GREEN_BOLD + "[Zombie] " + ConsoleColors.RESET + "Mrh? Mrh? Bruhhhh");
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
