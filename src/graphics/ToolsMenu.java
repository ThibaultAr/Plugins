package graphics;

import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
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
	protected JTextArea textArea;

	public ToolsMenu(Tools tools, JTextArea textArea) {
		super("Tools");
	    this.tools = tools;
		this.textArea = textArea;
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
				String text = this.textArea.getText();
				text = this.tools.invokePluginTansformMethod(pluginFile, text);
				this.textArea.setText(text);
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
