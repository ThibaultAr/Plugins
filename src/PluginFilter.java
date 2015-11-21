import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {

	protected Class<?> pluginInterface;

	public PluginFilter() {
		try {
			this.pluginInterface = Class.forName("plugins.Plugin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean accept(File dir, String name) {
		if (!PluginFilter.isClass(name))
			return false;
		try {
			String className = PluginFilter.getClassName(name);
			Class<?> plugin = Class.forName(className);
			plugin.isAssignableFrom(this.pluginInterface);
			plugin.newInstance();
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		} catch (InstantiationException e) {
			return false;
		} catch (IllegalAccessException e) {
			return false;
		}
	}

	/**
	 * 
	 * @param name
	 *            a file name
	 * @return true if the file have an extension .class, else false
	 */
	protected static boolean isClass(String name) {
		return name.endsWith(".class");
	}

	/**
	 * @param name
	 *            a file name with an extension .class
	 * @return a string of the type : "plugins.className"
	 */
	protected static String getClassName(String name) {
		return "plugins." + name.substring(0, name.length() - ".class".length());
	}

}
