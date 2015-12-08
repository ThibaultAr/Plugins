package plugins;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public abstract class PluginObserverTest {
	
	public abstract PluginObserver createObserver(PluginFinder finder);
	
	@Test
	public void suscribeAPluginFinderTest() {
		PluginFinder finder = new PluginFinder(new MockFile());
		PluginObserver observer = this.createObserver(finder);
		
		assertTrue(finder.isObservedBy(observer));
	}

}
