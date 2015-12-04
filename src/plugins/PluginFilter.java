package plugins;
import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {

	protected Class<Plugin> pluginInterface = plugins.Plugin.class;

	@Override
	public boolean accept(File dir, String name) {
		Plugin plugin = PluginInstantiation.getPluginInstance(dir, name);
		return !(plugin == null);
	}
}
