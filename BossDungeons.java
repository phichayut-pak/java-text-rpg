public class BossDungeons {
  public static void bossDungeonOne() {
		Game.clearScreen();
		if (!Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_ONE)) {

			System.out.println(
					ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "You are not ready, traveler");
			Input.pressEnterToContinue();

			// START FIGHTING HERE
		} else if (Hero.hasCompletedQuest(Quest.BOSS_DUNGEON_LEVEL_ONE)) {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
					+ "There is nothing in the dungeon since you already cleared them");

			Input.pressEnterToContinue();
		} else if (Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_ONE)) {
      Game.clearScreen();
      System.out.println(ConsoleColors.RED_BOLD + "[Emberfang] " + ConsoleColors.RESET + "Intruders, you dare trespass into my domain? Prepare to be consumed by the fury of my flames! None shall challenge my might and live to tell the tale!");
      Input.pressEnterToContinue();
      Monster emberfang = new Monster("Emberfang");
      emberfang.attackDamage = 12; // 30
      emberfang.health = 50;
      emberfang.speed = 10;
      emberfang.rewardGold = 500;
      emberfang.rewardXP = 100;

      Hero.fight(emberfang);

      if (Hero.health <= 0) {
        Game.clearScreen();
        Game.doAfterlife();

      } else {
        Game.clearScreen();
        Hero.lootMonster(emberfang);
        Input.pressEnterToContinue();
        System.out.println(ConsoleColors.RESET);
      }
			

			if (Hero.health > 0) {
				Game.clearScreen();
				Hero.completeQuest(Quest.BOSS_DUNGEON_LEVEL_ONE);
				Input.pressEnterToContinue();
			}

		} else {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
					ConsoleColors.RESET
					+ "Dungeon Master is still waiting for you to clear Boss Dungeon One");
			Input.pressEnterToContinue();
		}
	}

  public static void bossDungeonTwo() {
		Game.clearScreen();
		if (!Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_TWO)) {
			System.out.println(
					ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "You are not ready, traveler");
			Input.pressEnterToContinue();

			// START FIGHTING HERE
		} else if (Hero.hasCompletedQuest(Quest.BOSS_DUNGEON_LEVEL_TWO)) {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
					+ "There is nothing in the dungeon since you already cleared them");

			Input.pressEnterToContinue();
		} else if (Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_TWO)) {

      Game.clearScreen();
      System.out.println(ConsoleColors.BLUE_BOLD + "[Frozen Tyrant] " + ConsoleColors.RESET + "Feeble mortals, you dare to challenge the might of the Frozen Tyrant? Your futile resistance will only serve to deepen your icy demise. Behold the power of winter's embrace!");
      Input.pressEnterToContinue();

      Monster frozenTyrant = new Monster("Frozen Tyrant");
      frozenTyrant.attackDamage = 15; // 8
      frozenTyrant.health = 70;
      frozenTyrant.speed = 12;
      frozenTyrant.rewardGold = 1000;
      frozenTyrant.rewardXP = 150;

      Hero.fight(frozenTyrant);

      if (Hero.health <= 0) {
        Game.clearScreen();
        Game.doAfterlife();

      } else {
        Game.clearScreen();
        Hero.lootMonster(frozenTyrant);
        Input.pressEnterToContinue();
        System.out.println(ConsoleColors.RESET);
      }
			

			if (Hero.health > 0) {
				Game.clearScreen();
				Hero.completeQuest(Quest.BOSS_DUNGEON_LEVEL_TWO);
				Input.pressEnterToContinue();
			}

		} else {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
					ConsoleColors.RESET
					+ "Dungeon Master is still waiting for you to clear Boss Dungeon Two");

			Input.pressEnterToContinue();
		}
	}

  public static void bossDungeonThree() {
		Game.clearScreen();
		if (!Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_THREE)) {
			System.out.println(
					ConsoleColors.RED_BOLD + "[Dungeon Master] " + ConsoleColors.RESET + "You are not ready, traveler");
			Input.pressEnterToContinue();

			// START FIGHTING HERE
		} else if (Hero.hasCompletedQuest(Quest.BOSS_DUNGEON_LEVEL_THREE)) {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " + ConsoleColors.RESET
					+ "There is nothing in the dungeon since you already cleared them");

			Input.pressEnterToContinue();
		} else if (Hero.hasQuest(Quest.BOSS_DUNGEON_LEVEL_THREE)) {

      Game.clearScreen();
      System.out.println(ConsoleColors.BLACK_BOLD + "[Malumbrar] " + ConsoleColors.RESET + "Welcome, fools, to the realm of eternal shadows. You dare challenge the Shadow Sovereign? You shall know the futility of your efforts as your feeble light is swallowed by the abyss. Prepare to be consumed by the true darkness!");
      Input.pressEnterToContinue();

      Monster malumbrar = new Monster("Malumbrar");
      malumbrar.attackDamage = 20; // 8
      malumbrar.health = 100;
      malumbrar.speed = 12;
      malumbrar.rewardGold = 15;
      malumbrar.rewardXP = 150;

      Hero.fight(malumbrar);

      if (Hero.health <= 0) {
        Game.clearScreen();
        Game.doAfterlife();

      } else {
        Game.clearScreen();
        Hero.lootMonster(malumbrar);
        Input.pressEnterToContinue();
        System.out.println(ConsoleColors.RESET);
      }
			

			if (Hero.health > 0) {
				Game.clearScreen();
				Hero.completeQuest(Quest.BOSS_DUNGEON_LEVEL_THREE);
				Input.pressEnterToContinue();
			}

		} else {
			System.out.println(ConsoleColors.GREEN_BOLD + "[Console] " +
					ConsoleColors.RESET
					+ "Dungeon Master is still waiting for you to clear Boss Dungeon Three");

			Input.pressEnterToContinue();
		}
	}
}
