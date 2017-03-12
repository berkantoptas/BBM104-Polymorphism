
public class Chance extends Action 
{
	/**
	 * Chance applyAction function.
	 */
	public void applyAction(GameData gameData)
	{
		/**
		 * Advance to Go (Collect $200)
		 */
		if(gameData.nextChanceCardIndex == 0) //Advance to Go (Collect $200)
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1CurrentSquare = 0;
				gameData.p1Money += 200;
				gameData.bankerMoney -=200;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Advance to Go (Collect $200)");
			}
			else
			{
				gameData.p2CurrentSquare = 0;
				gameData.p2Money += 200;
				gameData.bankerMoney -=200;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Advance to Go (Collect $200)");
			}
		}
		/**
		 * Advance to Leicester Square 
		 */
		else if(gameData.nextChanceCardIndex == 1) //Advance to Leicester Square 
		{
			gameData.isPlayerPositionForceChanged = true;
			if(gameData.currentTurn == 1)
			{
				if(gameData.p1CurrentSquare > 30)
				{
					gameData.p1Money += 200;
					gameData.bankerMoney -= 200; 
				}
				gameData.p1CurrentSquare = 26;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Advance to Leicester Square");
			}
			else
			{
				if(gameData.p2CurrentSquare > 30)
				{
					gameData.p2Money += 200;
					gameData.bankerMoney -= 200; 
				}
				gameData.p2CurrentSquare = 26;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Advance to Leicester Square");
			}	
		}
		/**
		 * Go back 3 spaces
		 */
		else if(gameData.nextChanceCardIndex == 2) //Go back 3 spaces
		{
			gameData.isPlayerPositionForceChanged = true;
			if(gameData.currentTurn == 1)
			{
				gameData.p1CurrentSquare -= 3;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Go back 3 spaces");
			}
			else 
			{
				gameData.p2CurrentSquare -= 3;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Go back 3 spaces");
			}
		}
		/**
		 * Pay poor tax of $15
		 */
		else if(gameData.nextChanceCardIndex == 3) //Pay poor tax of $15
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money -= 15;
				gameData.bankerMoney += 15;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Pay poor tax of $15");
			}
			else
			{
				gameData.p2Money -= 15;
				gameData.bankerMoney += 15;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Pay poor tax of $15");
			}
		}
		/**
		 * Your building loan matures - collect $150
		 */
		else if(gameData.nextChanceCardIndex == 4) //Your building loan matures - collect $150
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 150;
				gameData.bankerMoney -= 150;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Your building loan matures - collect $150");
			}
			else
			{
				gameData.p2Money += 150;
				gameData.bankerMoney -= 150;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Your building loan matures - collect $150");
			}
		}
		/**
		 * You have won a crossword competition - collect $100
		 */
		else if(gameData.nextChanceCardIndex == 5) //You have won a crossword competition - collect $100 
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 100;
				gameData.bankerMoney -= 100;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw You have won a crossword competition - collect $100");
			}
			else
			{
				gameData.p2Money += 100;
				gameData.bankerMoney -= 100;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw You have won a crossword competition - collect $100");
			}
		}	
				
		if(gameData.nextChanceCardIndex == 5)
			gameData.nextChanceCardIndex = 0;	
		else
			gameData.nextChanceCardIndex++;	
		
	}
	

}
