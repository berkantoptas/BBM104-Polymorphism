import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main 
{	
	/**
	 * 
	 * @param args
	 * args[0] = command.txt
	 */
	public static void main(String[] args)
	{	
		//args[0] -> command.txt	
		Monopoly myGame = new Monopoly();	
		myGame.runProgram(args[0]);		
	}
}
