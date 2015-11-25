package plugins;

import java.io.File;
import java.util.Set;


public abstract class PluginObserver {

	public abstract void updateOnAddittion (File dir, Set<String> added);
	public abstract void updateOnDeletion (File dir, Set<String> deleted);
	
}
