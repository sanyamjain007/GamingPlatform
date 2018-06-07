/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.controller;

import rpggame.model.GameStatus;
import rpggame.model.User;
import rpggame.model.Player;
import rpggame.model.Enemy;
import rpggame.dao.GameDaoImplementation;
import java.util.List;
import rpggame.dao.GameDao;

/**
 *
 * @author sajain
 */
public class GameController {
    
    private GameDao dao = new GameDaoImplementation();

    public int userLogin(String username, String password) {
        return dao.userLogin(username, password);
    }

    public int userRegistration(String username, String password) {
        return dao.userRegistration(username, password);
    }

    public boolean isResume(String userid) {
        return dao.isResume(userid);
    }

    public List<GameStatus> getSavedgamesbyuserid(String userid) {
        return dao.getSavedgamesbyuserid(userid);
    }

    public List<Player> getListofplayers() {
        return dao.listOfplayers();
    }

    public int getBasehpbyplayerid(String userid, int playerid) {

        return dao.getBasehpbyplayerid(userid, playerid);
    }

    public Player getPlayerdetail(int playerid) {
        return dao.getPlayerdetail(playerid);
    }

    public Enemy getEnemydetail(int enemyid) {
        return dao.getEnemydetail(enemyid);
    }

    public void saveAndexit(String userid, Player p, Enemy e,int damagecount,float starating, int dosave) {
        dao.exit(userid, p, e,damagecount,starating,dosave,1);
    }

    public void exit(String userid, Player p, Enemy e,int damagecount,float starating, int dosave, int resumedEnemyId) {
        dao.exit(userid, p, e,damagecount,starating,dosave,resumedEnemyId);
    }

    public GameStatus resumeGame(String userid, int issavestatus) {
        return dao.resumeGame(userid, issavestatus);
    }

    public void insertUserrating(String userid, int experiencecount, float starrating, int existance) {
        dao.insertUserrating(userid, experiencecount, starrating, existance);
    }

    public User getUserstatistics(String userid) {
        return dao.getUserstatistics(userid);
    }
}
