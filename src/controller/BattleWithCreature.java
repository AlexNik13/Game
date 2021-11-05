package controller;

import common.PartBody;
import common.ResultBattles;
import creature.Creature;
import player.Player;

import java.util.Random;
import java.util.Scanner;

public class BattleWithCreature {
    private Scanner in = new Scanner(System.in);
    private Player player;
    private Creature creature;
    private Random rnd = new Random();
    private ResultBattles resultBattles;

    public BattleWithCreature(Player player, Creature creature) {
        this.player = player;
        this.creature = creature;
    }

    public ResultBattles doAttack() {
        System.out.println("1. Атаковать ");
        System.out.println("2. Позорно бежать ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                resultBattles = attack();
                break;
            case 2:
                clearConsole();
                return ResultBattles.RETREATED;
        }
        if (resultBattles != null) {
            return resultBattles;
        }
        return null;
    }

    private void menuSelectionKickProtection(){
        System.out.println("Удар:");
        player.setDoAttack(selectionPartBodyPlayer());

        System.out.println("Защитить:");
        player.setDoProtection(selectionPartBodyPlayer());

        creature.setDoAttack(rndSelectionPartBodyCreature());
        creature.setDoProtection(rndSelectionPartBodyCreature());
    }

    private ResultBattles attack() {
        menuSelectionKickProtection();
        playerAttack();
        creatureAttack();
        printHealth();
        return resultBattle();
    }

    private void playerAttack() {
        if (player.getDoAttack() != creature.getDoProtection()) {
            int rnbAttack = rnd.nextInt(20) + 1;
            if (rnbAttack + player.getAttack() > creature.getProtection()) {
                int powerAttack = powerAttack(rnbAttack);
                if (rnbAttack == 20) {
                    System.out.println("Критический удар");
                }
                System.out.println("Вы нанесли " + (player.getDamage() * powerAttack) + " урона");
                creature.takingDamage(player.getDamage());
            } else {
                System.out.println("мазила");
            }
        } else {
            System.out.println("Ваш удар заблокирован");
        }
    }

    private void creatureAttack() {
        if (creature.getDoAttack() != player.getDoProtection()) {
            int rnbAttack = rnd.nextInt(20) + 1;
            if (rnbAttack + creature.getAttack() > player.getProtection()) {
                int powerAttack = powerAttack(rnbAttack);
                if (rnbAttack == 20) {
                    System.out.println("Критический удар");
                }
                System.out.println("Вы получили " + (creature.getDamage() * powerAttack) + " урона");
                player.takingDamage(creature.getDamage());
            } else {
                System.out.println("Тварь промахнулась");
            }
        } else {
            System.out.println("Вы заблокировали удар");
        }
    }

    private int powerAttack(int rnbAttack) {
        if (rnbAttack == 20) {
            return 2;
        }
        return 1;
    }

    private void printHealth() {
        System.out.println("у вас " + player.getHealth() + " жизней");
        System.out.println("у твари " + creature.getHealth() + " жизней");
    }

    private ResultBattles resultBattle() {
        if (player.getHealth() <= 0) {
            return ResultBattles.DEFEAT;
        }
        if (!creature.isLive()) {
            System.out.println("Тварь убита ");
            System.out.printf("Вы получили %d опыты\n", creature.getLevel() * 10);
            player.addExperience(creature.getLevel() * 10);
            return ResultBattles.VICTORY;
        }
        return null;
    }

    private PartBody selectionPartBodyPlayer() {
        System.out.println("1. Голова");
        System.out.println("2. Тело");
        System.out.println("3. Конечности");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                clearConsole();
                return PartBody.HEAD;
            case 2:
                clearConsole();
                return PartBody.BODY;
            case 3:
                clearConsole();
                return PartBody.LEGS;
        }
        return PartBody.BODY;
    }

    private PartBody rndSelectionPartBodyCreature() {
        switch (rnd.nextInt(3)) {
            case 0:
                return PartBody.HEAD;
            case 1:
                return PartBody.BODY;
            case 2:
                return PartBody.LEGS;
        }
        return PartBody.BODY;
    }

    private void clearConsole(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}