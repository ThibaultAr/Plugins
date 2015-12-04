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
	public void testSubcription(){
		PluginFinder finder = new PluginFinder(new MockFile());
		PluginObserver logger = new PluginLogger(new PluginFinder(null));
		
		assertFalse(finder.observers.contains(logger));
		
		finder.subscribeAnObserver(logger);
		
		assertTrue(finder.observers.contains(logger));
	}
}
