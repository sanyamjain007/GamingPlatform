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

public class GameStatus {
    private String userId;
    private int playerId;
    private int enemyId;
    private int playerCurrentHp;
    private int enemyCurrentHp;
    private int healthPotionCount;
    private int playerMaxHp;
    private int isSave;
    private int gameSessionId;
    private int damageCount;
    private float currentRating;

    public GameStatus(String userId, int playerId, int playerCurrentHp, int enemyId, int enemyCurrentHp, int healthPotionCount, int playerMaxHp, int isSave, int gameSessionId, int damageCount, float currentRating) {
        this.userId = userId;
        this.playerId = playerId;
        this.playerCurrentHp = playerCurrentHp;
        this.enemyId = enemyId;
        this.enemyCurrentHp = enemyCurrentHp;
        this.healthPotionCount = healthPotionCount;
        this.playerMaxHp = playerMaxHp;
        this.isSave = isSave;
        this.gameSessionId = gameSessionId;
        this.damageCount = damageCount;
        this.currentRating = currentRating;

    }

    public int getDamagecount() {
        return damageCount;
    }

    public void setDamagecount(int damageCount) {
        this.damageCount = damageCount;
    }

    public float getCurrentrating() {
        return currentRating;
    }

    public void setCurrentrating(float currentRating) {
        this.currentRating = currentRating;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userId) {
        this.userId = userId;
    }

    public int getIssave() {
        return isSave;
    }

    public void setIssave(int isSave) {
        this.isSave = isSave;
    }

    public int getPlayerid() {
        return playerId;
    }

    public void setPlayerid(int playerId) {
        this.playerId = playerId;
    }

    public int getEnemyid() {
        return enemyId;
    }

    public void setEnemyid(int enemyId) {
        this.enemyId = enemyId;
    }

    public int getPlayercurrenthp() {
        return playerCurrentHp;
    }

    public void setPlayercurrenthp(int playerCurrentHp) {
        this.playerCurrentHp = playerCurrentHp;
    }

    public int getEnemycurrenthp() {
        return enemyCurrentHp;
    }

    public void setEnemycurrenthp(int enemyCurrentHp) {
        this.enemyCurrentHp = enemyCurrentHp;
    }

    public int getHealthpotioncount() {
        return healthPotionCount;
    }

    public void setHealthpotioncount(int healthPotionCount) {
        this.healthPotionCount = healthPotionCount;
    }

    public int getPlayermaxhp() {
        return playerMaxHp;
    }

    public void setPlayermaxhp(int playerMaxHp) {
        this.playerMaxHp = playerMaxHp;
    }

    public int getGamesessionid() {
        return gameSessionId;
    }

    public void setGamesessionid(int gameSessionId) {
        this.gameSessionId = gameSessionId;
    }
}
