# GamingPlatform for Role Playing Games
- Project : Gaming Platform
- Description :	This project is a Gaming Platform which can be used to create new role playing games or play the existing game. It can be scaled up to support multiple games and create multiple user.
- On executing the gaming platform code, the instructions to proceed are given.
- Just install the game using steps below.
- Source code resides in directory: GamingPlatform/src/rpggame

Pre requisites :-
1. MYSQL Server
2. JDK or JRE
3. IDE or CMD

Steps to install and run Gaming Platform Project:

1. Git clone the project from "https://github.com/sanyamjain007/GamingPlatform" or download the zip file in email.
2. Install and run mysql server 8.0 on your system.
3. Set MySQL credentials as.
	  
	  user = "root" 
	  
	  password = "123456"
	  
	  To reset credentials, run below command.
		
	  mysql>ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';
	
4. Dump RPGGame.sql file into mysql server using the below commands.

	  mysql>create database rpggame;
	  
	  mysql>use rpggame;
	  
	  mysql>source RPGGame.sql; /** Note: give the proper path of RPGGame.sql file **/

5. Import the project in a java supported IDE and run the project
OR
5. Run project by double tap on run.bat file. /**Note : File Location :- GamingPlatform/dist/run.bat **/

6. Play game and enjoy.

Key Features of Gaming Platform Project:

1. Factory Design Pattern : Fully scalable to extend to new functionalities
2. MVC architecture
3. Use of Data Access Object (Dao)
4. Multiple Player support
5. Multiple Enemy support
6. Multiple Game support
7. Game report of saved games
8. Star rating based on performance
9. Game statistics after each action 
10. Player's base hp boost based on performance
11. Databases to store Game Related Information


Future Enhancements to Gaming Platform Project:

Design Changes:
1. Store Game Status in Files instead of storing it in databases.
2. Provide interface to create concreate class objects instead of creating concrete class objects directly.

Functionalities to be added:
1. Learning Experience: Currently, we are using static learning for experience of character. This can be
scaled up to dynamic or better learning using Machine Learning algorithms.
2. Display a list of available games to play.
3. Allow user to create character.
4. Allow user to choose enemy.
5. Introduce levels in game and level up based on experience.
