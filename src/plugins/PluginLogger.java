package plugins;

import java.io.File;
import java.util.Set;

public class PluginLogger extends PluginObserver {

	@Override
	public void updateOnAddittion(File dir, Set<String> added) {
		for(String add : added)
			System.out.println(add + " added.");
	}

	@Override
	public void updateOnDeletion(File dir, Set<String> deleted) {
		for(String delete : deleted)
			System.out.println(delete + " deleted.");
	}


}
