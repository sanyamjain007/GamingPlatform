/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rpggame.model.GameStatus;
import rpggame.model.User;
import rpggame.database.Database;
import rpggame.model.Enemy;
import rpggame.model.Player;

/**
 *
 * @author sajain
 */
public class GameDaoImplementation implements GameDao {

    @Override
    public int userLogin(String userName, String password) {

        int success = 0;
        try {
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            PreparedStatement prSt = null;
            String sql = "select COUNT(*) from login where id = ? and password = ?";
            prSt = connection.prepareStatement(sql);
            prSt.setString(1, userName);
            prSt.setString(2, password);

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                success = rs.getInt(1);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("exception in userLogin  methood : " + e.getMessage());
            System.out.println(e.getStackTrace());

            return success;
        }
        return success;
    }

    @Override
    public int userRegistration(String userName, String password) {

        int success = 0;
        try {
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            PreparedStatement prSt = null;
            String sql = "select COUNT(*) from login where id = ?";
            prSt = connection.prepareStatement(sql);
            prSt.setString(1, userName);

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                success = rs.getInt(1);
            }
            if (success == 0) {
                sql = "insert into login values (?,?)";
                prSt = connection.prepareStatement(sql);
                prSt.setString(1, userName);
                prSt.setString(2, password);
                prSt.executeUpdate();
                success = 1;
            } else {
                success = 0;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("exception in usserregistration method : " + e.getMessage());
            System.out.println(e.getStackTrace());

            return success;
        }
        return success;
    }

    @Override
    public int getBasehpbyplayerid(String userid, int playerid) {
        int playerbasehp = 100;
        try {
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            PreparedStatement prSt = null;
            String sql = "select MAX(playermaxhp) from gamestate where userid = ? and playerid = ?";
            prSt = connection.prepareStatement(sql);
            prSt.setString(1, userid);
            prSt.setInt(2, playerid);

            ResultSet rs = prSt.executeQuery();
            while (rs.next()) {
                int basehp = rs.getInt(1);
                if (basehp != 0) {
                    playerbasehp = basehp;
                }
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("exception in getBasehpbyplyerid : " + e.getMessage());
            System.out.println(e.getStackTrace());
            // return playerbasehp;
        }
        return playerbasehp;
    }

    //checking user's game saving status in last play 
    @Override
    public boolean isResume(String userid) {

        boolean issave = false;
        try {
            Connection connection = Database.getConnection();

            String sql = "select count(*) from gamestate where userid=? and issave=?";
            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.setString(1, userid);
            prSt.setInt(2, 1);
            ResultSet rs = prSt.executeQuery();

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    issave = true;
                }
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("exception in isResume method: " + e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return issave;
    }

    @Override
    public List<GameStatus> getSavedgamesbyuserid(String userid) {

        List<GameStatus> list = new ArrayList<GameStatus>();

        try {
            Connection connection = Database.getConnection();

            String sql = "select * from gamestate where userid=? and issave =?";
            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.setString(1, userid);
            prSt.setInt(2, 1);
            ResultSet rs = prSt.executeQuery();

            while (rs.next()) {
                String useid = rs.getString("userid");
                int playerid = rs.getInt("playerid");
                int playercurrenthp = rs.getInt("playercurrenthp");
                int enemyid = rs.getInt("enemyid");
                int enemycurrenthp = rs.getInt("enemycurrenthp");
                int healthpotioncount = rs.getInt("healthpotioncount");
                int playermaxhp = rs.getInt("playermaxhp");
                int issave = rs.getInt("issave");
                int gamesessionid = rs.getInt("gamesessionid");
                int damagecount = rs.getInt("damagecount");
                float currentrating = rs.getFloat("currentrating");
                GameStatus gamesessionslist = new GameStatus(useid, playerid, playercurrenthp, enemyid, enemycurrenthp,
                        healthpotioncount, playermaxhp, issave, gamesessionid, damagecount, currentrating);
                list.add(gamesessionslist);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("exception in getSavedgamesbyuserid method : " + e.getMessage());
            System.out.println(e.getStackTrace());

        }
        return list;
    }

    @Override
    public List<Player> listOfplayers() {

        List<Player> list = new ArrayList<Player>();

        try {
            Connection connection = Database.getConnection();

            String sql = "select * from player";
            PreparedStatement prSt = connection.prepareStatement(sql);

            ResultSet rs = prSt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int basehp = rs.getInt("basehp");
                int currenthp = rs.getInt("currenthp");
                int attackdamage = rs.getInt("attackdamage");
                int numhealthpotions = rs.getInt("numhealthpotions");
                Player p = new Player(id, name, basehp, currenthp, attackdamage, numhealthpotions);
                list.add(p);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("exception in listOfplayers method : " + e.getMessage());
            System.out.println(e.getStackTrace());

        }
        return list;
    }

    @Override
    public Player getPlayerdetail(int playerid) {

        Player p = null;
        try {
            Connection connection = Database.getConnection();

            String sql = "select * from player where id=?";
            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.setInt(1, playerid);
            ResultSet rs = prSt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int basehp = rs.getInt("basehp");
                int currenthp = rs.getInt("currenthp");
                int attackdamage = rs.getInt("attackdamage");
                int numhealthpotions = rs.getInt("numhealthpotions");
                p = new Player(id, name, basehp, currenthp, attackdamage, numhealthpotions);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("exception in getPlayerdetail method : " + e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return p;
    }

    @Override
    public Enemy getEnemydetail(int enemyid) {

        Enemy e = null;
        try {
            try (Connection connection = Database.getConnection()) {
                String sql = "select * from enemy where id=?";
                PreparedStatement prSt = connection.prepareStatement(sql);
                prSt.setInt(1, enemyid);
                ResultSet rs = prSt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int basehp = rs.getInt("basehp");
                    int currenthp = rs.getInt("currenthp");
                    e = new Enemy(id, name, basehp, currenthp);
                }
            }
        } catch (Exception ex) {
            System.out.println("exception in getEnemydetail method : " + ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return e;
    }

    @Override
    public void exit(String userid, Player p, Enemy e, int damagecount, float currentrating, int doSave, int resumedEnemyId) {

        try {
            Connection connection = Database.getConnection();
            String sql;
            PreparedStatement prSt = null;
            sql = "select COUNT(*) from gamestate where userid=? and playerid=? and enemyid=?";
            prSt = connection.prepareStatement(sql);
            if (e == null) {
                prSt.setInt(3, resumedEnemyId);
            } else {
                prSt.setInt(3, e.getId());
            }

            prSt.setString(1, userid);
            prSt.setInt(2, p.getId());

            ResultSet rs = prSt.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            if (count == 1) {
                String sql1;
                PreparedStatement stmt = null;
                if (e == null) {
                    sql1 = "update gamestate set playercurrenthp=?,enemyid=null,enemycurrenthp=?,healthpotioncount=?,playermaxhp=?,issave=?,damagecount=?,currentrating=? where userid=? and playerid=? and enemyid=?";
                    stmt = connection.prepareStatement(sql1);
                    stmt.setInt(1, p.getCurrenthp());
                    stmt.setInt(2, 0);
                    stmt.setInt(3, p.getNumhealthpotions());
                    stmt.setInt(4, p.getBasehp());
                    stmt.setInt(5, doSave);
                    stmt.setInt(6, damagecount);
                    stmt.setFloat(7, currentrating);
                    stmt.setString(8, userid);
                    stmt.setInt(9, p.getId());
                    stmt.setInt(10, resumedEnemyId);
                } else {
                    sql1 = "update gamestate set playercurrenthp=?,enemyid=?,enemycurrenthp=?,healthpotioncount=?,playermaxhp=?,issave=?,damagecount=?,currentrating=? where userid=? and playerid=? and enemyid=?";
                    stmt = connection.prepareStatement(sql1);
                    stmt.setInt(1, p.getCurrenthp());
                    stmt.setInt(2, e.getId());
                    stmt.setInt(3, e.getCurrentHp());
                    stmt.setInt(4, p.getNumhealthpotions());
                    stmt.setInt(5, p.getBasehp());
                    stmt.setInt(6, doSave);
                    stmt.setInt(7, damagecount);
                    stmt.setFloat(8, currentrating);
                    stmt.setString(9, userid);
                    stmt.setInt(10, p.getId());
                    stmt.setInt(11, e.getId());
                }

                stmt.executeUpdate();

            } else {
                String sql1;
                PreparedStatement stmt = null;
                if (e == null) {
                    sql1 = "insert into gamestate(userid,playerid,playercurrenthp,enemyid,enemycurrenthp,healthpotioncount,playermaxhp,issave,damagecount,currentrating) values (?,?,?,null,?,?,?,?,?,?)";
                    stmt = connection.prepareStatement(sql1);
                    stmt.setString(1, userid);
                    stmt.setInt(2, p.getId());
                    stmt.setInt(3, p.getCurrenthp());
                    stmt.setInt(4, 0);
                    stmt.setInt(5, p.getNumhealthpotions());
                    stmt.setInt(6, p.getBasehp());
                    stmt.setInt(7, doSave);
                    stmt.setInt(8, damagecount);
                    stmt.setFloat(9, currentrating);
                } else {
                    sql1 = "insert into gamestate(userid,playerid,playercurrenthp,enemyid,enemycurrenthp,healthpotioncount,playermaxhp,issave,damagecount,currentrating) values (?,?,?,?,?,?,?,?,?,?)";
                    stmt = connection.prepareStatement(sql1);
                    stmt.setString(1, userid);
                    stmt.setInt(2, p.getId());
                    stmt.setInt(3, p.getCurrenthp());
                    stmt.setInt(4, e.getId());
                    stmt.setInt(5, e.getCurrentHp());
                    stmt.setInt(6, p.getNumhealthpotions());
                    stmt.setInt(7, p.getBasehp());
                    stmt.setInt(8, doSave);
                    stmt.setInt(9, damagecount);
                    stmt.setFloat(10, currentrating);
                }

                stmt.executeUpdate();
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("exception in exit method : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserstatistics(String userid) {

        User user = null;
        try {
            Connection connection = Database.getConnection();

            String sql = "select * from userstatistics where userid=?";
            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.setString(1, userid);
            ResultSet rs = prSt.executeQuery();

            while (rs.next()) {
                String useid = rs.getString("userid");
                int experiencecount = rs.getInt("experiencecount");
                float starrating = rs.getFloat("starrating");
                user = new User(userid, experiencecount, starrating);
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("exception in getUserstatistics : " + ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return user;
    }

    @Override
    public GameStatus resumeGame(String userid, int issavestatus) {

        GameStatus gs = null;
        try {

            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            PreparedStatement prSt = null;
            String sql = "select * from gamestate where userid = ? and issave = ?";
            prSt = connection.prepareStatement(sql);
            prSt.setString(1, userid);
            prSt.setInt(2, issavestatus);

            ResultSet rs = prSt.executeQuery();

            while (rs.next()) {
                String uid = rs.getString("userid");
                int pid = rs.getInt("playerid");
                int pchp = rs.getInt("playercurrenthp");
                int eid = rs.getInt("enemyid");
                int echp = rs.getInt("enemycurrenthp");
                int hpc = rs.getInt("healthpotioncount");
                int pmhp = rs.getInt("playermaxhp");
                int issave = rs.getInt("issave");
                int gamesessionid = rs.getInt("gamesessionid");
                int damagecount = rs.getInt("damagecount");
                float currentrating = rs.getFloat("currentrating");
                gs = new GameStatus(uid, pid, pchp, eid, echp, hpc, pmhp, issave, gamesessionid, damagecount, currentrating);

            }
            connection.close();
        } catch (Exception e) {
            System.out.println("exception in resumeGame : " + e.getMessage());
            System.out.println(e.getStackTrace());

        }
        return gs;
    }

    @Override
    public void insertUserrating(String userid, int experiencecount, float starrating, int existance) {

        try {
            Connection connection = Database.getConnection();

            if (existance == 1) {
                String sql1 = "update userstatistics set experiencecount=?,starrating=? where userid=?";
                PreparedStatement stmt = connection.prepareStatement(sql1);

                stmt.setInt(1, experiencecount);
                stmt.setFloat(2, starrating);
                stmt.setString(3, userid);

                stmt.executeUpdate();

            } else {
                String sql1 = "insert into userstatistics(userid,experiencecount,starrating) values (?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql1);
                stmt.setString(1, userid);
                stmt.setInt(2, experiencecount);
                stmt.setFloat(3, starrating);

                stmt.executeUpdate();
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("exception in insertUserrating method : " + ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
    }
}
