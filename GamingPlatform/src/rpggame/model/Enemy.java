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
public class Enemy extends Character {
    private int id;
    private String name;
    private int baseHp;
    private int currentHp;

    public Enemy(int id, String name, int baseHp, int currentHp) {
        this.id = id;
        this.name = name;
        this.baseHp = baseHp;
        this.currentHp = currentHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
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

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }
}
