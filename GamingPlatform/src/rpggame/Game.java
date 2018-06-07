/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

/**
 *
 * @author sajain
 */
abstract class Game {
    int id;
    String name;
    String description;

    // Constructor
    public Game(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //play game
    abstract void play(String userid);

    //take action
    abstract void action(Actions action);

    //first save the game than exit
    abstract void saveAndexit();

    //exit the game
    abstract void exit();
}
