import java.io.IOException;

public class Game {

    private final Player player = Player.newInstance();

    public void play() throws IOException {
        System.out.println("You are " + player + " " + player.getDescription());
        Dungeon.newInstance().startQuest(player);
    }
    

    public static void main(String[] args) throws IOException {
        
        Game game = new Game();
        game.play();
    }

}