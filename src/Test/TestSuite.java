package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	tBuilding.class, 
	tIsland.class,
	tLumberer.class,
	tStorage.class,
	tProducingBuilding.class})
public class TestSuite {

}
