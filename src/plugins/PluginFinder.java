package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Timer;

/**
 * Action listener which finds all the plugins in a directory.
 *
 */
public class PluginFinder implements ActionListener {

	protected PluginFilter filter = new PluginFilter();
	protected File directory;
	protected Set<String> plugins = new HashSet<String>();
	protected List<PluginObserver> observers = new ArrayList<PluginObserver>();
	protected Timer timer;

	/**
	 * constructs a plugin finder
	 * 
	 * @param directory
	 *            in which the plugins will be searched
	 */
	public PluginFinder(File directory) {
		this.directory = directory;
		this.timer = new Timer(1000, this);
		this.timer.start();
	}

	/**
	 * @return an array containing the name of the files, as String, considered
	 *         as plugins
	 */
	public String[] acceptedFiles() {
		return this.directory.list(this.filter);
	}

	/**
	 * Update the plugins which can be use depending if they're still in the
	 * directory or not
	 * 
	 * @param dir
	 *            the directory containing the plugins
	 * @param added
	 *            the plugins that has been added
	 * @param deleted
	 *            the one that has been deleted
	 */
	protected void updateObservers(File dir, Set<String> added, Set<String> deleted) {
		// creation of a copy in case the observers's list updates during the
		// for loop
		List<PluginObserver> observersToUpdate = new ArrayList<PluginObserver>(this.observers);
		for (PluginObserver observer : observersToUpdate) {
			observer.updateOnDeletion(dir, deleted);
			observer.updateOnAddition(dir, added);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> newDirComposition = Arrays.asList(this.acceptedFiles());
		Set<String> added = new HashSet<String>();
		Set<String> deleted = new HashSet<String>();

		for (String plugin : this.plugins)
			if (!newDirComposition.contains(plugin))
				deleted.add(plugin);

		for (String plugin : newDirComposition)
			if (!this.plugins.contains(plugin))
				added.add(plugin);

		this.plugins.removeAll(deleted);
		this.plugins.addAll(added);

		this.updateObservers(this.directory, added, deleted);
	}

	/**
	 * Sucribes a Plugin observer to this plugin finder For more information
	 * please check the Plugin observer documentation
	 * 
	 * @param observer
	 *            to subscribe
	 */
	public void subscribeAnObserver(PluginObserver observer) {
		this.observers.add(observer);
		// Creation of a copy in case the plugins's list is updated during the
		// observer's execution

		Set<String> pluginsCopy = new HashSet<>(this.plugins);
		observer.updateOnAddition(this.directory, pluginsCopy);
	}

	protected boolean isObservedBy(PluginObserver observer) {
		return this.observers.contains(observer);
	}
}
