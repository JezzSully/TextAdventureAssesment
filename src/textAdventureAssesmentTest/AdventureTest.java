package textAdventureAssesmentTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import textAdventureAssesment.Adventure;
import textAdventureAssesment.Interest;

public class AdventureTest 
{
	Adventure testAdventure = new Adventure(12,12);
	
	public void setUp()
	{
		List<Interest> testInterests = new ArrayList<Interest>();
		Interest testInterest = new Interest(15,12);
		Interest tesstInterest2 = new Interest(25,25, "Who would live in a place like this.");
		testInterests.add(testInterest);
		testInterests.add(tesstInterest2);
		testAdventure.setInterests(testInterests);
	}
	
	public void tearDown()
	{
		testAdventure = new Adventure(12,12);
	}
	
	@Test
	public void findNearestInterestDistTest1()
	{
		setUp();
		
		double expected = 3.0;
		double actual = testAdventure.findNearestInterestDist();
		
		//assertTrue("",expected.equals(actual)); //????????????HALP
		
		tearDown();
	}
}
