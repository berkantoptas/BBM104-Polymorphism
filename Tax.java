
public class Tax extends Square 
{
	/**
	 * Tax applyAction function.
	 */
	public void applyAction(GameData gameData)
	{
		if(gameData.currentTurn == 1)
		{
			gameData.p1Money -= 100;
			gameData.bankerMoney += 100;
			gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 paid Tax");
		}
		else
		{
			gameData.p2Money -= 100;
			gameData.bankerMoney += 100;
			gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 paid Tax");
		}
	}
}
