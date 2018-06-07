/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.model;

/**
 *
 * @author sajain
 */
public class Player extends Character {
    private int id;
    private String name;
    private int basehp;
    private int currentHp;
    private int attackDamage;
    private int numHealthPotions;
    //Health h;

    public Player(int id, String name, int basehp, int currentHp, int attackDamage, int numHealthPotions) {
        this.id = id;
        this.name = name;
        this.basehp = basehp;
        this.currentHp = currentHp;
        this.attackDamage = attackDamage;
        this.numHealthPotions = numHealthPotions;

    }

    public int getAttackdamage() {
        return attackDamage;
    }

    public void setAttackdamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasehp() {
        return basehp;
    }

    public void setBasehp(int basehp) {
        this.basehp = basehp;
    }

    public int getCurrenthp() {
        return currentHp;
    }

    public void setCurrenthp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getNumhealthpotions() {
        return numHealthPotions;
    }

    public void setNumhealthpotions(int numHealthPotions) {
        this.numHealthPotions = numHealthPotions;
    }
    // String[] players = {"Dr. Smolder Bravestone", "Ruby Roundhouse", "Moose Finbar", "Professor Shelly Oberon"};
}
