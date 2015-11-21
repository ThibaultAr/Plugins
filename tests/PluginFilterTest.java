import static org.junit.Assert.assertEquals;
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
		assertTrue(pluginFilter.accept(null, "MockPlugin.class"));
	}
	
	@Test
	public void isClassTest() {
		assertTrue(PluginFilter.isClass(".class"));
		assertTrue(PluginFilter.isClass("test.class"));
		assertFalse(PluginFilter.isClass(".classtest"));
		assertFalse(PluginFilter.isClass("te.classst"));
		assertFalse(PluginFilter.isClass(".clas"));
		assertFalse(PluginFilter.isClass("class"));
	}

	@Test
	public void getClassNameTest() {
		assertEquals("plugins.", PluginFilter.getClassName(".class"));
		assertEquals("plugins.test", PluginFilter.getClassName("test.class"));
	}
}
