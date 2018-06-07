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
abstract class Character {
    private int id;
    private String name;
    private int baseHp;
    private int currentHp;

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
        return baseHp;
    }

    public void setBasehp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getCurrenthp() {
        return currentHp;
    }

    public void setCurrenthp(int currentHp) {
        this.currentHp = currentHp;
    }
}