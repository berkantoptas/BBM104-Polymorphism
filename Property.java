
public abstract class Property extends Square 
{
	public String propertyName;
	public int cost;	
	//0-> bosta 1-> player1 in mali  2-> player2 nin mali
	public int ownedBy;

	/**
	 * Abstract function.
	 */
	public abstract void applyAction(GameData gameData);	
}
