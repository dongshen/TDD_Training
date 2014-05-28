package conway_game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testGenerateArea {
	
	conway_game game;
	int x;
	int y;
	@Before
	public void setUp() throws Exception {
		game = new conway_game();
		x = 3;
		y = 3;
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void testAreaSizeX() {
		int[][] areafield = game.GenerateArea( x,  y);
		org.junit.Assert.assertEquals(x, areafield.length);

	}
	
	@Test
	public void testAreaSizeY() {

		int[][] areafield = game.GenerateArea( x,  y);
		org.junit.Assert.assertEquals(y, areafield[0].length);

	}

	@Test
	public void testInitalVuale0() {

		
		int[][] areafield ={{0,0,0},{0,1,1},{0,0,1}};

		game.setValue(areafield);
		
		String result = game.PrintArea();
		org.junit.Assert.assertEquals("(0,0)=0(0,1)=0(0,2)=0\n(1,0)=0(1,1)=1(1,2)=1\n(2,0)=0(2,1)=0(2,2)=1\n", result);

		org.junit.Assert.assertEquals(0, game.getCell(0,0));
	}
	
	@Test
	public void testNeighborStatus() {
	
		int[][] areafield ={{0,0,0},{0,1,1},{0,0,1}};

		game.setValue(areafield);
		
		int result = game.checkNeighborStatus(1,1);
		
		org.junit.Assert.assertEquals(2, result);
	}
	
	@Test
	public void testNeighborStatus1() {
	
		int[][] areafield ={{0,0,0},{0,1,1},{0,0,1}};

		game.setValue(areafield);
		
		int result = game.checkNeighborStatus(0,0);
		
		org.junit.Assert.assertEquals(1, result);
	}
	
	@Test
	public void testNeighborStatus2() {
	
		int[][] areafield ={{0,0,0},{0,1,1},{0,0,1}};

		game.setValue(areafield);
		
		int result = game.checkNeighborStatus(2,2);
		
		org.junit.Assert.assertEquals(2, result);
	}
	
	@Test
	public void testLiveOrDead_SelfLive_live2_live() {
	

		int[][] areafield ={{0,0,0},{0,1,1},{0,0,1}};

		game.setValue(areafield);
		
		int result = game.LiveOrDead(1,1);
		
		org.junit.Assert.assertEquals(1, result);
	}
	
	@Test
	public void testLiveOrDead_SelfLive_live3_live() {
	
		int[][] areafield ={{0,0,1},{0,1,1},{0,0,1}};

		game.setValue(areafield);

		int result = game.LiveOrDead(1,1);
		
		org.junit.Assert.assertEquals(1, result);
	}
	
	@Test
	public void testLiveOrDead_SelfLive_liveless2_dead() {
	

		
		int[][] areafield ={{0,0,1},{0,1,0},{0,0,0}};

		game.setValue(areafield);
		int result = game.LiveOrDead(1,1);
		
		org.junit.Assert.assertEquals(0, result);
	}
	
	@Test
	public void testLiveOrDead_SelfLive_liveMorethan3_dead() {
	

		int[][] areafield ={{0,0,1},{0,1,1},{1,0,1}};

		game.setValue(areafield);
		int result = game.LiveOrDead(1,1);
		
		org.junit.Assert.assertEquals(0, result);
	}
	
	@Test
	public void testLiveOrDead_SelfDead_live3_live() {
	

		int[][] areafield ={{0,0,1},{0,0,1},{0,0,1}};

		game.setValue(areafield);
		int result = game.LiveOrDead(1,1);
		
		org.junit.Assert.assertEquals(1, result);
	}
	
	@Test
	public void testLiveOrDead_SelfDead_livenot3_dead() {
	
		int[][] areafield ={{1,0,1},{0,0,1},{0,0,1}};

		game.setValue(areafield);
		int result = game.LiveOrDead(1,1);
		
		org.junit.Assert.assertEquals(0, result);
	}
	
	@Test
	public void testSetNextValue_dead() {
	
		int[][] areafield ={{1,0,1},{0,0,1},{0,0,1}};
		game.setValue(areafield);
		
		game.setNextValue(1,1,1);
		
		org.junit.Assert.assertEquals(1, game.getNextValue(1,1));
	}
	
	@Test
	public void testGenerateNext() {
	
		int[][] areafield ={{0,0,0},
				            {0,1,1},
				            {0,0,1}};
		//expect value
		//{0,0,0}
		//{0,1,1}
		//{0,1,1}
		game.setValue(areafield);
		
		game.GenerateNext();
		String result = game.PrintGenerateNext();
		org.junit.Assert.assertEquals("(0,0)=0(0,1)=0(0,2)=0\n(1,0)=0(1,1)=1(1,2)=1\n(2,0)=0(2,1)=1(2,2)=1\n", result);
	}
}
