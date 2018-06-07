/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.dao;

import java.util.List;
import rpggame.model.Enemy;
import rpggame.model.GameStatus;
import rpggame.model.Player;
import rpggame.model.User;

/**
 *
 * @author sajain
 */
public interface GameDao {
    
    public int userLogin(String userName, String password);
    
    public int userRegistration(String userName, String password);
    
    public int getBasehpbyplayerid(String userId, int playerId);
    
    public boolean isResume(String userId);
    
    public List<GameStatus> getSavedgamesbyuserid(String userId);
    
    public List<Player> listOfplayers();
    
    public Player getPlayerdetail(int playerId);
    
    public Enemy getEnemydetail(int enemyId);
    
    public void exit(String userId, Player p, Enemy e, int damageCount, float currentRating, int doSave,int resumedEnemyId);
    
    public User getUserstatistics(String userId);
    
    public GameStatus resumeGame(String userId, int isSaveStatus);
    
    public void insertUserrating(String userId, int experienceCount, float starRating, int existance);
    
}
