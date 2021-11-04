package save;

import player.Player;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Save {
    private List<Player> save;
    private Scanner in = new Scanner(System.in);


    public Save() {
        save = new ArrayList<>();
        loadGames();
    }

    public void savePlayer(Player player) {
        System.out.println("1. Новое сохранение");
        System.out.println("2. Перезаписать. ");
        System.out.println("3. Выйти. ");

        int choice = in.nextInt();
        switch (choice) {
            case 1:
                save.add( player);
                break;
            case 2:
                setSavePlayer(player);
                break;
            case 3:

                break;
        }

        saveGames();
    }

    public Player loadPlayer() {
        printListSavePlayer();
        System.out.println("Кого загрузить? ");
        int choice = in.nextInt();
        return save.get(choice - 1);
    }

    private void loadGames() {
        try (ObjectInputStream load = new ObjectInputStream(new FileInputStream("myGame.dm"))) {
            save = (List<Player>) load.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveGames() {
        try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("myGame.dm"))) {
            save.writeObject(this.save);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setSavePlayer(Player player) {
        printListSavePlayer();
        System.out.println("Куда сохранить?");
        int choice = in.nextInt();

        save.set(choice - 1, player);
    }

    void printListSavePlayer() {
        int i = 1;
        for (Player player : save) {
            System.out.printf("%d. %-15s Уровень: %d опыта %d\n", i++, player.getName(), player.getLevel(), player.getExperience());
        }
    }
}
