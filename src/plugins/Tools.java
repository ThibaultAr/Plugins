package plugins;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tools extends PluginObserver {
	
	protected Map<String, Plugin> plugins;
	
	public Tools(PluginFinder pluginFinder) {
		super(pluginFinder);
		this.plugins = new HashMap<String,Plugin>();
	}

	@Override
	public void updateOnAddition(File dir, Set<String> added) {
		for (String pluginFile : added) {
			String className = PluginFilter.getClassName(pluginFile);
			try {
				Class<?> plugin = Class.forName(className);
				Plugin pluginInstance = (Plugin) plugin.newInstance();
				this.plugins.put(pluginFile, pluginInstance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
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

	public String getTransformMethod(String pluginFile, String textArea) {
		Plugin plugin = this.plugins.get(pluginFile);
		return plugin.transform(textArea);
	}
}
