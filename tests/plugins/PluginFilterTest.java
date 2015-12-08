package plugins;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PluginFilterTest {

	@Test
	public void acceptTest() {
		PluginFilter pluginFilter = new PluginFilter();
		assertFalse(pluginFilter.accept(null, ".classtest"));
		assertFalse(pluginFilter.accept(null, "test.class"));
		assertFalse(pluginFilter.accept(null, "MockPrivatePlugin.class"));
		assertFalse(pluginFilter.accept(null, "MockNotNullaryConstructorPlugin.class"));
		assertFalse(pluginFilter.accept(null, "MockNotImplementsPlugin.class"));
		assertTrue(pluginFilter.accept(null, "MockPlugin.class"));
	}
}
