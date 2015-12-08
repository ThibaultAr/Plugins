package plugins;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Filename filter which selects the plugins. A plugin ends with '.class'.
 */
public class PluginFilter implements FilenameFilter {

	protected Class<Plugin> pluginInterface = plugins.Plugin.class;

	@Override
	public boolean accept(File dir, String name) {
		Plugin plugin = PluginInstantiation.getPluginInstance(dir, name);
		return !(plugin == null);
	}
}
