import java.util.ArrayList;
import java.util.List;

public class GameData 
{
	public GameData()
	{
		chanceCardList = new String[6];
		communityChestCardList = new String[11];
		p1Money = 15000;
		p2Money = 15000;
		p1CurrentSquare = 0;
		p2CurrentSquare = 0;
		bankerMoney = 100000;
		p1RailRoadOwnCount = 0;
		p2RailRoadOwnCount = 0;
		
		nextChanceCardIndex = 0;
		nextCommunityCardIndex = 0;
		
		isPlayerPositionForceChanged = false;
		
		logList = new ArrayList<String>();
		haveList1 = new ArrayList<String>();
		haveList2 = new ArrayList<String>();
	}
	
	public int currentDice;
	public int currentTurn;
	
	public int p1Money;
	public int p1CurrentSquare;	
	public int p2Money;
	public int p2CurrentSquare;
	public int bankerMoney;
		
	//DATA WHO OWNS HOW MANY RAIL
	public int p1RailRoadOwnCount;
	public int p2RailRoadOwnCount;
		
	public boolean isGameFinished;
	
	public String[] chanceCardList;
	public int nextChanceCardIndex;
	public String[] communityChestCardList;
	public int nextCommunityCardIndex;
	
	public int p1JailRemaining;
	public int p2JailRemaining;
	
	public List<String> logList;
	public List<String> haveList1;
	public List<String> haveList2;
	
	public boolean isPlayerPositionForceChanged;
	
}
