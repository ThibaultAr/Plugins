package plugins.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JMenuBar;

import org.junit.Test;

public class PluginFrameTest {

	@Test
	public void jMenuBarTest() {
		PluginFrame pluginFrame = new PluginFrame("");
		JMenuBar jMenuBar = pluginFrame.getJMenuBar();
		assertNotNull(jMenuBar);
		assertEquals("File", jMenuBar.getMenu(0).getText());
		assertEquals("Tools", jMenuBar.getMenu(1).getText());
		assertEquals("Help", jMenuBar.getMenu(2).getText());
	}
}
