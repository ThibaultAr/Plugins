package plugins;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class PluginInstantiationTest {

	@Test
	public void acceptTest() {
		assertNull(PluginInstantiation.getPluginInstance(null, ".classtest"));
		assertNull(PluginInstantiation.getPluginInstance(null, "test.class"));
		assertNull(PluginInstantiation.getPluginInstance(null, "MockPrivatePlugin.class"));
		assertNull(PluginInstantiation.getPluginInstance(null, "MockNotNullaryConstructorPlugin.class"));
		assertNull(PluginInstantiation.getPluginInstance(null, "MockNotImplementsPlugin.class"));
		assertNotNull(PluginInstantiation.getPluginInstance(null, "MockPlugin.class"));
	}
}
