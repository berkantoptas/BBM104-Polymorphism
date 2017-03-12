
public class CommunityChest extends Action 
{
	/**
	 * CommunityChest applyAction function.
	 */
	public void applyAction(GameData gameData)
	{
		/**
		 * Advance to Go (Collect $200)
		 */
		if(gameData.nextChanceCardIndex == 0)			//Advance to Go (Collect $200)
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1CurrentSquare = 0;
				gameData.p1Money += 200;
				gameData.bankerMoney -= 200;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Advance to Go (Collect $200)");
			}
			else
			{
				gameData.p2CurrentSquare = 0;
				gameData.p2Money += 200;
				gameData.bankerMoney -= 200;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Advance to Go (Collect $200)");
			}
		}
		/**
		 * Bank error in your favor - collect $75
		 */
		else if (gameData.nextChanceCardIndex == 1)	 	//Bank error in your favor - collect $75
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 75;
				gameData.bankerMoney -= 75;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Bank error in your favor - collect $75");
			}
			else
			{
				gameData.p2Money += 75;
				gameData.bankerMoney -= 75;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Bank error in your favor - collect $75");
			}
		}
		/**
		 * Doctor's fees - Pay $50
		 */
		else if (gameData.nextChanceCardIndex == 2)		//Doctor's fees - Pay $50
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money -= 50;
				gameData.bankerMoney += 50;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Doctor's fees - Pay $50");
			}
			else
			{
				gameData.p2Money -= 50;
				gameData.bankerMoney += 50;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Doctor's fees - Pay $50");
			}
		}
		/**
		 * It is your birthday Collect $10 from each player
		 */
		else if (gameData.nextChanceCardIndex == 3)		//It is your birthday Collect $10 from each player
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 10;
				gameData.p2Money -= 10;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw It is your birthday Collect $10 from each player");
			}
			else
			{
				gameData.p2Money += 10;
				gameData.p1Money -= 10;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw It is your birthday Collect $10 from each player");
			}
		}
		/**
		 * Grand Opera Night - collect $50 from every player for opening night seats
		 */
		else if (gameData.nextChanceCardIndex == 4)		//Grand Opera Night - collect $50 from every player for opening night seats
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 50;
				gameData.p2Money -= 50;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Grand Opera Night - collect $50 from every player for opening night seats");
			}
			else
			{
				gameData.p2Money += 50;
				gameData.p1Money -= 50;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Grand Opera Night - collect $50 from every player for opening night seats");
			}
		}
		/**
		 * Income Tax refund - collect $20
		 */
		else if (gameData.nextChanceCardIndex == 5)		//Income Tax refund - collect $20
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 20;
				gameData.bankerMoney -= 20;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Income Tax refund - collect $20");
			}
			else
			{
				gameData.p2Money += 20;
				gameData.bankerMoney -= 20;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Income Tax refund - collect $20");
			}
		}
		/**
		 * Life Insurance Matures - collect $100
		 */
		else if (gameData.nextChanceCardIndex == 6)		//Life Insurance Matures - collect $100
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 100;
				gameData.bankerMoney -= 100;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Life Insurance Matures - collect $100");
			}
			else
			{
				gameData.p2Money += 100;
				gameData.bankerMoney -= 100;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Life Insurance Matures - collect $100");
			}
		}
		/**
		 * Pay Hospital Fees of $100
		 */
		else if (gameData.nextChanceCardIndex == 7)		//Pay Hospital Fees of $100
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money -= 100;
				gameData.bankerMoney += 100;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Pay Hospital Fees of $100");
			}
			else
			{
				gameData.p2Money -= 100;
				gameData.bankerMoney += 100;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Pay Hospital Fees of $100");
			}
		}
		/**
		 * Pay School Fees of $50
		 */
		else if (gameData.nextChanceCardIndex == 8)		//Pay School Fees of $50
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money -= 50;
				gameData.bankerMoney += 50;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw Pay School Fees of $50");
			}
			else
			{
				gameData.p2Money -= 50;
				gameData.bankerMoney += 50;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw Pay School Fees of $50");
			}
		}
		/**
		 * You inherit $100
		 */
		else if (gameData.nextChanceCardIndex == 9)		//You inherit $100
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 100;
				gameData.bankerMoney -= 100;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw You inherit $100");
			}
			else
			{
				gameData.p2Money += 100;
				gameData.bankerMoney -= 100;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw You inherit $100");
			}
		}		
		/**
		 * From sale of stock you get $50
		 */
		else if (gameData.nextChanceCardIndex == 10)	//From sale of stock you get $50
		{
			if(gameData.currentTurn == 1)
			{
				gameData.p1Money += 50;
				gameData.bankerMoney -= 50;
				gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 draw From sale of stock you get $50");
			}
			else
			{
				gameData.p2Money += 50;
				gameData.bankerMoney -= 50;
				gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 draw From sale of stock you get $50");
			}
		}
		
		if(gameData.nextCommunityCardIndex == 10)
			gameData.nextCommunityCardIndex = 0;
		else
			gameData.nextCommunityCardIndex++;
		
	}
}
