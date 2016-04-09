package Test.TestHelper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Test.*;


@RunWith(Suite.class)
@SuiteClasses({ 
	tClock.class,
	tBuilding.class, 
	tIsland.class,
	tLumberer.class,
	tStorage.class,
	tWorkingBuilding.class,
	tTransportTask.class
	})
public class TestSuite {

}
