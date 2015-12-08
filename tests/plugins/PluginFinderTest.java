package plugins;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;


public class PluginFinderTest {
	
	@Test
	public void acceptedFilesTest() {
		PluginFinder pluginFinder = new PluginFinder(new MockFile());
		String[] acceptedFiles = pluginFinder.acceptedFiles();
		String expectedFiles[] = { "MockPlugin.class" };
		Arrays.sort(expectedFiles);
		Arrays.sort(acceptedFiles);
		int nExpectedFiles = expectedFiles.length;
		assertEquals(nExpectedFiles, acceptedFiles.length);
		for (int i = 0; i < nExpectedFiles; i++) {
			assertEquals(expectedFiles[i], acceptedFiles[i]);
		}
	}
	
	@Test
	public void testObserverShouldSubscribeWhenInstanciate(){
		PluginFinder finder = new PluginFinder(new MockFile());
		
		assertTrue(finder.observers.isEmpty());
		
		PluginObserver logger = new PluginLogger(finder);
		finder.subscribeAnObserver(logger);
		
		assertTrue(finder.observers.contains(logger));
	}
	
	@Test
	public void testSubcription(){
		PluginFinder finder = new PluginFinder(new MockFile());
		PluginObserver logger = new PluginLogger(new PluginFinder(new MockEmptyFile()));
		
		assertFalse(finder.observers.contains(logger));
		
		finder.subscribeAnObserver(logger);
		
		assertTrue(finder.observers.contains(logger));
	}
	
	@Test
	public void testUpdateObservers(){
		PluginFinder finder = new PluginFinder(new MockFile());
		MockPluginObserver observer = new MockPluginObserver(finder);
		
		assertFalse(observer.passageInUpdateAddition);
		assertFalse(observer.passageInUpdateDeletion);
		
		finder.updateObservers(null, null, null);
		
		assertTrue(observer.passageInUpdateAddition);
		assertTrue(observer.passageInUpdateDeletion);	
	}
	
	@Test
	public void actionPerformedTest() {
		PluginFinder finder = new PluginFinder(new MockFile());
		finder.timer.stop();
		finder.plugins.clear();
		
		assertTrue(finder.plugins.isEmpty());
		
		finder.actionPerformed(null);
		
		assertEquals(1, finder.plugins.size());
		assertTrue(finder.plugins.contains("MockPlugin.class"));
		
		finder.plugins.add("Test.class");
		
		assertEquals(2, finder.plugins.size());
		assertTrue(finder.plugins.contains("Test.class"));
		
		finder.actionPerformed(null);
		
		assertEquals(1, finder.plugins.size());
		assertTrue(finder.plugins.contains("MockPlugin.class"));
	}
}
