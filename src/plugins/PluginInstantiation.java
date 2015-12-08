package plugins;

import java.io.File;

/**
 * 
 *
 */
public class PluginInstantiation {

	protected static Class<Plugin> pluginInterface = plugins.Plugin.class;

	private PluginInstantiation() {
	}

	/**
	 * TODO comment
	 * 
	 * @param dir
	 * @param name
	 * @return a plugin's instance, else null
	 */
	public static Plugin getPluginInstance(File dir, String name) {
		if (!PluginInstantiation.isClass(name))
			return null;
		
		try {
			String className = PluginInstantiation.getClassName(name);
			Class<?> maybePlugin = Class.forName(className);
			
			if (!(PluginInstantiation.pluginInterface).isAssignableFrom(maybePlugin))
				return null;
			
			Class<? extends Plugin> plugin = maybePlugin.asSubclass(PluginInstantiation.pluginInterface);
			return plugin.newInstance();
		} 
		catch (ClassNotFoundException e) {
			return null;
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}

	/**
	 * @param name
	 *            a file name
	 * @return true if the file have an extension .class, else false
	 */
	private static boolean isClass(String name) {
		return name.endsWith(".class");
	}

	/**
	 * @param name
	 *            a file name with an extension .class
	 * @return a string of the type : "plugins.className"
	 */
	private static String getClassName(String name) {
		return "plugins." + name.substring(0, name.length() - ".class".length());
	}
}
