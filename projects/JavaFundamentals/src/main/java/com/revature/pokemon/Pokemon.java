package com.revature.pokemon;

import java.util.Random;

public class Pokemon {
    /*
    we need to think about what kind of information we want to store about the pokemon

    we may want a name, level, health, attack
     */

    String name;
    int level;
    int health;
    int attack;
    boolean fainted;

    // now that we have a pokemon, we may want to find a way to construct the pokemon object

    public Pokemon(String name){
        this.name = name;
        //how tdo we randomize values?
        Random rand = new Random();
        // now we have a random object, let's use it

        this.level  = rand.nextInt(100) + 1;
        this.health = rand.nextInt(100) + 1;
        this.attack = rand.nextInt(100) + 1;
        this.fainted = false;

    }

    public void displayStats(){
        System.out.println("------" + this.name + "------");
        System.out.println("Level: " + this.level);
        System.out.println("Health: " + this.health);
        System.out.println("Attack: " + this.attack);
        if (this.fainted) {
            System.out.println(this.name + " is fainted!");
        }
    }

    public Pokemon battle(Pokemon opponent){
        // how do we battle
        // when my pokemon attacks another pokemon, my attack should reduce their health
        // and their attack should reduce my mine

        //this is for when we attack them
        if (opponent.health - this.attack <= 0){
            opponent.health = 0;
            opponent.fainted = true;
        } else {
            opponent.health -= this.attack;
        }


        if (this.health - opponent.attack <= 0){
            this.health = 0;
            this.fainted = true;
        } else {
            this.health -= opponent.attack;
        }

        return opponent;

    }
}
