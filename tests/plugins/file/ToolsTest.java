package plugins.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import plugins.file.PluginFinder;
import plugins.file.PluginObserver;
import plugins.file.Tools;

public class ToolsTest extends PluginObserverTest {

	@Test
	public void invokePluginTansformMethodTest() {
		MockPluginFinder pluginFinder = new MockPluginFinder();
		Tools tools = new Tools(pluginFinder);

		tools.updateOnAddition(null, pluginFinder.plugins);
		
		String transform = tools.invokePluginTansformMethod("MockPlugin.class", "blabla");
		assertEquals("Mock plugin", transform);
	}

	@Test
	public void updateOnDeletionTest() {
		MockPluginFinder pluginFinder = new MockPluginFinder();
		Tools tools = new Tools(pluginFinder);

		tools.updateOnAddition(null, pluginFinder.plugins);
		
		assertTrue(tools.plugins.containsKey("MockPlugin.class"));

		Set<String> deleted = new HashSet<String>();
		deleted.add("MockPlugin.class");
		tools.updateOnDeletion(null, deleted);

		assertFalse(tools.plugins.containsKey("MockPlugin.class"));
	}

	// updateOnAddition is tested too when subscription is called
	@Test
	public void updateOnAdditionTest() {
		MockPluginFinder finder = new MockPluginFinder();
		Tools tools = new Tools(finder);

		assertTrue(tools.plugins.isEmpty());

		tools.updateOnAddition(null, finder.plugins);

		assertTrue(tools.plugins.containsKey("MockPlugin.class"));
	}

	@Test
	public void pluginLabelTest() {
		MockPluginFinder finder = new MockPluginFinder();
		Tools tools = new Tools(finder);
		
		tools.updateOnAddition(null, finder.plugins);
		assertEquals("Mock plugin", tools.pluginLabel("MockPlugin.class"));
	}

	@Override
	public PluginObserver createObserver(PluginFinder finder) {
		return new Tools(finder);
	}

}
