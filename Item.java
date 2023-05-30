public class Item {

  public static final int SWORD = 1;
  public static final int LOST_WALLET = 2;
  public static final int DAGGER = 3;
  public static final int ARMOR = 4;
  public static final int SHORT_SWORD = 5;
  public static final int HEALING_POTION = 6;
  public static final int SHIELD = 7;
  // create more item types by adding more ids, they must all have unique values

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