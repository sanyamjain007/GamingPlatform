/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

/**
 *
 * @author Sanyam Jain This class contains the prints messages
 */
public class Messages {
    public final static String WELCOME_MESSAGE = "# ************************** Welcome to the Avengers ************************** #\n";
    public final static String GAME_INSTRUCTION_HEADING = "# Game's Instructions --> #";
    public final static String GAME_INSTRUCTIONS = "###############..... This is a warriors fighting game..... ###################\n"
            + "-> As a user you can login and register.\n"
            + "-> You have to first login to play game.\n"
            + "-> You can start new game or resume previous saved games.\n"
            + "-> You can select a player(character) from a list of players.\n"
            + "-> Enemy will be randomly seelected for fight.\n"
            + "-> You can perform following actions in the game.\n"
            + " \t > Attack\n"
            + " \t > Drink Health Potion\n"
            + " \t > Run Away\n"
            + " \t > Save and Exit\n"
            + " \t > Exit\n"
            + "-> You can drink health potions to increase hp.\n"
            + "-> You can save or exit the game at any moment.\n"
            + "-> Player's basehp will be increased based on his performance.\n"
            + "-> Star rating will be given to a player based on his performance and experience. #\n";
    
    public final static String LOGIN_MESSAGE = "Please select 1 for login and 2 for registration";
    public final static String LOGIN = "\t>1. Login";
    public final static String REGISTRATION = "\t>2. Registration";
    public final static String ENTER_USER_NAME = "Enter Username";
    public final static String ENTER_PASSWORD = "Enter Password";
    public final static String LOGIN_ERROR = "Login fail....Try again or register first!\n";
    public final static String LOGIN_SUCCESS = "Login Successful!\n";
    public final static String REGISTRATION_SUCCESS = "Registration Successful!\n";
    public final static String USERNAME_EXIST = "Usename already exists....please use different username!\n";
    public final static String AVENGERS = "Avengers";
    public final static String WARRIER_FIGHTING_GAME = "This is a warrior fighting game";
    public final static String START_NEW_GAME = "\t1. Start New Game";
    public final static String RESUME_MESSAGE = "\t2. Resume a Game";
    public final static String RESUME_GAME_SELECT_MSG = "Plase select a game which you want to resume";
    public final static String GAME = "Game";
    public final static String CURRENT_STATUS = "Current Status";
    public final static String PLAYER_CURRENT_HP = "Player's Current hp";
    public final static String ENEMY_ID = "Enemy's id";
    public final static String ENEMY_CURRENT_HP = "Enemy's Currenthp";
    public final static String PLAYER_ID = "Player's id";
    public final static String HEALTHY_POTION_COUNT = "HealthPotionCount";
    public final static String DAMAGE_COUNT = "Damage Count";
    public final static String CURRENT_RATING = "Current Rating";
    public final static String DAMAGE_COUNT_FROM_DB = "damageCount from db :";
    public final static String STAR_RATING_FROM_DB = "StarRating from db :";
    public final static String STARTING_NEW_GAME = " # **************** Starting new game **************** #";
    public final static String SELECT_NEW_PLAYER = "Plase select one player from the List of players";
    public final static String HELLO = "\t# Hello  ";
    public final static String YOUR_ENEMY = " is your enemy! #\n";
    public final static String YOUR_CURRENT_HP = "\t> Your Current HP: ";
    public final static String CURRENT_HP = "Current HP: ";
    public final static String AVAILBALE_POTION = "\t> Number of health potions available: ";
    public final static String ACTION_MESSAGE = "What do you want to do?";
    public final static String ATTACK = "Attack";
    public final static String HEALTH_IMPROVE = "Drink Health Potion";
    public final static String RUN_AWAY = "Run Away!";
    public final static String SAVE_AND_EXIT = "Save & Quit";
    public final static String EXIT_GAME = "Quit Game!";
    public final static String ATTACK_MESSAGE = "\t> You have taken too much damage, you are to weak to go on!";
    public final static String RUN_AWAY_MSG = "\tYou run away from the";
    public final static String INVALID_MSG = "Invalid Input!!";
    public final static String DEFEAT_GAME_MSG = "\t############***********OOps!!!!............You lost the fight*****************###################.\n";
    public final static String WAS_DEFEATED = "was defeated! #";
    public final static String EXCEPTION_MSG = "Exception in game :";
    public final static String GAME_STATISTICS = "\t # Game Statistics -->";
    public final static String YOU_STRIKE = "You Strike the ";
    public final static String FOR = " for ";
    public final static String DAMAGE = " damage";
    public final static String YOU_RECEIVE = "You receive  ";
    public final static String RETALIATION = " in retaliation";
    public final static String RATING_FOR_CURRENT_ATTACK = "Rating for current attack is ";
    public final static String HEALTHY_POTION_DRINKING_MSG = "You drink a health potion, healing yourself for ";
    public final static String YOU_NOW_HAVE = "You now have";
    public final static String YOU_HAVE = "You have";
    public final static String POTION_LEFT_MSG = " health potions left.\n";
    public final static String HP = "HP.";
    public final static String LEFT_HP = " HP left. #";
    public final static String THE = " # The ";
    public final static String DROPPED_POTION = " dropped a health potion! #";
    public final static String POTION_LEFT_MSG1 = "You have no health potions left! Defeat enemies ";
    public final static String POTION_LEFT_MSG2 = "for a chance to get one.";
    public final static String HEALTH_POTION = "health potion(s).";
    public final static String INVALID_CMD = "Invalid command";
    public final static String PREVIOUS_RATING = "Previous rating";
    public final static String EXPERIENCE_COUNT = "Experience Count";
    public final static String CURRENT_AVG_RATING = "Current rating :";
    public final static String FINAL_RATING = " Overall rating ";
    public final static String NO_RESUME = "\n\t# No game to resume! #";
    public final static String RATING_STATISTICS = "# Rating Statistics -->";
    public final static String WIN_MSG = "##********##********##********Congratulations**********You Won the fight.*******##********##*********##";
    public final static String EOL = "###########################";
    public final static String EOL_LENGTH_1 = "##################################################################################\n";
    public final static String EOL_LENGTH_2 = "#######################";
    public final static String EOL_DOTTED_LENGTH_1 = "------------------------------------------------";
    public final static String EOL_DOTTED_LENGTH_2 = "\t -------------------------------";
    public final static String EOL_DOTTED_LENGTH_3 = "------------------------------------------------------------------------------------\n";
    public final static String THANKS_MSG = "# THANKS FOR PLAYING! #";
    
    public static void display(String msg) {
        System.out.println(msg);
    }
}
