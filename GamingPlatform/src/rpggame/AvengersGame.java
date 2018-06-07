/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

import rpggame.controller.GameController;
import rpggame.model.GameStatus;
import rpggame.model.User;
import rpggame.model.Player;
import rpggame.model.Enemy;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sajain
 */
public class AvengersGame extends Game implements Constants {

    public AvengersGame() {
        super(Messages.AVENGERS, Messages.WARRIER_FIGHTING_GAME);
    }

    GameController controller = new GameController();
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    //variables for looping control
    boolean savedGame = true;
    boolean running = true;
    boolean play = true;

    //variable for jump
    String type = "label";
    //input from user
    String input;

    String userId = null;
    Player player = null;
    Enemy enemy = null;

    //Variables for rating calculation
    float ratingSum = 0;
    int damageCount = 0;
    float starRating = 0;
    float finalAverageRating = 0;
    int lastEnemyId = -1;

    int resumedEnemyId;

    @Override
    protected void play(String userId) {
        this.userId = userId;
        System.out.println(Messages.EOL);
        System.out.println("# Welcome to the " + name + " #");
        System.out.println(Messages.EOL);

        PLAY:
        while (play) {
            OPTIONS:
            while (savedGame) {
                Messages.display(Messages.ACTION_MESSAGE);
                Messages.display(Messages.START_NEW_GAME);
                Messages.display(Messages.RESUME_MESSAGE);
                input = scanner.next();

                while (!input.equals("1") && !input.equals("2")) {
                    Messages.display(Messages.INVALID_MSG);
                    input = scanner.next();
                }
                if (input.equals("1")) {
                    Messages.display(Messages.STARTING_NEW_GAME);
                    savedGame = false;
                    List<Player> playerList = controller.getListofplayers();
                    Iterator<Player> iterator = playerList.iterator();
                    int count = 1;
                    Messages.display(Messages.SELECT_NEW_PLAYER);
                    while (iterator.hasNext()) {
                        Player playerObj = iterator.next();
                        Messages.display("\t" + count + ".> " + playerObj.getName());
                        count++;
                    }

                    int playerId = scanner.nextInt();
                    player = controller.getPlayerdetail(playerId);

                    //setting the basehp based on pervious experience
                    player.setCurrenthp(controller.getBasehpbyplayerid(userId, playerId));
                } else {
                    List<GameStatus> gamesList = controller.getSavedgamesbyuserid(userId);
                    Iterator<GameStatus> iterator = gamesList.iterator();

                    if (!iterator.hasNext()) {
                        Messages.display(Messages.NO_RESUME);
                        Messages.display("\n------------------------------------------");
                        continue OPTIONS;
                    } else {
                        Messages.display("\n--------------------------------------------");
                        Messages.display(Messages.RESUME_GAME_SELECT_MSG);
                        savedGame = false;
                    }
                    int gameCount = 1;
                    while (iterator.hasNext()) {
                        GameStatus gameStatus = iterator.next();
                        Messages.display("\n # " + Messages.GAME + " > " + gameCount
                                + ". " + Messages.CURRENT_STATUS + " :-\n --> "
                                + Messages.PLAYER_ID + " : " + gameStatus.getPlayerid()
                                + " || " + Messages.PLAYER_CURRENT_HP + " :" + gameStatus.getPlayercurrenthp()
                                + ",\n --> " + Messages.ENEMY_ID + " : " + gameStatus.getEnemyid()
                                + " || " + Messages.ENEMY_CURRENT_HP + " :" + gameStatus.getEnemycurrenthp()
                                + ",\n --> " + Messages.HEALTHY_POTION_COUNT + " : " + gameStatus.getHealthpotioncount()
                                + " \n--> " + Messages.DAMAGE_COUNT + " : " + gameStatus.getDamagecount()
                                + " || " + Messages.CURRENT_RATING + " : " + gameStatus.getCurrentrating() + " #");
                        gameCount++;
                    }
                    int gameSessionId = scanner.nextInt();
                    GameStatus gamestatus = gamesList.get(gameSessionId - 1);
                    damageCount = gamestatus.getDamagecount();
                    starRating = gamestatus.getCurrentrating();
                    ratingSum = damageCount + starRating;

                    player = controller.getPlayerdetail(gamestatus.getPlayerid());
                    player.setCurrenthp(gamestatus.getPlayercurrenthp());
                    player.setNumhealthpotions(gamestatus.getHealthpotioncount());

                    resumedEnemyId = gamestatus.getEnemyid();
                    lastEnemyId = gamestatus.getEnemyid();
                    enemy = controller.getEnemydetail(gamestatus.getEnemyid());
                    enemy.setCurrentHp(gamestatus.getEnemycurrenthp());
                }
            }
            //label for while loop
            GAME:
            while (running) {
                System.out.println(Messages.EOL_DOTTED_LENGTH_1);
                if (enemy == null) {
                    int enemyId = rand.nextInt(4)+1;
                    while (lastEnemyId == enemyId) {
                        enemyId = rand.nextInt(4)+1;
                    }
                    lastEnemyId = enemyId;
                    enemy = controller.getEnemydetail(enemyId);
                    enemy.setCurrentHp(ENEMY_BASE_HP);
                }
                Messages.display(Messages.HELLO + player.getName() + ", " + enemy.getName() + Messages.YOUR_ENEMY);
                OUTER:
                while (enemy.getCurrentHp() > 0) {
                    Messages.display(Messages.EOL_DOTTED_LENGTH_2);
                    Messages.display(Messages.YOUR_CURRENT_HP + player.getCurrenthp());
                    Messages.display("\t> " + enemy.getName() + "'s " + Messages.CURRENT_HP + enemy.getCurrentHp());
                    Messages.display(Messages.AVAILBALE_POTION + player.getNumhealthpotions());

                    Messages.display(Messages.EOL_DOTTED_LENGTH_2);
                    Messages.display("\n\t# " + Messages.ACTION_MESSAGE);
                    Messages.display("\t1. " + Messages.ATTACK);
                    Messages.display("\t2. " + Messages.HEALTH_IMPROVE);
                    Messages.display("\t3. " + Messages.RUN_AWAY);
                    Messages.display("\t4. " + Messages.SAVE_AND_EXIT);
                    Messages.display("\t5. " + Messages.EXIT_GAME);
                    input = scanner.next();
                    while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5")) {
                        Messages.display(Messages.INVALID_CMD);
                        input = scanner.next();
                    }
                    switch (input) {
                        case "1":
                            action(Actions.ATTACK);
                            break;
                        case "2":
                            action(Actions.DRINK_HEALTH_POTION);
                            break;
                        case "3":
                            action(Actions.RUN_AWAY);
                            break;
                        case "4":
                            action(Actions.SAVE_AND_EXIT);
                            break PLAY;
                        case "5":
                            action(Actions.EXIT);
                            break PLAY;
                        default:
                            break;
                    }
                    switch (type) {
                        case "OUTER":
                            break OUTER;
                        case "GAME":
                            continue GAME;
                        default:
                            break;
                    }
                }

                int isPlayerAlive = 1;
                if (player.getCurrenthp() < 1) {
                    Messages.display(Messages.DEFEAT_GAME_MSG);
                    Messages.display(Messages.EOL_DOTTED_LENGTH_3);
                    if(enemy.getCurrentHp() <1) {
                         Messages.display("# " + enemy.getName() + " " + Messages.WAS_DEFEATED);
                         enemy.setCurrentHp(ENEMY_BASE_HP);
                    }
                   
                    isPlayerAlive = 0;
                    savedGame = true;
                    continue PLAY;
                }

                Messages.display(Messages.EOL_DOTTED_LENGTH_1);
                Messages.display("# " + enemy.getName() + " " + Messages.WAS_DEFEATED);
                Messages.display("# " + Messages.YOU_HAVE + player.getCurrenthp() + " " + Messages.LEFT_HP);
                if (rand.nextInt(100) < HEALTH_POTION_DROP_CHANCE) {
                    player.setNumhealthpotions(player.getNumhealthpotions() + 1);
                    Messages.display(Messages.THE +" "+ enemy.getName() + " " + Messages.DROPPED_POTION);
                    Messages.display(" # " + Messages.YOU_NOW_HAVE + player.getNumhealthpotions() + " " + Messages.HEALTH_POTION + " #");
                }
                if (isPlayerAlive == 1) {
                    enemy = null;
                    break;
                }
                Messages.display(Messages.WIN_MSG);
            }
            System.out.println(Messages.EOL_DOTTED_LENGTH_1);
            System.out.println("What would you like to do now ?");
            System.out.println("1. Continue Fighting");
            System.out.println("2. Exit game");

            input = scanner.next();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command!");
                input = scanner.next();
            }

            if (input.equals("1")) {
                System.out.println("You continue to your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the game from your adventure");
                exit();
                break;
            }

        }
    }

    @Override
    protected void action(Actions action) {
        switch (action) {
            case ATTACK:
                int damageDealt = rand.nextInt(ATTACK_DAMAGE);
                float currentRating = giveRating(damageDealt);
                ratingSum += currentRating;

                damageCount++;
                int damageTaken = rand.nextInt(ENEMY_ATTACK_DAMAGE);

                //condition for increasing player's basehp
                if (damageDealt > 40) {
                    player.setBasehp(player.getBasehp() + 10);
                }

                enemy.setCurrentHp(enemy.getCurrentHp() - damageDealt);
                player.setCurrenthp(player.getCurrenthp() - damageTaken);

                Messages.display(Messages.GAME_STATISTICS);
                Messages.display(Messages.EOL_DOTTED_LENGTH_2);
                Messages.display("\t> " + Messages.YOU_STRIKE + enemy.getName() + Messages.FOR + damageDealt + " damage.");
                Messages.display("\t>  " + Messages.YOU_RECEIVE + damageTaken + Messages.RETALIATION);
                Messages.display("\t>  " + Messages.RATING_FOR_CURRENT_ATTACK + ":" + currentRating);
                Messages.display(Messages.EOL_DOTTED_LENGTH_2 + "\n");
                if (player.getCurrenthp() < 1) {
                    player.setCurrenthp(0);
                    Messages.display(Messages.ATTACK_MESSAGE);
                    type = "OUTER";
                }
                break;

            case DRINK_HEALTH_POTION:
                if (player.getNumhealthpotions() > 0) {
                    player.setCurrenthp(player.getCurrenthp() + HEALTH_POTION_HEAL_AMOUNT);
                    player.setNumhealthpotions(player.getNumhealthpotions() - 1);
                    Messages.display("\t> " + Messages.HEALTHY_POTION_DRINKING_MSG
                            + HEALTH_POTION_HEAL_AMOUNT
                            + "\n\t>" + Messages.YOU_NOW_HAVE + player.getCurrenthp() + " " + Messages.HP
                            + "\n\t> " + Messages.YOU_HAVE + player.getNumhealthpotions() + " " + Messages.POTION_LEFT_MSG);
                } else {
                    Messages.display("\t> " + Messages.POTION_LEFT_MSG1
                            + Messages.POTION_LEFT_MSG2);
                }
                break;

            case RUN_AWAY:
                Messages.display(Messages.RUN_AWAY_MSG + enemy.getName() + "!");
                enemy = null;
                type = "GAME";
                break;

            case SAVE_AND_EXIT:
                saveAndexit();
                break;

            case EXIT:
                exit();
                break;

            default:
                Messages.display("\t" + Messages.INVALID_CMD);
                break;
        }
    }

    @Override
    protected void saveAndexit() {
        updateRating();
        controller.saveAndexit(userId, player, enemy, damageCount, finalAverageRating, 1);
    }

    @Override
    protected void exit() {
        updateRating();
        controller.exit(userId, player, enemy, damageCount, finalAverageRating, 0, resumedEnemyId);
    }

    //give rating for an attack
    protected float giveRating(int damage) {
        float rating = Float.valueOf(damage) / 10;
        return rating;
    }

    //updating average rating for a user
    protected void updateRating() {
        User user = controller.getUserstatistics(userId);
        Messages.display(Messages.RATING_STATISTICS);
        Messages.display(Messages.EOL_DOTTED_LENGTH_1);
        if (user != null) {
            Messages.display("\t# " + Messages.PREVIOUS_RATING + " : " + user.getStarrating());
            Messages.display("\t# " + Messages.EXPERIENCE_COUNT + " : " + user.getExperience());
        }
        finalAverageRating = 0;
        float previousRating;
        int experienceCount = 0;
        int flag = 0;
        float currentaveragerating = ratingSum / damageCount;
        Messages.display("\t# " + Messages.CURRENT_RATING + " : " + currentaveragerating);
        if (user == null) {
            finalAverageRating = currentaveragerating;
        } else {
            flag = 1;//used for existence
            previousRating = user.getStarrating();
            experienceCount = user.getExperience();
            finalAverageRating = (previousRating * experienceCount + currentaveragerating) / (experienceCount + 1);
        }

        Messages.display("\t#" + Messages.FINAL_RATING + ": " + finalAverageRating);
        Messages.display(Messages.EOL_DOTTED_LENGTH_1);

        controller.insertUserrating(userId, experienceCount + 1, finalAverageRating, flag);
    }
}
