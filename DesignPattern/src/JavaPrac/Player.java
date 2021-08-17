package JavaPrac;

public class Player {
    PlayerLevel playerLevel;
    int level = 1;
    public void getLevel(){
        playerLevel.showLevelMessage();
    }
    public void upgradeLevel(PlayerLevel upgradedLevel){
        playerLevel = upgradedLevel;
        level++;
    }
    public void play(){
        playerLevel.go(level);
    }

    public static void main(String[] args) {
        Player player = new Player();
        player.playerLevel = new BeginnerLevel();
        player.getLevel();
        player.play();
        player.upgradeLevel(new AdvancedLevel());
        player.getLevel();
        player.play();
        player.upgradeLevel(new SuperLevel());
        player.getLevel();
        player.play();
    }
}
