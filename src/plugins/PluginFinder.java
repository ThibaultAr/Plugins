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

	private void updateObservers(File dir, Set<String> added,
			Set<String> deleted) {
		List<PluginObserver> observersToUpdate = new ArrayList<PluginObserver>();
		observersToUpdate.addAll(this.observers);
		for (PluginObserver observer : observersToUpdate) {
			observer.updateOnAddition(dir, added);
			observer.updateOnDeletion(dir, added);
		}
	}

	// TODO ObserverMock to test updates

	public void actionPerformed(ActionEvent e) {
		List<String> newDirComposition = Arrays.asList(this.acceptedFiles());
		Set<String> added = new HashSet<String>();
		Set<String> deleted = new HashSet<String>();

		for (String plugin : plugins)
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
	}
	
}