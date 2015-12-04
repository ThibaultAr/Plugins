package graphics;

import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import plugins.Tools;

public class ToolsMenu extends JMenu implements MenuListener {

	/**
	 * TODO serialize
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
			JMenuItem pluginItem = new JMenuItem(pluginFile);
			this.add(pluginItem);
			pluginItem.addActionListener(event -> {
				Window.textArea.setText(this.tools.getTransformMethod(pluginFile, Window.textArea.getText()));
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
