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


public class PluginFinder implements ActionListener {

	protected PluginFilter filter = new PluginFilter();
	protected File directory;
	protected Set<String> plugins = new HashSet<String>();
	protected List<PluginObserver> observers = new ArrayList<PluginObserver>();
	protected Timer timer;

	public PluginFinder(File directory) {
		this.directory = directory;
		this.timer = new Timer(1000, this);
		this.timer.start();
	}

	public String[] acceptedFiles() {
		return this.directory.list(this.filter);
	}

	protected void updateObservers(File dir, Set<String> added, Set<String> deleted) {
		// we create a copy because if the observers's list is update during the
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

	public void subscribeAnObserver(PluginObserver observer){
		this.observers.add(observer);
		// we create a copy because if the plugins's list is update during the
		// execution in the observer
		Set<String> pluginsCopy = new HashSet<>(this.plugins);
		observer.updateOnAddition(this.directory, pluginsCopy);
	}
	
}
