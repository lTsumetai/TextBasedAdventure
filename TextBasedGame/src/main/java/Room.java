import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Room {

    private final String description;
    private final Monster monster;
    private final Boolean isBossRoom;
    private final static Random random = new Random();
    private final static Set<Integer> roomsSeen = new HashSet<Integer>();
    private final static int NUM_ROOMS = 5;

    private Room(String description, Monster monster, Boolean isBossRoom) {
        this.description = description;
        this.monster = monster;
        this.isBossRoom = isBossRoom;
    }

    public static Room newRegularInstance() {
        if (roomsSeen.size() == NUM_ROOMS) {
            roomsSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_ROOMS);
        } while (roomsSeen.contains(i));
        roomsSeen.add(i);

        String roomDescription = null;
        if (i == 0) {
            roomDescription = "Ruangan Gelap dengan obor";
        } else if (i == 1) {
            roomDescription = "Ruangan Tergenang Air";
        } else if (i == 2) {
            roomDescription = "Ruangan Penjara";
        } else if (i == 3) {
            roomDescription = "Ruangan Dapur";
        } else {
        }
        return new Room(roomDescription, Monster.newRandomInstance(), false);
    }

    public static Room newBossInstance() {
        return new Room("Ruangan singgasana Raja", Monster.newBossInstance(),
                true);
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public boolean isComplete() {
        return !monster.isAlive();
    }

    @Override
    public String toString() {
        return description;
    }

    public void enter(Player player) throws IOException {
        System.out.println("Kamu Berada Di " + description);
        if (monster.isAlive()) {
            new Battle(player, monster);
        }
    }

}