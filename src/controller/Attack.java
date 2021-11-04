package controller;

import common.PartBody;
import common.ResultBattles;
import creature.Creature;
import player.Player;


import java.util.Random;
import java.util.Scanner;

public class Attack {
    private Scanner in = new Scanner(System.in);
    private Player player;
    private Creature creature;
    private Random rnd = new Random();
    private ResultBattles resultBattles;

    public Attack(Player player, Creature creature) {
        this.player = player;
        this.creature = creature;
    }

    public ResultBattles doAttack() {
        System.out.println("1. Атаковать ");
        System.out.println("2. Позорно бежать ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                resultBattles = event();
                break;
            case 2:
                return ResultBattles.RETREATED;
        }
        if (resultBattles != null) {
            return resultBattles;
        }
        return null;
    }

    public ResultBattles event() {
        System.out.println("Удар:");
        player.setDoAttack(partBody());

        System.out.println("Защитить:");
        player.setDoProtection(partBody());

        creature.setDoAttack(rndPartBody());
        creature.setDoProtection(rndPartBody());

        if (player.getDoAttack() != creature.getDoProtection()) {
            int rnbAttack = rnd.nextInt(20) + 1;

            if (rnbAttack == 20) {
                System.out.println("Вы нанесли крит " + (player.getDamage() * 2) + " урона");
                creature.takingDamage(player.getDamage() * 2);
            } else if (rnbAttack + player.getAttack() > creature.getProtection()) {
                System.out.println("Вы нанесли " + player.getDamage() + " урона");
                creature.takingDamage(player.getDamage());
            } else {
                System.out.println("мазила");
            }

        } else {
            System.out.println("Ваш удар заблокирован");
        }

        if (creature.getDoAttack() != player.getDoProtection()) {
            int rnbAttack = rnd.nextInt(20) + 1;


            if (rnbAttack == 20) {
                System.out.println("Вы получили крит " + (creature.getDamage() * 2) + " урона");
                player.takingDamage(creature.getDamage() * 2);
            } else if (rnbAttack + creature.getAttack() > player.getProtection()) {
                System.out.println("Вы получили " + creature.getDamage() + " урона");
                player.takingDamage(creature.getDamage());
            } else {
                System.out.println("Тварь промахнулась");
            }
        } else {
            System.out.println("Вы заблокировали удар");
        }

        System.out.println("у вас " + player.getHealth() + " жизней");
        System.out.println("у твари " + creature.getHealth() + " жизней");

        if (!creature.isLive()) {
            System.out.println("Тварь убита ");
            System.out.printf("Вы получили %d опыты\n", creature.getLevel() * 10);
            player.setExperience(creature.getLevel() * 10);
            return ResultBattles.VICTORY;
        }

        if (player.getHealth() <= 0) {
            return ResultBattles.DEFEAT;
        }

        return null;
    }

    public PartBody partBody() {
        System.out.println("1. Голова");
        System.out.println("2. Тело");
        System.out.println("3. Конечности");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                return PartBody.HEAD;
            case 2:
                return PartBody.BODY;
            case 3:
                return PartBody.LEGS;
        }
        return PartBody.BODY;
    }

    private PartBody rndPartBody() {
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
}

