package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PluginTest {
	
	protected Plugin testPlugin;
	
	@Before
	public void createPlugin() {
		this.testPlugin = new MockPlugin();
	}

	@Test
	public void transformTest() {
		assertEquals("Mock plugin",this.testPlugin.transform(""));
		assertEquals("Mock plugin",this.testPlugin.transform("hello"));
	}

	@Test
	public void getLabelTest() {
		assertEquals("Mock plugin",this.testPlugin.getLabel());
	}
}
