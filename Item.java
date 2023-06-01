public class Item {

  public static final int SWORD = 1;
  public static final int LOST_WALLET = 2;
  public static final int MONSTER_DUNGEON_TWO_KEY = 3;
  public static final int MONSTER_DUNGEON_THREE_KEY = 3;
  public static final int BOSS_DUNGEON_ONE_KEY = 4;
  public static final int BOSS_DUNGEON_TWO_KEY = 5;
  public static final int BOSS_DUNGEON_THREE_KEY = 6;

  // SMALL +5, MEDIUM +10, LARGE +15
  public static final int SMALL_HEALTH_EMBLEM = 7;
  public static final int MEDIUM_HEALTH_EMBLEM = 8;
  public static final int LARGE_HEALTH_EMBLEM = 9;

  public static final int SMALL_ATTACK_EMBLEM = 10;
  public static final int MEDIUM_ATTACK_EMBLEM = 11;
  public static final int LARGE_ATTACK_EMBLEM = 12;

  public static final int SMALL_MAGIC_EMBLEM = 13;
  public static final int MEDIUM_MAGIC_EMBLEM = 14;
  public static final int LARGE_MAGIC_EMBLEM = 15;

  public static final int SMALL_SPEED_EMBLEM = 16;
  public static final int MEDIUM_SPEED_EMBLEM = 17;
  public static final int LARGE_SPEED_EMBLEM = 18;

  String name;
  String description;

  int id;

  int damage;
  int price;

  public Item(int id) {
    this.id = id;
  }

  public String toString() {
    return String.format("%s", name);
  }
}