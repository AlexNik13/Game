package menu;

import common.ResultBattles;
import controller.BattleWithCreature;
import creature.Creature;
import creature.CreatureSkeleton;
import player.Player;
import player.RasaPlayer;
import player.TypePlayer;
import save.Save;

import java.util.Scanner;

//TODO отделить меню от логики

public class Menu {
    private Scanner in = new Scanner(System.in);
    private BattleWithCreature battleWithCreature;
    private Creature creature;
    private ResultBattles resultBattles;
    private Save save = new Save();
    private Player player;

    public void mainMenu() {
        System.out.println("1. Загрузить игру");
        System.out.println("2. Создать нового героя");
        System.out.println("3. Выйти");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                if ((player = save.loadPlayer()) == null) {
                    mainMenu();
                }
                menuVillage();
                break;
            case 2:
                clearConsole();
                menuCreatePlayer();
                break;
            case 3:
                clearConsole();
                save.saveGames();
                System.exit(0);
                break;
        }
    }
    
    private void clearConsole(){
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private void menuCreatePlayer() {
        System.out.print("Введите имя игрока:");
        String name = in.next();
        player = new Player(name, RasaPlayer.HUMAN, TypePlayer.FIGHTER);
        menuVillage();
    }

    private void menuVillage() {
        boolean menu = true;
        while (true) {
            System.out.println("Главное меню!");
            System.out.println("1.\tПосмотреть\\поменять свои параметры.");
            System.out.println("2.\tВойти в подземелье. ");
            System.out.println("0.\tСохраниться и выйти в главное меню. ");
            int choice = in.nextInt();
            switch (choice) {
                case 0:
                    clearConsole();
                    save.savePlayer(player);
                    menu = false;
                    mainMenu();
                    break;
                case 1:
                    clearConsole();
                    printCharacteristic();
                    break;
                case 2:
                    clearConsole();
                    dungeon();
                    break;
            }
        }
    }

    private void menuChangeCharacteristic() {
        System.out.println("1. Повысить силу");
        System.out.println("2. Повысить ловкость");
        System.out.println("3. Повысить телосложение ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                player.addStrength();
                break;
            case 2:
                clearConsole();
                player.addAgility();
                break;
            case 3:
                clearConsole();
                player.addConstitution();
                break;
        }
        printCharacteristic();
    }

    private void printCharacteristic() {
        player.printCharacteristic();
        System.out.println("");
        if (player.getFreeStatPoints() > 0) {
            menuChangeCharacteristic();
        }
    }

    private void dungeon() {

        creature = new CreatureSkeleton(player.getLevel());

        System.out.println("Вы в мрачном подземелье. \n" +
                "Впереди вы ведёте своего врага. " + creature.getName() + " " + creature.getLevel() + " уровня\n"+
                "Ваши действия?\n");



        System.out.println("1. С криком ПОСТОРОНИСЬ напасть.");
        System.out.println("2. Вернуться в деревню. ");

        int choice = in.nextInt();
        switch (choice) {
            case 1:
                clearConsole();

                battleWithCreature = new BattleWithCreature(player, creature);
                do {
                    resultBattles = battleWithCreature.doAttack();
                } while (resultBattles == null);
                player.recalculateCharacteristic();
                System.out.println(getBattleResult(resultBattles));
                break;
            case 2:
                clearConsole();
                menuVillage();
                break;
        }
    }

    private String getBattleResult(ResultBattles resultBattles) {
        if (resultBattles == ResultBattles.VICTORY) {
            return "Поздравляю герой ты победил!";
        }
        if (resultBattles == ResultBattles.DEFEAT) {
            return "Не Повезло тебе герой. Ты проиграл.";
        }
        return "Отступить не позорно. Восстанови силы выпей эль и попробуй снова.";
    }
}
