package plugins.editor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ToolsMenuTest {

	@Test
	public void menuSelectedTest() {
		ToolsMenu toolsMenu = new ToolsMenu(new MockTools(), null);

		assertEquals(0, toolsMenu.getItemCount());

		toolsMenu.menuSelected(null);

		assertEquals(1, toolsMenu.getItemCount());
		assertEquals("Mock plugin", toolsMenu.getItem(0).getText());
	}

	@Test
	public void menuDeselectedTest() {
		ToolsMenu toolsMenu = new ToolsMenu(new MockTools(), null);

		assertEquals(0, toolsMenu.getItemCount());

		toolsMenu.menuSelected(null);

		assertEquals(1, toolsMenu.getItemCount());

		toolsMenu.menuDeselected(null);

		assertEquals(0, toolsMenu.getItemCount());
	}

	@Test
	public void menuCanceledTest() {
		ToolsMenu toolsMenu = new ToolsMenu(new MockTools(), null);

		assertEquals(0, toolsMenu.getItemCount());

		toolsMenu.menuSelected(null);

		assertEquals(1, toolsMenu.getItemCount());

		toolsMenu.menuCanceled(null);

		assertEquals(0, toolsMenu.getItemCount());
	}
}
