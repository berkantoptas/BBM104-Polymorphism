import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Monopoly 
{	
	public Monopoly()
	{
		board = new Square[40];
		gameData = new GameData();
	}
	
	/**
	 * @param fileName
	 * 
	 * This function will read and parse property.json file 
	 */
	@SuppressWarnings("unchecked")
	public void parseProperties(String fileName)
	{
		//Json parser Object
		JSONParser parser = new JSONParser();
		//Our iterator to parse json data
		Iterator<JSONObject> iterator;
        //Points to current line in JSON file
		JSONObject currentLine;
		
		try 
		{
			Object obj = parser.parse(new FileReader(fileName));
			JSONObject propertiesRoot = (JSONObject) obj;

			JSONArray lands = (JSONArray) propertiesRoot.get("1");
			JSONArray railRoads = (JSONArray) propertiesRoot.get("2");
			JSONArray companies = (JSONArray) propertiesRoot.get("3");
					
			//PARSE LANDS
			iterator = lands.iterator();
			while(iterator.hasNext())
			{
				currentLine = iterator.next();
				
				Land tmpLand = new Land();
				tmpLand.propertyName = currentLine.get("name").toString();
				tmpLand.cost = Integer.parseInt(currentLine.get("cost").toString());
				tmpLand.ownedBy = 0;
				int whichBox = Integer.parseInt(currentLine.get("id").toString()) - 1;				
				board[whichBox] = tmpLand; 			
			}
						
			//PARSE RAIL ROADS
			iterator = railRoads.iterator();
			while(iterator.hasNext())
			{
				currentLine = iterator.next();
				
				RailRoad tmpRailRoad = new RailRoad();
				tmpRailRoad.propertyName = currentLine.get("name").toString();
				tmpRailRoad.cost = Integer.parseInt(currentLine.get("cost").toString());				
				int whichBox = Integer.parseInt(currentLine.get("id").toString()) - 1;			
				board[whichBox] = tmpRailRoad; 	
			}
			
			//PARSE COMPANIES
			iterator = companies.iterator();
			while(iterator.hasNext())
			{
				currentLine = iterator.next();
				
				Company tmpCompany = new Company();
				tmpCompany.propertyName = currentLine.get("name").toString();
				tmpCompany.cost = Integer.parseInt(currentLine.get("cost").toString());				
				int whichBox = Integer.parseInt(currentLine.get("id").toString()) - 1;	
				board[whichBox] = tmpCompany; 		
			}
		}
		catch(Exception e)
		{
			System.out.println("WE GOT ERROR DURING PARSE!!");
		}	
	}
	
	/**
	 * @param fileName
	 * 
	 * This function will read and parse list.json file
	 * (for chance cards)
	 */
	@SuppressWarnings("unchecked")
	public void parseChanceCards(String fileName)
	{
		//Json parser Object
		JSONParser parser = new JSONParser();
		//Our iterator to parse json data
		Iterator<JSONObject> iterator;
	       //Points to current line in JSON file
		JSONObject currentLine;
		
		try 
		{
			Object obj = parser.parse(new FileReader(fileName));
			JSONObject cardFileRoot1 = (JSONObject) obj;
			
			JSONArray chanceCards = (JSONArray) cardFileRoot1.get("chanceList");
				
			//PARSE CHANCE CARDS
			iterator = chanceCards.iterator();
			int i=0;
			while(iterator.hasNext())
			{
				currentLine = iterator.next();
				gameData.chanceCardList[i] = currentLine.get("item").toString();				
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println("WE GOT ERROR DURING PARSE!!");
		}
	}
	
	/**
	 * @param fileName
	 * 
	 * This function will read and parse list.json file
	 * (for communitychest cards)
	 */
	@SuppressWarnings("unchecked")
	public void parseCommunityChestCards(String fileName)
	{
		//Json parser Object
		JSONParser parser = new JSONParser();
		//Our iterator to parse json data
		Iterator<JSONObject> iterator;
        //Points to current line in JSON file
		JSONObject currentLine;
		
		try 
		{
			Object obj = parser.parse(new FileReader(fileName));
			JSONObject cardFileRoot2 = (JSONObject) obj;
		
			JSONArray communityChestCards = (JSONArray) cardFileRoot2.get("communityChestList");
			
			//PARSE COMMUNITY CHEST CARDS
			iterator = communityChestCards.iterator();
			int i=0;
			while(iterator.hasNext())
			{
				currentLine = iterator.next();
				gameData.communityChestCardList[i] = currentLine.get("item").toString();				
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println("WE GOT ERROR DURING PARSE!!");
		}
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 * 
	 * This function will read command.txt
	 */
	public String[] readCommandFile (String path)
	{
		try{
			int i=0;
			int length = Files.readAllLines(Paths.get(path)).size();
			String[] results = new String [length];
			for (String line : Files.readAllLines(Paths.get(path)))
				results[i++]=line;
			return results;
		}catch (IOException e)	{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This function will fill remaining squares at board with other classes objects
	 */
	public void fillRemainingSquares()
	{
		board[0] = new Go();
		board[2] = new CommunityChest();
		board[4] = new Tax();
		board[7] = new Chance();
		board[10] = new Jail();
		board[17] = new CommunityChest();
		board[20] = new FreeParking();
		board[22] = new Chance();
		board[30] = new GoToJail();
		board[33] = new CommunityChest();
		board[36] = new Chance();
		board[38] = new Tax();	
	}
	
	/**
	 * 
	 * @return
	 * playTurn() function
	 */
	public boolean playTurn()
	{	
		if(gameData.currentTurn == 1 && gameData.p1JailRemaining > 0)
		{		
			gameData.p1JailRemaining--;
			gameData.logList.add("Player 1\t" + gameData.currentDice + "\t" + (gameData.p1CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 1 in jail (count=" + (3 - gameData.p1JailRemaining) + ")");
			return false;
		}
		
		if(gameData.currentTurn == 2 && gameData.p2JailRemaining > 0)
		{
			gameData.p2JailRemaining--;
			gameData.logList.add("Player 2\t" + gameData.currentDice + "\t" + (gameData.p2CurrentSquare + 1) + "\t" + gameData.p1Money + "\t" + gameData.p2Money + "\tPlayer 2 in jail (count=)" + (3 - gameData.p2JailRemaining)+ ")");
			return false;
		}
		
		if(gameData.currentTurn == 1 && (gameData.p1CurrentSquare + gameData.currentDice) >= 40)
		{
			gameData.p1Money += 200;
			gameData.bankerMoney -= 200;			
			gameData.p1CurrentSquare -= 40;
//			System.out.println("P1 pass start line");
		}
		
		if(gameData.currentTurn == 2 && (gameData.p2CurrentSquare + gameData.currentDice) >= 40)
		{
			gameData.p2Money += 200;
			gameData.bankerMoney -= 200;			
			gameData.p2CurrentSquare -= 40;
//			System.out.println("P2 pass start line");
		}
		
		if(gameData.currentTurn == 1)
		{
			gameData.p1CurrentSquare += gameData.currentDice;
			board[gameData.p1CurrentSquare].applyAction(gameData);
			
			if(true == gameData.isPlayerPositionForceChanged)
			{
				board[gameData.p1CurrentSquare].applyAction(gameData);
				gameData.isPlayerPositionForceChanged = false;
			}
			
			
		}
		if(gameData.currentTurn == 2)
		{
			gameData.p2CurrentSquare += gameData.currentDice;
			board[gameData.p2CurrentSquare].applyAction(gameData);
			
			if(true == gameData.isPlayerPositionForceChanged)
			{
				board[gameData.p2CurrentSquare].applyAction(gameData);
				gameData.isPlayerPositionForceChanged = false;
			}			
		}
		
		if(true == gameData.isGameFinished)
		{
			return true;		
		}
		else
		{
			return false;
		}
		
		
		
	}
	
	/**
	 * 
	 * @param CommandFile
	 * 
	 * This function will run program with command.txt argument.
	 */
	public void runProgram(String CommandFile)
	{
		boolean isGameFinished = false;
		
		parseProperties("property.json");
		fillRemainingSquares();
		
		parseChanceCards("list.json");
		parseCommunityChestCards("list.json");
		
		String[] lines = readCommandFile(CommandFile);
		for (String line : lines)
		{
			String[] parts;
			parts=line.split(";");
			if(parts[0].equals("Player 1"))
			{
				//System.out.println("Player 1 turn  Dice: " + parts[1]);
				gameData.currentTurn = 1;
				gameData.currentDice = Integer.parseInt(parts[1]);
				isGameFinished = playTurn();
				if(isGameFinished == true)
				{
					show();
					return;
				}
			}
			else if(parts[0].equals("Player 2"))
			{
				//System.out.println("Player 2 turn Dice: " + parts[1]);
				gameData.currentTurn = 2;
				gameData.currentDice = Integer.parseInt(parts[1]);
				isGameFinished = playTurn();
				if(isGameFinished == true)
				{
					show();
					return;
				}
			}
			else
			{
				show();
			}
						
		}
		
		show();		
	}
	
	/**
	 * This function will create output.txt
	 * Then will write gamelogs to output.txt
	 */
	public void show()
	{
		FileWriter fw;
		try 
		{
			fw = new FileWriter("output.txt", true); 

			for(int k = 0 ; k < gameData.logList.size(); k++)
			{
				fw.write((gameData.logList.get(k)));
				fw.write(String.format("%n"));
			}
			fw.write(("-------------------------------------------------------------------------------"));
			fw.write(String.format("%n"));
			fw.write(("-------------------------------------------------------------------------------"));
			fw.write(String.format("%n"));
			gameData.logList.clear();		
			
			fw.write("Player 1" + "\t" + gameData.p1Money + "\t" + "have: ");
			for (int a=0;a<gameData.haveList1.size();a++)
			{
				fw.write(gameData.haveList1.get(a) + ", ");
			}
			fw.write(String.format("%n"));
			fw.write("Player 2" + "\t" + gameData.p2Money + "\t" + "have: ");
			for (int b=0;b<gameData.haveList2.size();b++)
			{
				fw.write(gameData.haveList2.get(b) + ", ");
			}
			fw.write(String.format("%n"));
			fw.write("Banker" + "\t" + gameData.bankerMoney);
			fw.write(String.format("%n"));
			if(gameData.p1Money > gameData.p2Money)
			{
				fw.write("Winner Player 1");
				fw.write(String.format("%n"));
			}
			else if(gameData.p2Money > gameData.p1Money)
			{
				fw.write("Winner Player 2");
				fw.write(String.format("%n"));
			}
			else
			{
				fw.write("Winner is both of them Player 1 - Player 2");
				fw.write(String.format("%n"));
			}
			fw.write(("-------------------------------------------------------------------------------"));
			fw.write(String.format("%n"));
			fw.write(("-------------------------------------------------------------------------------"));
			fw.write(String.format("%n"));
			fw.close();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Monopoly Game Contents
	private Square[] board;
	//Our players
	private GameData gameData;

	
}
