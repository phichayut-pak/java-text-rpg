class Test {
  public static void main(String[] args) {
    // All the code goes in Game.java, just start the game here
    Item sword = new Item(Item.SWORD);
    sword.name = "Long sword";
    sword.description = "The beginner sword";
    sword.damage = 10;
    sword.price = 100;

    Quest walletQuest = new Quest(Quest.FIND_THE_WALLET);
    walletQuest.name = "Find the Lost Wallet";
    walletQuest.description = "You must go to the house near the town and return Dungeon Master the lost wallet";
    walletQuest.rewardGold = 10;
    walletQuest.rewardItems.add(sword);
    Hero.addQuest(walletQuest);
    Hero.completeQuest(Quest.FIND_THE_WALLET);

    System.out.println(Hero.hasQuest(Quest.FIND_THE_WALLET));
    System.out.println(Hero.hasCompletedQuest(Quest.FIND_THE_WALLET));

  }
}