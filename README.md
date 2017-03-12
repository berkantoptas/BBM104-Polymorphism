# BBM104-Polymorphism
Hacettepe University Computer Engineering BBM104 - Third Assignment

#2. Software Using Documentation
##2.1. Software Usage
Program starts “Main.java” class. The input file is given as an argument. command.txt file is the our argument file.(args[0]=command.txt)
Program reads other files at “Monopoly.java” class.(property.json and list.json)
##2.2. Error Messages
Program doesn’t have any error messages. Because advisors said that not give wrong input.
#3.Software Design Notes
##3.1. Desctiption of the program
###3.1.1. Problem
In this experiment, I am expected to implement monopoly with the given rule. Main focus point of this experiment is to get me familiar with polymorphism and abstract classes.
###3.1.2. Solution
I solved the problem when I read the given article at Appendix A.
I created Action.java class and Property.java class and typed them abstract.
##3.2. System Chart
Input : command.txt
Programs : Main.java
Monopoly.java
GameData.java
Square.java
Property.java
Land.java
RailRoad.java
Company.java
Action.java
Chance.java
CommunityChest.java
Go.java
Jail.java
FreeParking.java
GotoJail.java
Tax.java
Output : Output.txt
##3.3. Algorithm
1. Program takes 1 argument (args[0]=command.txt)
2. Call runProgram function with argument.
2.1. By calling runProgram function property.json, list.json and command.txt files will read and parse.
2.2. Also by calling runProgram function show() functions will executed.
2.2.1. show() function will create output.txt.

##REFERENCES
https://en.wikipedia.org/wiki/Javadoc
https://en.wikipedia.org/wiki/JSON
http://tutorials.jenkov.com/java/abstract-classes.html
http://www.mkyong.com/java/json-simple-example-read-and-write-json/
http://stackoverflow.com/
