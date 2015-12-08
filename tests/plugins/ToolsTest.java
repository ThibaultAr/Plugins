package plugins;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ToolsTest extends PluginObserverTest {

	@Test
	public void invokePluginTansformMethodTest() {
		MockFile mockFile = new MockFile();
		PluginFinder pluginFinder = new PluginFinder(mockFile);
		Tools tools = new Tools(pluginFinder);

		String transform = tools.invokePluginTansformMethod("MockPlugin.class", "blabla");
		assertEquals("Mock plugin", transform);
	}

	@Test
	public void updateOnDeletionTest() {
		MockFile mockFile = new MockFile();
		PluginFinder pluginFinder = new PluginFinder(mockFile);
		Tools tools = new Tools(pluginFinder);

		assertFalse(tools.plugins.isEmpty());
		assertTrue(tools.plugins.containsKey("MockPlugin.class"));
		assertTrue(pluginFinder.plugins.contains("MockPlugin.class"));

		Set<String> deleted = new HashSet<String>();
		deleted.add("MockPlugin.class");
		tools.updateOnDeletion(null, deleted);

		assertFalse(tools.plugins.containsKey("MockPlugin.class"));
	}

	// updateOnAddition is tested too when subscription is called
	@Test
	public void testAddition() {
		PluginFinder emptyFinder = new PluginFinder(new MockEmptyFile());
		PluginFinder finder = new PluginFinder(new MockFile());
		Tools tools = new Tools(emptyFinder);

		assertTrue(tools.plugins.isEmpty());

		tools.subscribeAPluginFinder(finder);

		assertTrue(finder.isObservedBy(tools));
		assertTrue(tools.plugins.containsKey("MockPlugin.class"));
	}

	@Test
	public void pluginLabelTest() {
		MockFile mockFile = new MockFile();
		PluginFinder finder = new PluginFinder(mockFile);
		Tools tools = new Tools(finder);

		assertEquals("Mock plugin", tools.pluginLabel("MockPlugin.class"));
	}

	@Override
	public PluginObserver createObserver(PluginFinder finder) {
		return new Tools(finder);
	}

}
