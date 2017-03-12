
public class GoToJail extends Square 
{
	/**
	 * GoToJail applyAction function.
	 */
	public void applyAction(GameData gameData)
	{
		if(gameData.currentTurn == 1)
		{
			gameData.p1CurrentSquare = 10;
			gameData.p1JailRemaining += 3;
			gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 went to jail");
		}
		else
		{
			gameData.p2CurrentSquare = 10;
			gameData.p2JailRemaining += 3;
			gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 went to jail");
		}	
	}

}
