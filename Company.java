
public class Company extends Property {
	
	/**
	 * Company applyAction function.
	 */
	public void applyAction(GameData gameData)
	{
		//has money
		if(ownedBy == 0 && gameData.currentTurn == 1 && gameData.p1Money >= cost)
		{
			ownedBy = 1;
			gameData.p1Money -= cost;
			gameData.bankerMoney += cost;
			gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\t" + "Player 1 bought " + propertyName);
			gameData.haveList1.add(propertyName);
		}
		else if(ownedBy == 0 && gameData.currentTurn ==2 && gameData.p2Money >= cost)
		{
			ownedBy = 2;
			gameData.p2Money -= cost;
			gameData.bankerMoney += cost;
			gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\t"  + "Player 2 bought " + propertyName);
			gameData.haveList2.add(propertyName);
		}
						
		//has not money .. game will finished
		else if(gameData.currentTurn == 1 && gameData.p1Money < cost)
		{
			gameData.isGameFinished = true;
			gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 1 goes bankrupt");
		}
		else if(gameData.currentTurn == 2 && gameData.p2Money < cost)
		{
			gameData.isGameFinished = true;
			gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 2 goes bankrupt");
		}	
		//has money but already bought .. he ll pay rent to other player
		else if(gameData.currentTurn == 1 && ownedBy == 2)
		{
			if(gameData.p1Money - getRent(gameData.currentDice) < 0)
			{
				gameData.isGameFinished = true;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 1 goes bankrupt");
			}	
			else
			{
				gameData.p1Money -= getRent(gameData.currentDice);
				gameData.p2Money += getRent(gameData.currentDice);
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 1 paid rent for " + propertyName);
			}
		}

		else if(gameData.currentTurn == 2 && ownedBy == 1)
		{
			if(gameData.p2Money - getRent(gameData.currentDice) < 0)
			{
				gameData.isGameFinished = true;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 2 goes bankrupt");
			}
			else
			{
				gameData.p2Money -= getRent(gameData.currentDice);
				gameData.p1Money += getRent(gameData.currentDice);
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 2 paid rent for " + propertyName);
			}		
		}
		//has money but already he bought there
		else if(gameData.currentTurn == 1 && ownedBy == 1)
		{
			gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 1 has " + propertyName);
		}
		else if(gameData.currentTurn == 2 && ownedBy == 2)
		{
			gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money  + "\tPlayer 2 has " + propertyName);
		}
	}
	
	/**
	 * 
	 * @param dice
	 * @return 4*dice
	 * This function is calculating rent for Company Property
	 */
	private int getRent(int dice)
	{
		return 4 * dice;
	}


}
