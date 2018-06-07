# GamingPlatform
- Project : Gaming Platform
- Description :	This project is a Gaming Platform. It can be scaled up to support multiple games, create multiple user, save and resume game.
- On executing the gaming platform code, the instructions to proceed are given.
- Just install the game using steps below.
- Source code resides in directory: GamingPlatform/src/rpggame

- Steps to install and run Gaming Platform Project:

a. Git clone the project from "https://github.com/sanyamjain007/GamingPlatform" or download the zip file in email.
b. Install and run mysql server 8.0 on your system.
c. Set MySQL credentials as.
	  user = "root" 
	  password = "123456"
	  To reset credentials, run below command.
		mysql>ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';
	
d. Dump RPGGame.sql file into mysql server using the below commands.
	  mysql>create database rpggame;
	  mysql>use rpggame;
	  mysql>source RPGGame.sql; /** Note: give the proper path of RPGGame.sql file **/

e. Import the project in a java supported IDE and run the project
OR
e. Run project by double tap on run.bat file. /**Note : File Location :- GamingPlatform/dist/run.bat **/

f. Play game and enjoy.

- Key Features of Gaming Platform Project:

1. Factory Design Pattern : Fully scalable to extend to new functionalities
2. MVC architecture
3. Use of Data Access Object (Dao)
4. Multiple Player support
5. Multiple Character support
6. Multiple Game support
7. Databases to store Game Related Information
8. Game report of saved games


- Future Enhancements to Gaming Platform Project:

Design Changes:
1. Store Game Status in Files instead of storing it in databases.
2. Merge "Player" and "Enemy" concrete classes to "Character" class instead of creating separate classes.

Functionality to be added:
1. Learning Experience: Currently, we are using static learning for experience of character. This can be
scaled up to dynamic or better learning using Machine Learning algorithms.
2. Add registration functionality for new user.
3. Display a list of saved game to resume.
4. Allow user to create character.
