package com.revature.pokemon;

import java.util.Random;
import java.util.Scanner;

public class PokemonGame {
    /*
    we want to create some sort of console application which allows up to traverse around and catch/battle pokemon

    for those uninitiated in the game of pokemon, you can only have at most six pokemon with you at a time.

    we should be able to maybe catch a pokemon, view our pokemon, and maybe view our party
     */

    public static void main(String[] args) {

        boolean running = true;
        Scanner input = new Scanner(System.in);

        //let's create out party of pokemon

        Pokemon[] party = new Pokemon[6];
        Pokemon p1 = new Pokemon("Sandshrew");
        party[0] = p1;

        int partySize = 1;

        String[] possibleEncounters = {
                "Shinx",
                "RIP Jon",
                "Missingno",
                "Sableye",
                "Lugia",
                "Luigi",
                "Jinx",
        };

        Random randy = new Random();

        while (running) {

            Pokemon p2 = new Pokemon(possibleEncounters[randy.nextInt(possibleEncounters.length)]);

            // let's start creating the logic for a menu

            System.out.println("You've encountered a wild " + p2.name + "!");

            // now we need to give options to the player

            System.out.println("Type 'run', 'battle', or 'party' or 'q to quit.");

            // now we need to collect this input from the user
            // and store it in a variable

            String choice = input.nextLine();
            //let's do some logic based on the input

            if (choice.equals("run")) {
                System.out.println("You ran from the battle");
            } else if (choice.equals("battle")){
                //if we choose battle we have a sub option to attack or catch
                System.out.println("Type 'attack' or 'catch'");
                String subChoice = input.nextLine();
                if (subChoice.equals("attack")){
                    p1.battle(p2);
                    p1.displayStats();
                    p2.displayStats();
                } else if (subChoice.equals("catch")){
                    // this is where we add the pokemon to the party
                    // let's check to see if we have six pokemon
                    if (partySize < 6) {
                        party[partySize + 1] = p2;
                        partySize++;
                        System.out.println("-----PARTY-----");
                        for (int i = 0; i < party.length; i++) {
                            if (party[i] != null){
                                System.out.println(i + ": " + party[i + 1].name);
                            }
                        }

                    } else {
                        System.out.println("Party full!");
                        break;
                    }
                }

            } else if (choice.equals("party")){
                System.out.println("-----PARTY-----");
                for (int i = 0; i < party.length; i++) {
                    if (party[i] != null){
                        System.out.println(i + ": " + party[i + 1].name);
                    }
                }
            } else if (choice.equals("q")) {
                break;
            } else {
                System.out.println("invalid input");
            }

            break;
        }
    }
}
