package plugins;

import java.io.File;
import java.util.Set;


public abstract class PluginObserver {

	public PluginObserver(File directory) {
		this.subscribeAPluginFinder(new PluginFinder(directory));
	}
	
	public abstract void updateOnAddition (File dir, Set<String> added);
	public abstract void updateOnDeletion (File dir, Set<String> deleted);
	
	public void subscribeAPluginFinder (PluginFinder finder) {
		finder.subscribeAnObserver(this);
	}	
}
