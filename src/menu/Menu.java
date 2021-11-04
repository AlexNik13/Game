package menu;

import common.PartBody;
import common.ResultBattles;
import controller.Attack;
import creature.Creature;
import creature.CreatureSkeleton;
import player.Player;
import player.RasaPlayer;
import player.TypePlayer;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private static Scanner in = new Scanner(System.in);
    private static int choice;

    private Attack attack;

    private List<Creature> creatures = new ArrayList<>();
    private Creature creature ;

    private ResultBattles resultBattles;


    Player player;

    public void startGame(){
        System.out.print("Введите имя игрока:" );
        String name = in.next();
        player = new Player(name, RasaPlayer.HUMAN,TypePlayer.FIGHTER);
        mainMenu();
    }


    public void mainMenu() {
        while (true){
            System.out.println("Главное меню!");
            System.out.println("1.\tПосмотреть свои параметры.");
            System.out.println("2.\tВойти в подземелье. ");
            System.out.println("0.\tВыход. ");
            choice = in.nextInt();
            switch (choice){
                case 0:

                    break;
                case 1:
                    player.printCharacteristic();
                    break;
                case 2:
                    dungeon();
                    break;
            }
        }
    }

    public void dungeon(){
        System.out.println( "Вы в мрачном подземелье. \n" +
                "Впереди вы ведёте своего врага.\n" +
                "Ваши действия?\n");

        System.out.println("1. С криком ПОСТОРОНИСЬ напасть.");
        System.out.println("2. Вернуться в деревню. ");

        int  choice = in.nextInt();
        switch (choice){
            case 1:
                creature = new CreatureSkeleton(player.getLevel());
                attack = new Attack(player, creature);
                do {
                    resultBattles = attack.doAttack();
                } while (resultBattles == null);
                System.out.println(getBattleResult(resultBattles));
            case 2:
                System.out.println("EXIT");
                break;
        }

    }

    private String getBattleResult(ResultBattles resultBattles) {
        if(resultBattles == ResultBattles.VICTORY){
            return   "Поздравляю герой ты победил!";
        }

        if(resultBattles == ResultBattles.VICTORY){
            return "Не Повезло тебе герой. Ты проиграл.";
        }

        return "Отступить не позорно. Восстанови силы выпей эль и попробуй снова.";
    }

    //TODO do make
    public boolean changeCharacteristic(){
        boolean menu = true;
        while (menu){
            player.printCharacteristic();
            System.out.println("");
        }

        return false;
    }


   /* public boolean doAttack(){
        System.out.println("1. Атаковать ");
        System.out.println("2. Позорно бежать ");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                event();
                break;
        }
        return true;
    }

    public void event(){
        System.out.println("Удар:");
        player.setDoAttack(partBody());

        System.out.println("Защитить:");
        player.setDoProtection(partBody());

        creature.setDoAttack(rndPartBody());
        creature.setDoProtection(rndPartBody());

        if(player.getDoAttack() != creature.getDoProtection()){
            int rnbAttack = rnd.nextInt(20) + 1;
            if(rnbAttack + player.getAttack() > creature.getProtection()){
                System.out.println("Вы нанесли " + player.getDamage() + " урона");
                creature.takingDamage(player.getDamage());
            }else {
                System.out.println("мазила");
            }

        }else {
            System.out.println("Ваш удар заблокирован");
        }

        if(creature.getDoAttack() != player.getDoProtection()){
            int rnbAttack = rnd.nextInt(20) + 1;
            if(rnbAttack + creature.getAttack() > player.getProtection()){
                System.out.println("Вы получили " + creature.getDamage() + " урона");
                player.takingDamage(creature.getDamage());
            }else {
                System.out.println("Тварь промахнулась");
            }
        }else {
            System.out.println("Вы заблокировали удар");
        }

        System.out.println("у вас " + player.getHealth() + " жизней");
        System.out.println("у твари " + creature.getHealth() + " жизней");
        if(!creature.isLive()){
            System.out.println("Тварь убита ");
        }
    }


    public PartBody partBody(){
        System.out.println("1. Голова");
        System.out.println("2. Тело");
        System.out.println("3. Конечности");
        int choice = in.nextInt();

        switch (choice){
            case 1: return PartBody.HEAD;
            case 2: return PartBody.BODY;
            case 3: return PartBody.LEGS;
        }
        return PartBody.BODY;
    }

    private PartBody rndPartBody() {
        switch (rnd.nextInt(3)){
            case 0: return PartBody.HEAD;
            case 1: return PartBody.BODY;
            case 2: return PartBody.LEGS;
        }
        return PartBody.BODY;
    }*/



}
