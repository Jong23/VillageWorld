package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import helpers.Clock;

public class tClock {

	@Test
	public void test() {
		try {
			Clock clock = Clock.getInstance();
			Thread.sleep(1050);
			assertTrue(900 <= clock.getTime());
			assertTrue(1100 >= clock.getTime());
			clock = Clock.getInstance();
			assertTrue(900 <= clock.getTime());
			assertTrue(1100 >= clock.getTime());
			
			
			clock = new Clock();
			clock.setSpeed(5);
			Thread.sleep(1050);
			assertTrue(4900 <= clock.getTime());
			assertTrue(5100 >= clock.getTime());
			
			clock = new Clock();
			clock.setSpeed(2);
			Thread.sleep(1050);
			assertTrue(1900 <= clock.getTime());
			assertTrue(2100 >= clock.getTime());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
