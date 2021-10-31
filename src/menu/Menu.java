package menu;

import player.Player;
import player.RasaPlayer;
import player.TypePlayer;

import java.util.Scanner;

public class Menu {
    private static Scanner in = new Scanner(System.in);

    public static Player startGame(){
        System.out.print("Введите имя игрока:" );
        String name = in.next();
        return new Player(name, RasaPlayer.HUMAN,TypePlayer.FIGHTER);
    }

    public static void mainMenu() {

    }

}
