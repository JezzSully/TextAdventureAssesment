package textAdventureAssesment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Adventure 
{
	private int playerXPosition;
	private int playerYPosition;
	int BARRENSIZE = 25;
	
	private Scanner scan = new Scanner(System.in);
	
	private List<Interest> interests = new ArrayList<Interest>();
	
	Random r = new Random();
	
	public Adventure()
	{
		this.playerXPosition = r.nextInt(BARRENSIZE);
		this.playerYPosition = r.nextInt(BARRENSIZE);
	}
	
	public Adventure(int x, int y)
	{
		this.playerXPosition = x;
		this.playerYPosition = y;
	}
	
	public Adventure(List<Interest> interests)
	{
		this.playerXPosition = r.nextInt(BARRENSIZE);
		this.playerYPosition = r.nextInt(BARRENSIZE);
		this.interests = interests;
	}
	
	public Adventure(int x, int y, List<Interest> interests)
	{
		this.playerXPosition = x;
		this.playerYPosition = y;
		this.interests = interests;
	}
	
	public void begin()
	{
		//Print all cool intro stuff
		System.out.println("You find yourself in a shack. good luck.");
		System.out.println("");
		loadInterestsFromFile();
		checkNewSurroundings();
	}
	
	public void loadInterestsFromFile()
	{
		//Apologies for hard coded file.
		
		String file = "C:\\Users\\Admin\\Documents\\interests.txt";
		try
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String text = br.readLine();
			while(text != null)
			{

				String[] textInParts = text.split("\\|");
				
				if(textInParts.length == 1)
				{
					Interest currInterest = new Interest(text);
					interests.add(currInterest);
				}
				else if(textInParts.length > 1)
				{
					String description = textInParts[0];
					int xpos = Integer.parseInt(textInParts[1]);
					int ypos = Integer.parseInt(textInParts[2]);
					Interest currInterest = new Interest(xpos,ypos,description);
					interests.add(currInterest);
				}
				text = br.readLine();
			}
			br.close();
		} catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public void checkNewSurroundings()
	{
		List<Interest> interestsInMyArea = interests.stream()
				.filter(i -> i.getxPosition() == playerXPosition)
				.filter(i -> i.getyPosition() == playerYPosition)
				.collect(Collectors.toList());
		
		if(interestsInMyArea.size() > 0)
		{
			for(Interest i : interestsInMyArea)
			{
				System.out.println(i.getDescription());
				interests.remove(i);
			}
			//TODO add a small system wait when finding Interests
		}
		
		double closest = findNearestInterestDist();
		
		System.out.println("Compass reads " + closest);
		
		awaitDirections();
	}
	
	public void awaitDirections()
	{
		System.out.print("> ");
		
		String movement = scan.nextLine();
		move(movement);
	}
	
	public void move(String movement)
	{
		switch(movement.toLowerCase()) 
		{
			//TODO accept single letters
			case "north":
				playerYPosition++;
				break;
			case "east":
				playerXPosition++;
				break;
			case "south":
				playerYPosition--;
				break;
			case "west":
				playerXPosition--;
				break;
			case "look":
				System.out.println("Well it's pretty barren around here.");
			default:
				System.out.println("Incorrect movement");
		}
		checkNewSurroundings();
	}
	
	public double findNearestInterestDist()
	{
		double closest = 1000000.0;
		for(Interest i : interests)
		{
			int xdis = Math.abs(i.getxPosition() - playerXPosition);
			int ydis = Math.abs(i.getyPosition() - playerYPosition);
			double dist = Math.sqrt((xdis * xdis) + (ydis + ydis));
			
			if(dist < closest)
			{
				closest = dist;
			}
		}
		return closest;
	}

	public List<Interest> getInterests()
	{
		return this.interests;
	}

	public void setInterests(List<Interest> interests)
	{
		this.interests = interests;
	}
}
