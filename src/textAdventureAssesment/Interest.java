package textAdventureAssesment;

import java.util.Random;

public class Interest 
{
	private String description;
	
	private int xPosition;
	private int yPosition;
	
	Random r = new Random();
	
	int BARRENSIZE = 25;
	
	public Interest()
	{
		this.xPosition = r.nextInt(BARRENSIZE);
		this.yPosition = r.nextInt(BARRENSIZE);
		this.description = "Well this area is interesting";
	}
	
	public Interest(String description)
	{
		this.xPosition = r.nextInt(BARRENSIZE);
		this.yPosition = r.nextInt(BARRENSIZE);
		this.description = description;
	}
	
	public Interest(int x, int y)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.description = "Well this area is interesting";
	}
	
	public Interest(int x, int y, String description)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		String toPrint = "X: " + this.xPosition + " Y: " + this.yPosition;
		toPrint = toPrint + ". " + this.description;
		return toPrint;
	}
	
	//Getters and Setters
 	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}	
}
