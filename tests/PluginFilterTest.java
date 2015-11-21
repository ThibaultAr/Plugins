import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PluginFilterTest {

	@Test
	public void acceptTest() {
		PluginFilter pluginFilter = new PluginFilter();
		assertTrue(pluginFilter.accept(null, ".class"));
		assertTrue(pluginFilter.accept(null, "test.class"));
		assertFalse(pluginFilter.accept(null, ".classtest"));
		assertFalse(pluginFilter.accept(null, "te.classst"));
		assertFalse(pluginFilter.accept(null, ".clas"));
		assertFalse(pluginFilter.accept(null, "class"));
	}
}
