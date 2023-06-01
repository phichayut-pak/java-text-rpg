import java.util.*;

public class Game {

  public static Random random = new Random();
  public static Object strength;

  public static void start() {
    // This is where the game starts

    String nextLocation = Locations.INTRO;

    do {

      if (nextLocation.equals(Locations.INTRO)) {
        Game.clearScreen();
        Game.introduction();
        Hero.generate();
        Hero.displayStats();
        nextLocation = Locations.TOWN_START;
      } else if (nextLocation.equals(Locations.TOWN_START)) {
        nextLocation = Town.doStart();
      } else if (nextLocation.equals(Locations.TOWN_SHOP)) {
        nextLocation = Town.doShop();
      } else if (nextLocation.equals(Locations.TOWN_TEMPLE)) {
        nextLocation = Town.doTemple();
      } else if (nextLocation.equals(Locations.TOWN_HOUSE)) {
        nextLocation = Town.doHouse();
      } else if (nextLocation.equals(Locations.MONSTER_DUNGEON_START)) {
        nextLocation = Town.doMonsterStart();
      } else if (nextLocation.equals(Locations.BOSS_DUNGEON_START)) {
        nextLocation = Town.doBossStart();
      } else if (nextLocation.equals(Locations.AFTERLIFE)) {
        nextLocation = Game.doAfterlife();
      } else if (nextLocation.equals(Locations.WINGAME)) {
        nextLocation = Game.doWinGame();
      } else {
        System.out.println("Invalid Location. Something went wrong!");
        Input.pressEnterToContinue();
        nextLocation = Locations.QUITGAME;
      }

    } while (!nextLocation.equals(Locations.QUITGAME));

    // game loop will go here

    Art.quitGameTitle();
    System.out.print(ConsoleColors.RESET);
  }

  public static void introduction() {
    // Show the intro picture and title
    Art.gameArt();
    Art.gameTitle();
  }

  // These methods are helpful for the game

  // Changes the foreground color to the RGB color given
  public static String rgb(int red, int green, int blue) {
    return String.format("\033[38;2;%d;%d;%dm", red, green, blue);
  }

  // Changes the background color to the RGB color given
  public static String rgb_bg(int red, int green, int blue) {
    return String.format("\033[48;2;%d;%d;%dm", red, green, blue);
  }

  public static String colorize(String text, String color) {
    return color + text + ConsoleColors.RESET;
  }

  public static String blue(String text) {
    return colorize(text, ConsoleColors.BLUE);
  }

  public static String red(String text) {
    return colorize(text, ConsoleColors.RED);
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static String doAfterlife() {
    System.out.println("You died.");
    Input.pressEnterToContinue();
    return Locations.QUITGAME;
  }

  public static String doWinGame() {
    System.out.println("Congrats! You won the game!");
    Input.pressEnterToContinue();
    return Locations.QUITGAME;
  }

  public static void sleep(int seconds) {

    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - seconds * 1000)
      ;

  }

  public static String keyword(String text) {
    return colorize(text, ConsoleColors.BLUE);
  }
}