
public class FreeParking extends Square 
{
	/**
	 * FreeParking applyAction function.
	 */
	public void applyAction(GameData gameData)
	{
		if(gameData.currentTurn == 1)
		{
			gameData.p1JailRemaining += 1;
			gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 is in Free Parking");
		}
		else
		{
			gameData.p2JailRemaining += 1;
			gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 is in Free Parking");
		}	
	}	
}
