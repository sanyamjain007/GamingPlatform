/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

import java.io.Console;
import rpggame.controller.GameController;
import java.util.Scanner;

/**
 *
 * @author sajain
 */
public class RPGGame {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameController controller = new GameController();
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        String userId = null;
        String password;
        int success;
        int login = 0;

        Messages.display(Messages.WELCOME_MESSAGE);

        Messages.display(Messages.EOL_LENGTH_1);
        Messages.display(Messages.GAME_INSTRUCTION_HEADING);
        Messages.display(Messages.GAME_INSTRUCTIONS);
        Messages.display(Messages.EOL_LENGTH_1);

        while (login == 0) {
            Messages.display(Messages.LOGIN_MESSAGE);
            Messages.display(Messages.LOGIN);
            Messages.display(Messages.REGISTRATION);
            String number = scanner.next();
            if (!number.equals("1") && !number.equals("2")) {
                Messages.display(Messages.INVALID_MSG);
                continue;
            }
            success = 0;
            while (success != 1) {
                Messages.display(Messages.ENTER_USER_NAME);
                userId = scanner.next();
                Messages.display(Messages.ENTER_PASSWORD);
                if (console == null) {
                    password = scanner.next();
                } else {
                    char pass[] = console.readPassword();
                    password = new String(pass);
                }

                //Login
                if (number.equals("1")) {
                    success = controller.userLogin(userId, password);
                    if (success == 1) {
                        Messages.display(Messages.LOGIN_SUCCESS);
                        login = 1;
                    } else {
                        Messages.display(Messages.LOGIN_ERROR);
                        success = 1;
                    }
                } else { //Registration
                    success = controller.userRegistration(userId, password);
                    if (success == 1) {
                        Messages.display(Messages.REGISTRATION_SUCCESS);
                    } else {
                        Messages.display(Messages.USERNAME_EXIST);
                        success = 1;
                    }
                }
            }
        }

        Messages.display(Messages.EOL_DOTTED_LENGTH_3);

        try {
            Game gameObj = new AvengersGame();
            gameObj.play(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Messages.display(Messages.EOL_LENGTH_2);
            Messages.display(Messages.THANKS_MSG);
            Messages.display(Messages.EOL_LENGTH_2);
            System.exit(0);
        }
    }
}
