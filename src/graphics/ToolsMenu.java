package graphics;

import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import plugins.Tools;

public class ToolsMenu extends JMenu implements MenuListener {
	/**
	 * Class version, it is used to check if the server and client have the same
	 * version of this class
	 */
	private static final long serialVersionUID = -5667671380579196694L;
	protected Tools tools;

	public ToolsMenu(Tools tools) {
		super("Tools");
		this.tools = tools;
		this.addMenuListener(this);
	}

	@Override
	public void menuSelected(MenuEvent e) {
		Set<String> pluginFiles = this.tools.getPluginFiles();
		for (String pluginFile : pluginFiles) {
			String pluginLabel = this.tools.pluginLabel(pluginFile);
			JMenuItem pluginItem = new JMenuItem(pluginLabel);
			this.add(pluginItem);
			pluginItem.addActionListener(event -> {
				if (Window.textArea != null) {
					String text = Window.textArea.getText();
					text = this.tools.invokePluginTansformMethod(pluginFile, text);
					Window.textArea.setText(text);
				}
			});
		}
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		this.removeAll();
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		this.removeAll();
	}
}
