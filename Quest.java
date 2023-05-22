import java.util.ArrayList;

public class Quest {
    public static final int FIND_THE_WALLET = 1;

    public static final int MONSTER_DUNGEON_LEVEL_ONE = 2;
    public static final int MONSTER_DUNGEON_LEVEL_TWO = 3;
    public static final int MONSTER_DUNGEON_LEVEL_THREE = 4;

    public static final int BOSS_DUNGEON_LEVEL_ONE = 5;
    public static final int BOSS_DUNGEON_LEVEL_TWO = 6;
    public static final int BOSS_DUNGEON_LEVEL_THREE = 7;

    public int id;
    public String name;
    public String description;
    public int rewardGold;
    boolean isCompleted;

    public ArrayList<Item> rewardItems = new ArrayList<Item>();

    public Quest(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("%s", name);
    }
}