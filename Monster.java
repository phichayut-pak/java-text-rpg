import java.util.*;

public class Monster {

    static Random random = new Random();

    public String name;
    public int health;
    public int speed;
    public int attackDamage;
    public int rewardGold;
    public int rewardXP;

    public ArrayList<Item> rewardItems = new ArrayList<Item>();

    public Monster(String monsterName) {
        name = monsterName;
    }

    public void attack() {
        int attack = Monster.random.nextInt(this.attackDamage) + 1;

        Hero.takeDamage(attack);

        Game.sleep(1);
    }

    public boolean checkDefeat() {
        if (this.health > 0) {
            return false;
        } else {
            System.out.println(ConsoleColors.GREEN_BRIGHT);
            System.out.format("%s has been defeated!\n", name);
            System.out.println(ConsoleColors.RESET);
            return true;
        }
    }
}