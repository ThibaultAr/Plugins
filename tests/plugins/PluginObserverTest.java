package plugins;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class PluginObserverTest {
	
	MockPluginObserver testObserver;
	PluginFinder testFinder;
	MockFile testFile;
	
	@Before
	public void createObserver() {
		this.testFile = new MockFile();
		this.testFinder = new PluginFinder(this.testFile);
		this.testObserver = new MockPluginObserver(testFinder);
	}

	@Test
	//updateOnAddition is tested here as subsribeAPluginFinder calls this method
	public void suscribeAPluginFinderTest() { 
		assertFalse(this.testObserver.getPassageOnDeletion());
		testObserver.subscribeAPluginFinder(this.testFinder);
		assertTrue(this.testObserver.getPassageOnAddition());
	}
	
	@Test
	public void updateOnDeletionTest() {
		assertFalse(this.testObserver.getPassageOnDeletion());
		testObserver.updateOnDeletion(this.testFile,new HashSet<String>() );
		assertTrue(this.testObserver.getPassageOnDeletion());
	}

}
