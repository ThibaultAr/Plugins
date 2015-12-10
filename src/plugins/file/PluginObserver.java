package plugins.file;

import java.io.File;
import java.util.Set;

/**
 * Abstract class plugin observer is in charge of "watching" the file to see if
 * any files has been added
 *
 */
public abstract class PluginObserver {

	/**
	 * constructs a plugin observer
	 * 
	 * @param pluginFinder
	 *            used to determinates which files are plugins
	 */
	public PluginObserver(PluginFinder pluginFinder) {
		this.subscribeAPluginFinder(pluginFinder);
	}

	/**
	 * Transmits to the plugin finder that files has been added to the directory
	 * 
	 * @param dir
	 *            directory containing the plugins
	 * @param added
	 *            name of the files that has been added
	 */
	public abstract void updateOnAddition(File dir, Set<String> added);

	/**
	 * Transmits to the plugin finder that files has been deleted
	 * 
	 * @param dir
	 *            directory containing the plugins
	 * @param deleted
	 *            name of the files that has been removed
	 */
	public abstract void updateOnDeletion(File dir, Set<String> deleted);

	/**
	 * Links the plugin observer to a plugin finder
	 * 
	 * @param finder
	 *            a plugin finder
	 */
	public void subscribeAPluginFinder(PluginFinder finder) {
		finder.subscribeAnObserver(this);
	}
}
