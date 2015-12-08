package plugins;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public abstract class PluginObserverTest {
	
	PluginObserver testObserver;
	PluginFinder testFinder;
	
	
	public abstract PluginObserver createObserver(PluginFinder finder);

	@Before
	public void initialize() {
		this.testFinder = new PluginFinder(new MockFile());
		this.testObserver = this.createObserver(this.testFinder);
	}
	
	
	@Test
	public void suscribeAPluginFinderTest() { 
		assertTrue(this.testFinder.isObservedBy(this.testObserver));
	}


}
