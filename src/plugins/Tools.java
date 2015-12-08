package plugins;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tools extends PluginObserver {
	
	protected Map<String, Plugin> plugins;
	
	public Tools(PluginFinder pluginFinder) {
		super(pluginFinder);
	}
	
	@Override
	public void updateOnAddition(File dir, Set<String> added) {
		if(this.plugins == null)
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

	public String invokePluginTansformMethod(String pluginFile, String text) {
		Plugin plugin = this.plugins.get(pluginFile);
		return plugin.transform(text);
	}

	public String pluginLabel(String pluginFile) {
		Plugin plugin = this.plugins.get(pluginFile);
		return plugin.getLabel();
	}
}
