package textAdventureAssesment;

import java.util.Random;

public class Tile 
{
	private int xPos;
	private int yPos;
	private LandType landType;
	
	private Random r = new Random();
	
	public Tile(int x, int y)
	{
		this.xPos = x;
		this.yPos = y;
		landType = LandType.values()[r.nextInt(LandType.values().length - 1)];
	}
	
	public String toString()
	{
		String toReturn = "The land looks like a " + landType;
		return toReturn;
		
	}
	
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public LandType getLandType() {
		return landType;
	}

	public void setLandType(LandType landType) {
		this.landType = landType;
	}
}
