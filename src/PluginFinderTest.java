import java.util.Arrays;

import org.junit.Test;


public class PluginFinderTest {
	
	@Test
	public void accpetedPathsTest() {
		PluginFinder pluginFinder = new PluginFinder(new MockFile());
		String[] acceptedPaths = pluginFinder.accpetedPaths();
		String expectedPaths[] = {"hello.class", ".class"};
		Arrays.sort(expectedPaths);
		Arrays.sort(acceptedPaths);
		// TODO assert foreach
	}
}
