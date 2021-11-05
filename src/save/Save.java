package save;

import player.Player;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Save {

    private List<Player> loadPlayer;
    private Set<Player> saveGame;
    private Scanner in = new Scanner(System.in);

    public Save() {
        saveGame = new HashSet<>();
        loadGames();
    }

    public Player loadPlayer() {
        if(loadPlayer.size()> 0){
            printListSavePlayer();

            System.out.println("Кого загрузить? ");
            int choice = in.nextInt();
            return loadPlayer.get(choice - 1);
        }else {
            System.out.println("Нет сохранений");
        }
        return null;
    }

    private void loadGames() {
        try (ObjectInputStream load = new ObjectInputStream(new FileInputStream("myGame.dm"))) {
            saveGame = (Set<Player>) load.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        loadPlayer = new ArrayList<>(saveGame);
    }

    public void saveGames() {
        try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("myGame.dm"))) {
            save.writeObject(this.saveGame);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void savePlayer(Player player) {
        saveGame.add(player);
        loadPlayer = new ArrayList<>(saveGame);
        saveGames();
    }

    private void printListSavePlayer() {
        int i = 1;
        for (Player player : loadPlayer) {
            System.out.printf("%d. %-15s Уровень: %d опыта %d\n", i++, player.getName(), player.getLevel(), player.getExperience());
        }
    }
}
