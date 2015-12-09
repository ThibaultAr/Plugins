package plugins;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *	Tools is an observer in charge of watching the plugins available from the tools menu and add or delete them 
 */
public class Tools extends PluginObserver {

	protected Map<String, Plugin> plugins;

	public Tools(PluginFinder pluginFinder) {
		super(pluginFinder);
		if (this.plugins == null)
			this.plugins = new HashMap<String, Plugin>();
	}

	@Override
	public void updateOnAddition(File dir, Set<String> added) {
		if (this.plugins == null)
			this.plugins = new HashMap<String, Plugin>();

		for (String pluginFile : added) {
			Plugin plugin = PluginInstantiation.getPluginInstance(dir, pluginFile);
			if (plugin == null)
				throw new IllegalStateException("we just checked PluginFilter.accept()");
			this.plugins.put(pluginFile, plugin);
		}
	}

	@Override
	public void updateOnDeletion(File dir, Set<String> deleted) {
		for (String pluginFile : deleted) {
			this.plugins.remove(pluginFile);
		}
	}

	public Set<String> getPluginFiles() {
		return this.plugins.keySet();
	}

	/**
	 * 
	 * @param pluginFile
	 * @param text
	 * 		inside the text area
	 * @return
	 * 		the text transformed by the plugin
	 */
	public String invokePluginTansformMethod(String pluginFile, String text) {
		Plugin plugin = this.plugins.get(pluginFile);
		return plugin.transform(text);
	}

	/**
	 * 
	 * @return
	 * 		the label of the plugin
	 */
	public String pluginLabel(String pluginFile) {
		Plugin plugin = this.plugins.get(pluginFile);
		return plugin.getLabel();
	}
}
